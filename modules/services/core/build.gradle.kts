@file:Suppress("UnusedPrivateMember")

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    alias(libs.plugins.klibs.gradle.java.core)
    alias(libs.plugins.klibs.gradle.android.core)
    alias(libs.plugins.klibs.gradle.android.namespace)
}

kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    iosSimulatorArm64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Settings
                implementation(libs.mppsettings)
                // klibs
                implementation(libs.klibs.mikro.core)
                implementation(libs.klibs.mikro.platform)
                implementation(libs.klibs.kstorage)
                implementation(libs.klibs.kdi)
                // Ktor
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.contentNegitiation)
                implementation(libs.ktor.client.serialization)
                implementation(libs.ktor.client.json)
                implementation(libs.ktor.serialization.json)
                // Serialization
                implementation(libs.kotlin.serialization.json)
                // Coroutines
                implementation(libs.kotlin.coroutines.core)
                // Decompose
                implementation(libs.decompose.core)
            }
        }
    }
}
