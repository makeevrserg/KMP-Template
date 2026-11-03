@file:Suppress("UnusedPrivateMember")

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.android.kotlin.multiplatform.library")
    id("ru.astrainteractive.gradleplugin.java.version")
    id("ru.astrainteractive.gradleplugin.android.sdk")
    id("ru.astrainteractive.gradleplugin.android.java")
    id("ru.astrainteractive.gradleplugin.android.namespace")
    alias(libs.plugins.klibs.rules)
}

linter {
    unit(ru.astrainteractive.klibs.rules.core.unit.model.UnitRole.Impl())
    rootPackage.set("examplepackage.features.root.impl")
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
            implementation(libs.essenty)
            implementation(libs.klibs.kstorage)
            implementation(libs.klibs.mikro.core)
            implementation(libs.klibs.mikro.platform)
            implementation(libs.kotlin.coroutines.core)
            implementation(libs.kotlin.serialization.json)
            implementation(libs.ktor.client.contentNegitiation)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.json)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.logging)
            implementation(libs.ktor.serialization.json)
            implementation(libs.moko.resources.core)
            implementation(libs.mppsettings)
            implementation(libs.mvikotlin)
            implementation(projects.modules.features.splash.api)
            implementation(projects.modules.services.core.common)
            implementation(projects.modules.services.core.resources)
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
        androidMain.dependencies {
            implementation(libs.androidx.room.ktx)
            implementation(libs.ktor.client.cio)
        }
        jvmMain.dependencies {
            implementation(libs.ktor.client.cio)
        }
    }
}
