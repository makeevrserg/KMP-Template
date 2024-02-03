package com.makeevrserg.applicationtemplate.mobile.features.splash.presentation

import com.arkivanov.decompose.ComponentContext
import com.makeevrserg.applicationtemplate.mobile.features.splash.di.SplashComponentDependencies
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

internal class DefaultSplashComponent(
    componentContext: ComponentContext,
    dependencies: SplashComponentDependencies
) : SplashComponent,
    SplashComponentDependencies by dependencies,
    ComponentContext by componentContext {
    private val _screenChannel = Channel<SplashComponent.Label>()
    override val screenChannelFlow = _screenChannel.consumeAsFlow()

    init {
        mainScope.launch(dispatchers.IO) {
            val isInitialLaunch = repository.isInitialLaunch()
            val label = SplashComponent.Label.InitialLaunch(isInitialLaunch)
            _screenChannel.send(label)
        }
    }
}
