@file:OptIn(ExperimentalEncodingApi::class)
@file:Suppress("UnusedPrivateProperty")

import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import ru.astrainteractive.gradleplugin.property.util.requireProjectInfo
import kotlin.io.encoding.ExperimentalEncodingApi


plugins {
    kotlin("plugin.serialization")
    id("org.jetbrains.kotlin.multiplatform")
    id("ru.astrainteractive.gradleplugin.java.version")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.compose")
    alias(libs.plugins.klibs.rules)
}

linter {
    unitKind.set("entry-point")
}

kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    js(IR) {
        browser {
            useCommonJs()
            commonWebpackConfig {
                configDirectory = File("instances/cmp/webpack.config.d")
            }
        }
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.jetbrains.compose.runtime)
                implementation(libs.jetbrains.compose.foundation)
                implementation(libs.jetbrains.compose.material)
                implementation(libs.jetbrains.compose.ui)
            }
            dependencies {
                // Kotlin
                implementation(libs.kotlin.serialization.json)
                // Coroutines
                implementation(libs.kotlin.coroutines.core)
                // klibs
                implementation(libs.klibs.mikro.core)
                implementation(libs.klibs.mikro.platform)
                implementation(libs.klibs.kstorage)
                // moko
                implementation(libs.moko.resources.core)
                // Decompose
                implementation(libs.decompose.core)
                implementation(libs.decompose.compose)
                implementation(libs.essenty)
                // Local
                implementation(projects.modules.features.root.impl)
                implementation(projects.modules.features.root.ui)
                implementation(projects.modules.features.splash.impl)
                implementation(projects.modules.features.theme.impl)
                implementation(projects.modules.features.theme.ui)
                implementation(projects.modules.services.core.common)
                implementation(projects.modules.services.core.ui.common)
                implementation(projects.modules.services.core.ui.theme)
                implementation(projects.modules.services.core.resources)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(
                TargetFormat.Dmg,
                TargetFormat.Msi,
                TargetFormat.Deb
            )
            packageName = "jvm"
            packageVersion = requireProjectInfo.versionString
        }
    }
}

val jsPackageDirectory = rootProject.layout.buildDirectory
    .dir("js")
    .map { dir -> dir.dir("packages") }
    .map { dir -> dir.dir("Application-Template-instances-cmp") }
    .map { dir -> dir.dir("kotlin") }

val copySharedResources = project.tasks.register<Copy>("copyJsResources") {
    dependsOn("jsProductionExecutableCompileSync")
    from(
        project.project(projects.modules.services.core.resources.path)
            .layout.buildDirectory
            .dir("generated/moko-resources/jsMain/res")
    )
    into(jsPackageDirectory)
}

val copySkikoReexportSymbols = project.tasks.register<Copy>("copySkikoReexportSymbols") {
    dependsOn(
        "jsProductionExecutableCompileSync",
        "jsDevelopmentExecutableCompileSync",
        copySharedResources
    )
    from(jsPackageDirectory.map { dir -> dir.file("js-reexport-symbols.mjs") })
    into(jsPackageDirectory)
    rename { "js-skiko-reexport-symbols.mjs" }
}

tasks.named("jsBrowserProductionWebpack") {
    dependsOn(copySkikoReexportSymbols)
}

tasks.named("jsBrowserDevelopmentWebpack") {
    dependsOn(copySkikoReexportSymbols)
}
