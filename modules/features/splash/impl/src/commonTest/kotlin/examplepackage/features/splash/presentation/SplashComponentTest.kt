package examplepackage.features.splash.presentation

import app.cash.turbine.test
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import examplepackage.features.splash.data.SplashComponentRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.runBlocking
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class SplashComponentTest {
    private val componentContext = DefaultComponentContext(LifecycleRegistry())

    private fun buildComponent(isInitialLaunch: Boolean) = DefaultSplashComponent(
        componentContext = componentContext,
        mainScope = MainScope(),
        dispatchers = DefaultKotlinDispatchers,
        repository = object : SplashComponentRepository {
            override fun isInitialLaunch(): Boolean = isInitialLaunch
        }
    )

    @Test
    fun TEST_initial_launch_true(): Unit = runBlocking {
        val expectInitialLaunchValue = true
        val splashComponent = buildComponent(expectInitialLaunchValue)
        splashComponent.screenChannelFlow.test {
            val item = awaitItem()
            assertTrue(item is SplashComponent.Label.InitialLaunch)
            assertEquals(expectInitialLaunchValue, item.value)
        }
    }

    @Test
    fun TEST_initial_launch_false(): Unit = runBlocking {
        val expectInitialLaunchValue = false
        val splashComponent = buildComponent(expectInitialLaunchValue)
        splashComponent.screenChannelFlow.test {
            val item = awaitItem()
            assertTrue(item is SplashComponent.Label.InitialLaunch)
            assertEquals(expectInitialLaunchValue, item.value)
        }
    }
}
