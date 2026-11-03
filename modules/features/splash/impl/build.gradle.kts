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
    rootPackage.set("examplepackage.features.splash.impl")
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
            implementation(libs.decompose.core)
            implementation(libs.klibs.kstorage)
            implementation(libs.klibs.mikro.core)
            implementation(libs.klibs.mikro.platform)
            implementation(libs.kotlin.coroutines.core)
            implementation(projects.modules.features.splash.api)
            implementation(projects.modules.services.core.common)
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.kotlin.coroutines.test)
            implementation(libs.tests.assertk)
            implementation(libs.tests.turbine)
        }
    }
}
