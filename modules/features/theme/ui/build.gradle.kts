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
                // Compose MPP
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.runtime)
                // Local
                implementation(projects.modules.services.core.ui.common)
                implementation(projects.modules.services.core.ui.theme)
                implementation(projects.modules.features.theme.impl)
            }
        }
        val androidMain by getting {
            dependencies {
                // Accompanist
                implementation(libs.google.accompanist.systemuicontroller)
            }
        }
    }
}
