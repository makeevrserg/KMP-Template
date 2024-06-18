import ru.astrainteractive.gradleplugin.property.PropertyValue.Companion.baseGradleProperty
import ru.astrainteractive.gradleplugin.property.PropertyValue.Companion.secretProperty
import ru.astrainteractive.gradleplugin.property.extension.ModelPropertyValueExt.requireProjectInfo
import ru.astrainteractive.gradleplugin.property.extension.PrimitivePropertyValueExt.requireInt
import ru.astrainteractive.gradleplugin.property.extension.PrimitivePropertyValueExt.stringOrEmpty
import ru.astrainteractive.gradleplugin.util.Base64Util

plugins {
    kotlin("plugin.serialization")
    id("com.android.application")
    id("kotlin-android")
    id("ru.astrainteractive.gradleplugin.java.core")
    id("ru.astrainteractive.gradleplugin.android.core")
    id("ru.astrainteractive.gradleplugin.android.apk.name")
    alias(libs.plugins.kotlin.compose.gradle)
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
        setProperty(
            "archivesBaseName",
            "${requireProjectInfo.name}-${requireProjectInfo.versionString}"
        )
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
        val secretKeyAlias = secretProperty("KEY_ALIAS").stringOrEmpty
        val secretKeyPassword = secretProperty("KEY_PASSWORD").stringOrEmpty
        val secretStorePassword = secretProperty("STORE_PASSWORD").stringOrEmpty
        if (!keyStoreFile.exists()) {
            logger.warn("Keystore file not exists - creating")
            val base64String = secretProperty("KEYSTORE_BASE64").stringOrEmpty
            if (base64String.isNotBlank()) Base64Util.fromBase64(base64String, keyStoreFile)
        }
        if (!keyStoreFile.exists()) {
            logger.warn("Keystore file could not be created")
        }
        getByName("debug") {
            if (keyStoreFile.exists()) {
                keyAlias = secretKeyAlias
                keyPassword = secretKeyPassword
                storePassword = secretStorePassword
                storeFile = keyStoreFile
            }
        }
        create("release") {
            if (keyStoreFile.exists()) {
                keyAlias = secretKeyAlias
                keyPassword = secretKeyPassword
                storePassword = secretStorePassword
                storeFile = keyStoreFile
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
            signingConfig = signingConfigs.getByName("release")
        }
        debug {
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    buildFeatures {
        compose = true
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
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation(libs.google.auth)
    implementation(libs.kotlin.coroutines.playServices)
    implementation(libs.google.firebase.crsahlytics.ktx)
    debugImplementation(libs.leakcanary)
    // klibs
    implementation(libs.klibs.mikro.core)
    implementation(libs.klibs.mikro.platform)
    implementation(libs.klibs.kstorage)
    implementation(libs.klibs.kdi)
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
    implementation(projects.modules.services.coreUi)
    implementation(projects.modules.services.coreResources)
}
