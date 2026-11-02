package examplepackage.features.splash.api.stub

import examplepackage.features.splash.api.component.SplashComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class StubSplashComponent : SplashComponent {
    override val screenChannelFlow: Flow<SplashComponent.Label> = emptyFlow()
}
