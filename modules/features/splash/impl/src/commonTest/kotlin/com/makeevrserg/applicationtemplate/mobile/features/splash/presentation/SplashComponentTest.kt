package examplepackage.features.splash.presentation

import app.cash.turbine.test
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import examplepackage.features.splash.data.SplashComponentRepository
import examplepackage.features.splash.di.SplashComponentDependencies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.runBlocking
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class SplashComponentTest {
    private fun buildModule(isInitialLaunch: Boolean) = object : SplashComponentDependencies {
        override val mainScope: CoroutineScope = MainScope()
        override val dispatchers: KotlinDispatchers = DefaultKotlinDispatchers
        override val repository: SplashComponentRepository = object : SplashComponentRepository {
            override fun isInitialLaunch(): Boolean = isInitialLaunch
        }
    }

    private val componentContext = DefaultComponentContext(LifecycleRegistry())

    @Test
    fun TEST_initial_launch_true(): Unit = runBlocking {
        val expectInitialLaunchValue = true
        val splashComponent =
            DefaultSplashComponent(componentContext, buildModule(expectInitialLaunchValue))
        splashComponent.screenChannelFlow.test {
            val item = awaitItem()
            assertTrue(item is SplashComponent.Label.InitialLaunch)
            assertEquals(expectInitialLaunchValue, item.value)
        }
    }

    @Test
    fun TEST_initial_launch_false(): Unit = runBlocking {
        val expectInitialLaunchValue = false
        val splashComponent =
            DefaultSplashComponent(componentContext, buildModule(expectInitialLaunchValue))
        splashComponent.screenChannelFlow.test {
            val item = awaitItem()
            assertTrue(item is SplashComponent.Label.InitialLaunch)
            assertEquals(expectInitialLaunchValue, item.value)
        }
    }
}
