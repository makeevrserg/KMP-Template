package examplepackage.features.screen.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import examplepackage.features.root.di.RootModule
import examplepackage.features.screen.di.factory.RootScreenComponentChildFactory

internal class DefaultRootScreenComponent(
    componentContext: ComponentContext,
    rootModule: RootModule,
) : RootScreenComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<RootScreenComponent.Configuration>()

    override val childStack: Value<ChildStack<*, RootScreenComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = RootScreenComponent.Configuration.Splash,
        handleBackButton = true,
        serializer = RootScreenComponent.Configuration.serializer(),
        childFactory = { config, context ->
            RootScreenComponentChildFactory(
                config = config,
                componentContext = context,
                rootModule = rootModule,
            ).create()
        }
    )

    override fun push(configuration: RootScreenComponent.Configuration) {
        navigation.push(configuration)
    }

    override fun replaceCurrent(configuration: RootScreenComponent.Configuration) {
        navigation.replaceCurrent(configuration)
    }

    override fun replaceAll(configuration: RootScreenComponent.Configuration) {
        navigation.replaceAll(configuration)
    }

    override fun pop() {
        navigation.pop()
    }
}
