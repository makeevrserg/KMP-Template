package examplepackage.features.splash.memory

import examplepackage.features.splash.api.SplashComponentRepository

internal class InMemorySplashComponentRepository : SplashComponentRepository {
    override fun isInitialLaunch(): Boolean {
        return true
    }
}
