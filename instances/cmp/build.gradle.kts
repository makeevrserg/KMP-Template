@file:OptIn(ExperimentalEncodingApi::class)
@file:Suppress("UnusedPrivateProperty")

import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import ru.astrainteractive.gradleplugin.property.extension.ModelPropertyValueExt.requireProjectInfo
import kotlin.io.encoding.ExperimentalEncodingApi


plugins {
    kotlin("plugin.serialization")
    id("org.jetbrains.kotlin.multiplatform")
    id("ru.astrainteractive.gradleplugin.java.version")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.compose")
}

kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.jetbrains.compose.runtime)
                implementation(libs.jetbrains.compose.foundation)
                implementation(libs.jetbrains.compose.material)
                implementation(libs.jetbrains.compose.ui)
                implementation(libs.jetbrains.compose.resources)
                implementation(libs.jetbrains.compose.preview)
                implementation(compose.desktop.currentOs)
            }
            dependencies {
                // Kotlin
                implementation(libs.kotlin.serialization.json)
                // Coroutines
                implementation(libs.kotlin.coroutines.core)
                implementation(libs.kotlin.coroutines.android)
                // klibs
                implementation(libs.klibs.mikro.core)
                implementation(libs.klibs.mikro.platform)
                implementation(libs.klibs.kstorage)
                // moko
                implementation(libs.moko.resources.core)
                // Decompose
                implementation(libs.decompose.core)
                implementation(libs.decompose.compose)
                // Local
                implementation(projects.modules.features.root.impl)
                implementation(projects.modules.features.root.ui)
                implementation(projects.modules.features.theme.ui)
                implementation(projects.modules.services.core.ui.common)
                implementation(projects.modules.services.core.ui.theme)
                implementation(projects.modules.services.core.resources)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "jvm"
            packageVersion = requireProjectInfo.versionString
        }
    }
}
