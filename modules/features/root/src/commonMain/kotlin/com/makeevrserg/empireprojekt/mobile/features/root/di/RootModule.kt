package com.makeevrserg.empireprojekt.mobile.features.root.di

import com.makeevrserg.empireprojekt.mobile.features.logic.splash.di.SplashComponentModule
import ru.astrainteractive.klibs.kdi.Module

interface RootModule : Module {

    val servicesModule: ServicesModule
    val splashModule: SplashComponentModule
    val componentsModule: ComponentsModule
}
