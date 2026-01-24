@file:Suppress("UnusedPrivateMember")

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
    id("ru.astrainteractive.gradleplugin.java.version")
    id("ru.astrainteractive.gradleplugin.android.sdk")
    id("ru.astrainteractive.gradleplugin.android.namespace")
}

kotlin {
    applyDefaultHierarchyTemplate()
    androidLibrary {}
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    iosSimulatorArm64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                // klibs
                implementation(libs.klibs.mikro.core)
                implementation(libs.klibs.kstorage)
                // Settings
                implementation(libs.mppsettings)
                // Decompose
                implementation(libs.decompose.core)
                // Coroutines
                implementation(libs.kotlin.coroutines.core)
            }
        }
    }
}
