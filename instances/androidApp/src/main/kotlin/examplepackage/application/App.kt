package examplepackage.application

import android.app.Application
import android.content.Context
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import examplepackage.features.root.di.RootModule
import kotlinx.coroutines.cancel
import ru.astrainteractive.klibs.mikro.platform.DefaultAndroidPlatformConfiguration

class App : Application() {
    val rootModule by lazy {
        RootModule.Default()
    }

    override fun onTerminate() {
        super.onTerminate()
        rootModule.coreModule.mainScope.cancel()
    }

    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(this)
        rootModule.coreModule.platformConfigurationInternal = DefaultAndroidPlatformConfiguration(applicationContext)
    }

    companion object {
        fun Application.asMyApplication(): App = (this as App)
        fun Context.asMyApplication(): App = (applicationContext as App)
    }
}
