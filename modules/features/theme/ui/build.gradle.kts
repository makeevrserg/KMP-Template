@file:Suppress("UnusedPrivateMember")

import ru.astrainteractive.gradleplugin.property.extension.ModelPropertyValueExt.requireProjectInfo

plugins {
    id("org.jetbrains.compose")
    id("com.android.library")
    kotlin("multiplatform")
    id("ru.astrainteractive.gradleplugin.java.core")
    id("ru.astrainteractive.gradleplugin.android.core")
    id("ru.astrainteractive.gradleplugin.android.compose")
}

kotlin {
    android()
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Compose MPP
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.runtime)
//                implementation(compose.uiTooling)
//                implementation(compose.preview)
//                implementation(compose.material)
                // Moko
//                implementation(libs.moko.resources.core)
                // Decompose
//                implementation(libs.decompose.core)
                // klibs
//                implementation(libs.klibs.mikro.extensions)
                // Local
//                implementation(projects.modules.services.coreResources)
                implementation(projects.modules.services.coreUi)
//                implementation(projects.modules.features.splash.impl)
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

android {
    namespace = "${requireProjectInfo.group}.features.theme.ui"
}
