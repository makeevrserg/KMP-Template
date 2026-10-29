package examplepackage.features.splash.di

import kotlinx.coroutines.CoroutineScope
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers

fun buildSplashModule(
    mainScope: CoroutineScope,
    dispatchers: KotlinDispatchers
): SplashModule {
    return SplashModule.Default(
        mainScope = mainScope,
        dispatchers = dispatchers
    )
}
