package examplepackage.features.splash.data

internal class SplashComponentRepositoryImpl : SplashComponentRepository {
    override fun isInitialLaunch(): Boolean {
        return true
    }
}
