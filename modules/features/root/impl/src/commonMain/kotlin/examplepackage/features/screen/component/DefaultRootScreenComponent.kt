package examplepackage.features.screen.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.router.stack.childStack as createChildStack

internal class DefaultRootScreenComponent(
    componentContext: ComponentContext,
    childFactory: (RootScreenComponent.Configuration, ComponentContext) -> RootScreenComponent.Child,
) : RootScreenComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<RootScreenComponent.Configuration>()

    override val childStack: Value<ChildStack<*, RootScreenComponent.Child>> = createChildStack(
        source = navigation,
        initialConfiguration = RootScreenComponent.Configuration.Splash,
        handleBackButton = true,
        serializer = RootScreenComponent.Configuration.serializer(),
        childFactory = childFactory
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
