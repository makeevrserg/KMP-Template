package examplepackage.features.splash.presentation

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.splash.di.SplashComponentDependencies
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

internal class DefaultSplashComponent(
    componentContext: ComponentContext,
    dependencies: SplashComponentDependencies
) : SplashComponent,
    SplashComponentDependencies by dependencies,
    ComponentContext by componentContext {
    private val _screenChannel = Channel<SplashComponent.Label>()
    override val screenChannelFlow = _screenChannel.receiveAsFlow()

    init {
        mainScope.launch(dispatchers.IO) {
            val isInitialLaunch = repository.isInitialLaunch()
            val label = SplashComponent.Label.InitialLaunch(isInitialLaunch)
            _screenChannel.send(label)
        }
    }
}
