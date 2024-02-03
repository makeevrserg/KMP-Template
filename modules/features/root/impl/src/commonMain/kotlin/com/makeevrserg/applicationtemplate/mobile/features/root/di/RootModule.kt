package com.makeevrserg.applicationtemplate.mobile.features.root.di

import com.makeevrserg.applicationtemplate.mobile.features.splash.di.SplashModule
import com.makeevrserg.applicationtemplate.mobile.features.theme.di.ThemeSwitcherModule
import com.makeevrserg.applicationtemplate.mobile.services.core.di.CoreModule
import ru.astrainteractive.klibs.kdi.Module
import ru.astrainteractive.klibs.kdi.Single
import ru.astrainteractive.klibs.kdi.getValue

interface RootModule : Module {

    val coreModule: CoreModule
    val themeSwitcherModule: ThemeSwitcherModule
    val splashModule: SplashModule

    class Default : RootModule {

        override val coreModule: CoreModule by Single {
            CoreModule.Default()
        }

        override val themeSwitcherModule: ThemeSwitcherModule by lazy {
            ThemeSwitcherModule.Default(coreModule.settings.value)
        }
        override val splashModule: SplashModule by lazy {
            SplashModule.Default(coreModule = coreModule)
        }
    }
}
