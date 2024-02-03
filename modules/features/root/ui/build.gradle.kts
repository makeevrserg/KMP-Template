@file:Suppress("UnusedPrivateMember")

import ru.astrainteractive.gradleplugin.util.ProjectProperties.projectInfo

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
                implementation(compose.uiTooling)
                implementation(compose.preview)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                // klibs
                implementation(libs.klibs.mikro.core)
                implementation(libs.klibs.mikro.platform)
                implementation(libs.klibs.kstorage)
                implementation(libs.klibs.kdi)
                // Moko
                implementation(libs.moko.resources.core)
                // Decompose
                implementation(libs.decompose.core)
                implementation(libs.decompose.compose.jetbrains)
                // Local
                implementation(projects.modules.services.resources)
                implementation(projects.modules.services.coreUi)
                implementation(projects.modules.services.buildKonfig)
                implementation(projects.modules.features.splash.impl)
                implementation(projects.modules.features.splash.ui)
                implementation(projects.modules.features.root.impl)
                implementation(projects.modules.features.theme)
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
    namespace = "${projectInfo.group}.features.ui.splash"
}
