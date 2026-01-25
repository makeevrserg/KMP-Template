@file:Suppress("UnusedPrivateMember")

import ru.astrainteractive.gradleplugin.property.extension.ModelPropertyValueExt.hierarchyGroup

plugins {
    id("ru.astrainteractive.mokoresources.multiplatform-resources")
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
    id("ru.astrainteractive.gradleplugin.java.version")
    id("ru.astrainteractive.gradleplugin.android.sdk")
    id("ru.astrainteractive.gradleplugin.android.java")
    id("ru.astrainteractive.gradleplugin.android.namespace")
}

kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    androidLibrary {}
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
