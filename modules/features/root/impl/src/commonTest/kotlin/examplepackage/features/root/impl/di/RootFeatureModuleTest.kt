@file:Suppress("FunctionNaming")

package examplepackage.features.root.impl.di

import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import examplepackage.features.root.impl.screen.component.RootScreenComponent
import examplepackage.features.splash.api.component.SplashComponent
import examplepackage.features.splash.api.stub.StubSplashComponent
import kotlin.test.Test
import kotlin.test.assertIs
import kotlin.test.assertNotSame
import kotlin.test.assertSame

internal class RootFeatureModuleTest {
    @Test
    fun GIVEN_injected_splash_factory_WHEN_root_is_created_THEN_initial_screen_uses_its_component() {
        val splashComponent = StubSplashComponent()
        val module = RootFeatureModule(SplashComponent.Factory { splashComponent })
        val componentContext = DefaultComponentContext(LifecycleRegistry())

        val rootComponent = module.createRootComponent(componentContext)

        val child = rootComponent.rootScreenComponent.childStack.value.active.instance
        assertIs<RootScreenComponent.Child.Splash>(child)
        assertSame(splashComponent, child.splashComponent)
    }

    @Test
    fun GIVEN_two_roots_WHEN_created_THEN_each_has_its_own_splash_component() {
        val module = RootFeatureModule(SplashComponent.Factory { StubSplashComponent() })

        val firstRoot = module.createRootComponent(DefaultComponentContext(LifecycleRegistry()))
        val secondRoot = module.createRootComponent(DefaultComponentContext(LifecycleRegistry()))

        val firstChild = firstRoot.rootScreenComponent.childStack.value.active.instance
        val secondChild = secondRoot.rootScreenComponent.childStack.value.active.instance
        assertIs<RootScreenComponent.Child.Splash>(firstChild)
        assertIs<RootScreenComponent.Child.Splash>(secondChild)
        assertNotSame(firstChild.splashComponent, secondChild.splashComponent)
    }
}
