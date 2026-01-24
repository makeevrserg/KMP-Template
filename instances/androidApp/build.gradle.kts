@file:OptIn(ExperimentalEncodingApi::class)

import com.android.build.gradle.internal.tasks.ValidateSigningTask
import ru.astrainteractive.gradleplugin.plugin.secretfile.SecretFileTask
import ru.astrainteractive.gradleplugin.property.baseGradleProperty
import ru.astrainteractive.gradleplugin.property.extension.ModelPropertyValueExt.requireProjectInfo
import ru.astrainteractive.gradleplugin.property.extension.PrimitivePropertyValueExt.requireInt
import ru.astrainteractive.gradleplugin.property.extension.PrimitivePropertyValueExt.stringOrEmpty
import ru.astrainteractive.gradleplugin.property.secretProperty
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi


plugins {
    kotlin("plugin.serialization")
    id("com.android.application")
    id("ru.astrainteractive.gradleplugin.java.version")
    id("ru.astrainteractive.gradleplugin.android.sdk")
    id("ru.astrainteractive.gradleplugin.android.apk.name")
    id("ru.astrainteractive.gradleplugin.android.apk.sign")
    id("ru.astrainteractive.gradleplugin.android.compose")
    alias(libs.plugins.kotlin.compose.gradle)
}

tasks.register<SecretFileTask>("exportKeystore") {
    targetFile = file("keystore.jks")
    base64 = secretProperty("KEYSTORE_BASE64").stringOrEmpty
    tasks.withType<ValidateSigningTask>().all {
        this.dependsOn(this@register)
    }
}

android {
    namespace = "${requireProjectInfo.group}"
    if (file("google-services.json").exists()) {
        apply(plugin = "com.google.gms.google-services")
        apply(plugin = "com.google.firebase.crashlytics")
    }
    defaultConfig {
        applicationId = requireProjectInfo.group
        versionCode = baseGradleProperty("project.version.code").requireInt
        versionName = requireProjectInfo.versionString
    }
    defaultConfig {
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        val keyStoreFile = file("keystore.jks")
        if (!keyStoreFile.exists()) {
            logger.warn("Keystore file not exists - creating")
            val base64String = secretProperty("KEYSTORE_BASE64").stringOrEmpty
            if (base64String.isNotBlank()) {
                val byteArray = Base64.decode(base64String)
                keyStoreFile.createNewFile()
                keyStoreFile.writeBytes(byteArray)
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug { isDebuggable = true }
    }
    lint {
        abortOnError = false
    }
}

dependencies {
    // Kotlin
    implementation(libs.kotlin.serialization.json)
    // Coroutines
    implementation(libs.kotlin.coroutines.core)
    implementation(libs.kotlin.coroutines.android)
    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material:material")
    implementation(libs.androidx.splash)
    // FireBase
    implementation(platform(libs.google.firebase.bom))
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-messaging")
    implementation("com.google.firebase:firebase-analytics")
    implementation(libs.google.auth)
    implementation(libs.kotlin.coroutines.playServices)
    implementation(libs.google.firebase.crsahlytics)
    debugImplementation(libs.leakcanary)
    // klibs
    implementation(libs.klibs.mikro.core)
    implementation(libs.klibs.mikro.platform)
    implementation(libs.klibs.kstorage)
    // moko
    implementation(libs.moko.resources.core)
    // Decompose
    implementation(libs.decompose.core)
    implementation(libs.decompose.compose)
    implementation(libs.decompose.android)
    // Local
    implementation(projects.modules.features.root.impl)
    implementation(projects.modules.features.root.ui)
    implementation(projects.modules.features.theme.ui)
    implementation(projects.modules.services.core.ui.common)
    implementation(projects.modules.services.core.ui.theme)
    implementation(projects.modules.services.core.resources)
}
