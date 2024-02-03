package com.makeevrserg.empireprojekt.mobile.features.splash.di

import com.makeevrserg.empireprojekt.mobile.features.splash.data.SplashComponentRepository
import com.makeevrserg.empireprojekt.mobile.features.splash.data.SplashComponentRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import ru.astrainteractive.klibs.kdi.Module
import ru.astrainteractive.klibs.kdi.Provider
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers

internal interface SplashComponentDependencies : Module {
    val mainScope: CoroutineScope
    val dispatchers: KotlinDispatchers
    val repository: SplashComponentRepository

    class Default(
        override val mainScope: CoroutineScope,
        override val dispatchers: KotlinDispatchers
    ) : SplashComponentDependencies {
        override val repository: SplashComponentRepository = Provider {
            SplashComponentRepositoryImpl()
        }.provide()
    }
}
