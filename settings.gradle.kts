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
// Instances
include(":instances:androidApp")
// Services
include(":modules:services:resources")
include(":modules:services:core-ui")
include(":modules:services:core")
include(":modules:services:build-konfig")
// Feature
include(":modules:features:root:impl")
include(":modules:features:root:ui")
include(":modules:features:splash:impl")
include(":modules:features:splash:ui")
include(":modules:features:theme")
