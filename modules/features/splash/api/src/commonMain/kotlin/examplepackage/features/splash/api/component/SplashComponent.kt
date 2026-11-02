package examplepackage.features.splash.api.component

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.Flow

interface SplashComponent {
    val screenChannelFlow: Flow<Label>

    fun interface Factory {
        operator fun invoke(componentContext: ComponentContext): SplashComponent
    }

    sealed interface Label {
        class InitialLaunch(val value: Boolean) : Label
    }
}
