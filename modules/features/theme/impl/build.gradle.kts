@file:Suppress("UnusedPrivateMember")

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
    id("ru.astrainteractive.gradleplugin.java.version")
    id("ru.astrainteractive.gradleplugin.android.sdk")
    id("ru.astrainteractive.gradleplugin.android.java")
    id("ru.astrainteractive.gradleplugin.android.namespace")
    alias(libs.plugins.klibs.rules)
}

linter {
    unit(ru.astrainteractive.klibs.rules.core.unit.model.UnitRole.Impl())
    rootPackage.set("examplepackage.features.theme.impl")
}

kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    androidLibrary {}
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.decompose.core)
                implementation(libs.klibs.kstorage)
                implementation(libs.klibs.mikro.core)
                implementation(libs.kotlin.coroutines.core)
                implementation(libs.mppsettings)
            }
        }
    }
}
