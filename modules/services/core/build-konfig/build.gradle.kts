@file:Suppress("UnusedPrivateMember")

import ru.astrainteractive.gradleplugin.property.util.requireProjectInfo
import ru.astrainteractive.gradleplugin.property.util.requireVersionCode
import ru.astrainteractive.gradleplugin.util.hierarchyGroup


plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
    id("ru.astrainteractive.gradleplugin.java.version")
    id("ru.astrainteractive.gradleplugin.android.sdk")
    id("ru.astrainteractive.gradleplugin.android.java")
    id("ru.astrainteractive.gradleplugin.android.namespace")
    id("com.github.gmazzo.buildconfig")
}

buildConfig {
    className("BuildKonfig") // forces the class name. Defaults to 'BuildConfig'
    packageName(hierarchyGroup) // forces the package. Defaults to '${project.group}'
    buildConfigField(
        type = String::class.java,
        name = "VERSION_CODE",
        value = "$requireVersionCode"
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
    jvm()
    androidLibrary {}
    js(IR) {
        browser()
    }
}
