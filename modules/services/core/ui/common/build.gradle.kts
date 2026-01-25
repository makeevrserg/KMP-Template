@file:Suppress("UnusedPrivateMember")

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.android.kotlin.multiplatform.library")
    id("ru.astrainteractive.gradleplugin.java.version")
    id("ru.astrainteractive.gradleplugin.android.sdk")
    id("ru.astrainteractive.gradleplugin.android.java")
    id("ru.astrainteractive.gradleplugin.android.namespace")
}
kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    androidLibrary {}
    sourceSets {
        val commonMain by getting {
            dependencies {
                // klibs
                implementation(libs.klibs.mikro.core)
                implementation(libs.klibs.mikro.platform)
                implementation(libs.klibs.kstorage)
                // Decompose
                implementation(libs.decompose.core)
                implementation(libs.decompose.compose)
                // Moko
                implementation(libs.moko.resources.core)
                implementation(libs.moko.resources.compose)
                // Compose
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation(compose.runtime)
                // Local
                implementation(projects.modules.services.core.resources)
                implementation(projects.modules.services.core.common)
                implementation(projects.modules.services.core.ui.theme)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.google.accompanist.flowlayout)
            }
        }
    }
}
