@file:Suppress("UnusedPrivateMember")

import ru.astrainteractive.gradleplugin.property.extension.ModelPropertyValueExt.hierarchyGroup

plugins {
    id("dev.icerock.mobile.multiplatform-resources")
    id("com.android.library")
    kotlin("multiplatform")
    id("ru.astrainteractive.gradleplugin.java.core")
    id("ru.astrainteractive.gradleplugin.android.core")
    alias(libs.plugins.klibs.gradle.android.namespace)
}

kotlin {
    androidTarget()
    ios()
    iosSimulatorArm64()
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
