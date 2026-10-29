package examplepackage.features.splash.component

import app.cash.turbine.test
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import examplepackage.features.splash.api.SplashComponentRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.test.runTest
import ru.astrainteractive.klibs.mikro.core.dispatchers.DefaultKotlinDispatchers
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class SplashComponentTest {
    private val componentContext = DefaultComponentContext(LifecycleRegistry())

    private fun buildComponent(isInitialLaunch: Boolean): DefaultSplashComponent {
        return DefaultSplashComponent(
            componentContext = componentContext,
            mainScope = MainScope(),
            dispatchers = DefaultKotlinDispatchers,
            repository = object : SplashComponentRepository {
                override fun isInitialLaunch(): Boolean = isInitialLaunch
            }
        )
    }

    @Test
    fun GIVEN_initial_launch_true_WHEN_component_created_THEN_emits_initial_launch() {
        runTest {
            val expectInitialLaunchValue = true
            val splashComponent = buildComponent(expectInitialLaunchValue)
            splashComponent.screenChannelFlow.test {
                val item = awaitItem()
                assertTrue(item is SplashComponent.Label.InitialLaunch)
                assertEquals(expectInitialLaunchValue, item.value)
            }
        }
    }

    @Test
    fun GIVEN_initial_launch_false_WHEN_component_created_THEN_emits_initial_launch() {
        runTest {
            val expectInitialLaunchValue = false
            val splashComponent = buildComponent(expectInitialLaunchValue)
            splashComponent.screenChannelFlow.test {
                val item = awaitItem()
                assertTrue(item is SplashComponent.Label.InitialLaunch)
                assertEquals(expectInitialLaunchValue, item.value)
            }
        }
    }
}
