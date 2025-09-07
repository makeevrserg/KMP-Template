@file:Suppress("UnusedPrivateMember")

import ru.astrainteractive.gradleplugin.property.PropertyValue.Companion.baseGradleProperty
import ru.astrainteractive.gradleplugin.property.extension.ModelPropertyValueExt.hierarchyGroup
import ru.astrainteractive.gradleplugin.property.extension.ModelPropertyValueExt.requireProjectInfo
import ru.astrainteractive.gradleplugin.property.extension.PrimitivePropertyValueExt.requireInt

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("ru.astrainteractive.gradleplugin.java.core")
    id("com.github.gmazzo.buildconfig")
    id("ru.astrainteractive.gradleplugin.android.core")
    alias(libs.plugins.klibs.gradle.android.namespace)
}

buildConfig {
    className("BuildKonfig") // forces the class name. Defaults to 'BuildConfig'
    packageName(hierarchyGroup) // forces the package. Defaults to '${project.group}'
    buildConfigField(
        type = String::class.java,
        name = "VERSION_CODE",
        value = "${baseGradleProperty("project.version.code").requireInt}"
    )
    buildConfigField(
        type = String::class.java,
        name = "VERSION_NAME",
        value = requireProjectInfo.versionString
    )
    useKotlinOutput { internalVisibility = false }
}

kotlin {
    applyDefaultHierarchyTemplate()
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
}
