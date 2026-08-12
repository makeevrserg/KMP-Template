pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "Application-Template"

include(":instances:androidApp")
include(":instances:cmp")

include(":modules:services:core:common")
include(":modules:services:core:resources")
include(":modules:services:core:build-konfig")
include(":modules:services:core:ui:common")
include(":modules:services:core:ui:theme")
include(":modules:features:root:impl")
include(":modules:features:root:ui")
include(":modules:features:splash:impl")
include(":modules:features:splash:ui")
include(":modules:features:theme:impl")
include(":modules:features:theme:ui")
include(":modules:features:info:ui")
