package com.makeevrserg.empireprojekt.mobile.features.root.di

import com.makeevrserg.empireprojekt.mobile.features.splash.di.SplashComponentModule
import com.makeevrserg.empireprojekt.mobile.features.theme.di.ThemeSwitcherModule
import com.makeevrserg.empireprojekt.mobile.services.core.di.CoreModule
import ru.astrainteractive.klibs.kdi.Module
import ru.astrainteractive.klibs.kdi.Provider
import ru.astrainteractive.klibs.kdi.Single
import ru.astrainteractive.klibs.kdi.getValue

interface RootModule : Module {

    val coreModule: CoreModule
    val splashModule: SplashComponentModule
    val themeSwitcherModule: ThemeSwitcherModule

    class Default : RootModule {

        override val coreModule: CoreModule by Single {
            CoreModule.Default()
        }

        override val splashModule: SplashComponentModule by Provider {
            SplashComponentModule.Default(
                mainScope = coreModule.mainScope.value,
                dispatchers = coreModule.dispatchers.value
            )
        }

        override val themeSwitcherModule: ThemeSwitcherModule by lazy {
            ThemeSwitcherModule.Default(coreModule.settings.value)
        }
    }
}
