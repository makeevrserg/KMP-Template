package examplepackage.features.splash.impl.memory

import examplepackage.features.splash.impl.api.SplashComponentRepository

internal class InMemorySplashComponentRepository : SplashComponentRepository {
    override fun isInitialLaunch(): Boolean {
        return true
    }
}
