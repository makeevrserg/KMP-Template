@file:Suppress("UnusedPrivateMember")

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.android.kotlin.multiplatform.library")
    id("ru.astrainteractive.gradleplugin.java.version")
    id("ru.astrainteractive.gradleplugin.android.sdk")
    id("ru.astrainteractive.gradleplugin.android.java")
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
                // Settings
                implementation(libs.mppsettings)
                // klibs
                implementation(libs.klibs.mikro.core)
                api(libs.klibs.mikro.platform)
                implementation(libs.klibs.kstorage)
                // Decompose
                api(libs.decompose.core)
                api(libs.essenty)
                // Ktor
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.contentNegitiation)
                implementation(libs.ktor.client.serialization)
                implementation(libs.ktor.client.json)
                implementation(libs.ktor.serialization.json)
                implementation(libs.ktor.logging)
                // Moko
                api(libs.moko.mvvm.core)
                api(libs.moko.mvvm.flow)
                implementation(libs.moko.resources.core)
                // Serialization
                implementation(libs.kotlin.serialization.json)
                // Coroutines
                implementation(libs.kotlin.coroutines.core)
                // MVIKotlin
                implementation(libs.mvikotlin)
                // Local
                api(projects.modules.services.core.resources)
                api(projects.modules.services.core.common)
                api(projects.modules.features.splash.impl)
                api(projects.modules.features.theme.impl)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.room.ktx)
                implementation(libs.ktor.client.cio)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

// dependencies {
//    // FireBase
//    implementation(platform(libs.google.firebase.bom))
//    implementation("com.google.firebase:firebase-auth")
//    implementation("com.google.firebase:firebase-common")
//    implementation("com.google.firebase:firebase-firestore")
//    implementation("com.google.firebase:firebase-messaging")
//    implementation(libs.klibs.kstorage)
//    implementation(libs.google.auth)
//    implementation(libs.kotlin.coroutines.playServices)
//    implementation("io.ktor:ktor-client-logging-jvm:${libs.versions.ktor.get()}")
// }
