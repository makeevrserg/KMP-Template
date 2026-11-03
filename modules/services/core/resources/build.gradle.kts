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
    alias(libs.plugins.klibs.rules)
}

linter {
    unit(ru.astrainteractive.klibs.rules.core.unit.model.UnitRole.Core())
    rootPackage.set("com.makeevrserg.applicationtemplate.modules.services.core.resources")
}

kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    android {}
    js {
        browser()
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.moko.resources.core)
        }
        androidMain.dependencies {
            implementation(libs.android.material)
            implementation(libs.androidx.splash)
        }
    }
}

multiplatformResources {
    resourcesPackage = hierarchyGroup
    resourcesClassName = "CoreR"
}
