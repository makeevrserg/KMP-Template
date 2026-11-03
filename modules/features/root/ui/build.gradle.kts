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
    alias(libs.plugins.klibs.rules)
}

linter {
    unit(
        ru.astrainteractive.klibs.rules.core.unit.model.UnitRole.ImplUi(
            composition = ru.astrainteractive.klibs.rules.core.unit.model.UiComposition.HOST
        )
    )
    rootPackage.set("examplepackage.features.root.ui")
}

kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    android {}
    js {
        browser()
        binaries.executable()
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.decompose.compose)
            implementation(libs.decompose.core)
            implementation(libs.jetbrains.compose.foundation)
            implementation(libs.jetbrains.compose.material)
            implementation(libs.jetbrains.compose.runtime)
            implementation(libs.jetbrains.compose.ui)
            implementation(libs.klibs.kstorage)
            implementation(libs.klibs.mikro.core)
            implementation(libs.klibs.mikro.platform)
            implementation(libs.moko.resources.core)
            implementation(projects.modules.features.info.ui)
            implementation(projects.modules.features.root.impl)
            implementation(projects.modules.features.splash.api)
            implementation(projects.modules.features.splash.ui)
            implementation(projects.modules.services.core.buildKonfig)
            implementation(projects.modules.services.core.resources)
            implementation(projects.modules.services.core.ui.common)
            implementation(projects.modules.services.core.ui.theme)
        }
        androidMain.dependencies {
            implementation(libs.google.accompanist.systemuicontroller)
        }
    }
}
