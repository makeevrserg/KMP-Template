@file:OptIn(ExperimentalEncodingApi::class)

import com.android.build.gradle.internal.tasks.ValidateSigningTask
import ru.astrainteractive.gradle.property.api.secretProperty
import ru.astrainteractive.gradleplugin.property.util.requireProjectInfo
import ru.astrainteractive.gradleplugin.property.util.requireVersionCode
import ru.astrainteractive.gradleplugin.property.util.stringOrEmpty
import ru.astrainteractive.gradleplugin.task.SecretFileTask
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi


plugins {
    kotlin("plugin.serialization")
    id("com.android.application")
    id("ru.astrainteractive.gradleplugin.java.version")
    id("ru.astrainteractive.gradleplugin.android.sdk")
    id("ru.astrainteractive.gradleplugin.android.java")
    id("ru.astrainteractive.gradleplugin.android.apk.name")
    id("ru.astrainteractive.gradleplugin.android.apk.sign")
    id("ru.astrainteractive.gradleplugin.android.compose")
    alias(libs.plugins.kotlin.compose.gradle)
    alias(libs.plugins.klibs.rules)
}

linter {
    unit(ru.astrainteractive.klibs.rules.core.unit.model.UnitRole.EntryPoint())
    rootPackage.set("examplepackage")
}

configurations.named("api") {
    dependencies.removeIf { dependency ->
        dependency.group == "org.jetbrains.kotlin" && dependency.name == "kotlin-stdlib"
    }
}

tasks.register<SecretFileTask>("exportKeystore") {
    targetFile = file("keystore.jks")
    base64 = secretProperty("KEYSTORE_BASE64").stringOrEmpty
    tasks.withType<ValidateSigningTask>().all {
        this.dependsOn(this@register)
    }
}

android {
    namespace = "examplepackage"
    if (file("google-services.json").exists()) {
        apply(plugin = "com.google.gms.google-services")
        apply(plugin = "com.google.firebase.crashlytics")
    }
    defaultConfig {
        applicationId = requireProjectInfo.group
        versionCode = requireVersionCode
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
    debugImplementation(libs.leakcanary)
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui")
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-messaging")
    implementation(kotlin("stdlib"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.splash)
    implementation(libs.decompose.android)
    implementation(libs.decompose.compose)
    implementation(libs.decompose.core)
    implementation(libs.essenty)
    implementation(libs.google.auth)
    implementation(libs.google.firebase.crsahlytics)
    implementation(libs.klibs.kstorage)
    implementation(libs.klibs.mikro.core)
    implementation(libs.klibs.mikro.platform)
    implementation(libs.kotlin.coroutines.android)
    implementation(libs.kotlin.coroutines.core)
    implementation(libs.kotlin.coroutines.playServices)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.moko.resources.core)
    implementation(libs.mppsettings)
    implementation(platform(libs.androidx.compose.bom))
    implementation(platform(libs.google.firebase.bom))
    implementation(projects.modules.features.root.impl)
    implementation(projects.modules.features.root.ui)
    implementation(projects.modules.features.splash.api)
    implementation(projects.modules.features.splash.impl)
    implementation(projects.modules.features.theme.impl)
    implementation(projects.modules.features.theme.ui)
    implementation(projects.modules.services.core.common)
    implementation(projects.modules.services.core.resources)
    implementation(projects.modules.services.core.ui.common)
    implementation(projects.modules.services.core.ui.theme)
}
