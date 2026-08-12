package examplepackage.features.splash.presentation

import com.arkivanov.decompose.ComponentContext
import examplepackage.features.splash.data.SplashComponentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.astrainteractive.klibs.mikro.core.dispatchers.KotlinDispatchers

internal class DefaultSplashComponent(
    componentContext: ComponentContext,
    mainScope: CoroutineScope,
    dispatchers: KotlinDispatchers,
    repository: SplashComponentRepository
) : SplashComponent,
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
