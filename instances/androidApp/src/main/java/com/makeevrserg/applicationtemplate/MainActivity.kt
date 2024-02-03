package com.makeevrserg.applicationtemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.arkivanov.decompose.defaultComponentContext
import com.makeevrserg.applicationtemplate.application.App.Companion.asMyApplication
import com.makeevrserg.applicationtemplate.mobile.features.modal.ui.RootBottomSheetContent
import com.makeevrserg.applicationtemplate.mobile.features.root.di.RootModule
import com.makeevrserg.applicationtemplate.mobile.features.root.presentation.DefaultRootComponent
import com.makeevrserg.applicationtemplate.mobile.features.screen.ui.RootScreenContent
import com.makeevrserg.applicationtemplate.mobile.features.theme.ui.ApplicationTheme
import com.makeevrserg.applicationtemplate.resources.R

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    private val rootModule: RootModule
        get() = application.asMyApplication().rootModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setTheme(R.style.AppTheme)

        val componentContext = defaultComponentContext()
        val rootComponent = DefaultRootComponent(componentContext, rootModule)
        val rootBottomSheetComponent = rootComponent.rootBottomSheetComponent
        setContent {
            ApplicationTheme(rootModule.themeSwitcherModule.themeSwitcherComponent) {
                RootBottomSheetContent(rootBottomSheetComponent) {
                    RootScreenContent(
                        rootComponent = rootComponent,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}
