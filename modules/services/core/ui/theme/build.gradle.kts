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
    unit(ru.astrainteractive.klibs.rules.core.unit.model.UnitRole.CoreUi())
    rootPackage.set("examplepackage.core.ui.theme")
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
            implementation(libs.jetbrains.compose.material3)
            implementation(libs.jetbrains.compose.runtime)
            implementation(libs.jetbrains.compose.ui)
            implementation(libs.klibs.kstorage)
            implementation(libs.klibs.mikro.core)
            implementation(libs.klibs.mikro.platform)
            implementation(libs.moko.resources.compose)
            implementation(libs.moko.resources.core)
            implementation(projects.modules.services.core.common)
            implementation(projects.modules.services.core.resources)
        }
        androidMain.dependencies {
            implementation(libs.google.accompanist.flowlayout)
            implementation(libs.google.accompanist.systemuicontroller)
        }
    }
}
