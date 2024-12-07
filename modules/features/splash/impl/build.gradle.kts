@file:Suppress("UnusedPrivateMember")

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("ru.astrainteractive.gradleplugin.java.core")
    id("ru.astrainteractive.gradleplugin.android.core")
    alias(libs.plugins.klibs.gradle.android.namespace)
}

kotlin {
    applyDefaultHierarchyTemplate()
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    iosSimulatorArm64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Coroutines
                implementation(libs.kotlin.coroutines.core)
                // klibs
                implementation(libs.klibs.mikro.core)
                implementation(libs.klibs.mikro.platform)
                implementation(libs.klibs.kstorage)
                implementation(libs.klibs.kdi)
                // Decompose
                implementation(libs.decompose.core)
                // Local
                implementation(projects.modules.services.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.tests.assertk)
                implementation(libs.tests.turbine)
            }
        }
    }
}
