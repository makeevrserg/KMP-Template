@file:Suppress("UnusedPrivateMember")

import ru.astrainteractive.gradleplugin.util.hierarchyGroup

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
    id("ru.astrainteractive.gradleplugin.java.version")
    id("ru.astrainteractive.gradleplugin.android.sdk")
    id("ru.astrainteractive.gradleplugin.android.java")
    id("ru.astrainteractive.gradleplugin.android.namespace")
    alias(libs.plugins.moko.resources)
}

kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    androidLibrary {}
    js(IR) {
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.moko.resources.core)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.splash)
                implementation(libs.android.material)
            }
        }
    }
}

multiplatformResources {
    resourcesPackage = hierarchyGroup
    resourcesClassName = "CoreR"
}
