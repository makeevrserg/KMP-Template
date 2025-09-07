package examplepackage.features.splash.ui

import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import examplepackage.core.ui.theme.AdaptThemeFade
import examplepackage.core.ui.util.asPainter
import examplepackage.features.splash.di.SplashModule
import com.makeevrserg.applicationtemplate.modules.services.core.resources.CoreR
import examplepackage.core.ui.theme.LocalAppTheme
import examplepackage.features.splash.presentation.SplashComponent
import kotlinx.coroutines.flow.collectLatest
import ru.astrainteractive.klibs.mikro.extensions.arkivanov.FakeComponentContext

@Composable
fun SplashScreenComponent(
    splashComponent: SplashComponent,
    onIconClicked: () -> Unit
) {
    val scale by rememberInfiniteTransition(label = "Scale transition").animateFloat(
        label = "Scale animation",
        initialValue = 1.2f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            repeatMode = RepeatMode.Reverse,
            animation = tween(
                durationMillis = 1000,
                easing = EaseInBounce
            )
        ),
    )
    LaunchedEffect(key1 = Unit) {
        splashComponent.screenChannelFlow.collectLatest {
            when (it) {
                is SplashComponent.Label.InitialLaunch -> {
                }
            }
        }
    }

    Box(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primaryVariant),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = CoreR.images.ainteractivelogo.asPainter(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(64.dp)
                    .wrapContentHeight()
                    .scale(scale)
                    .clip(CircleShape)
                    .clickable { onIconClicked.invoke() }
            )
        }
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .navigationBarsPadding(),
            contentAlignment = Alignment.TopCenter
        ) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = LocalAppTheme.current.customColors.astraOrange,
                backgroundColor = LocalAppTheme.current.customColors.astraYellow
            )
        }
    }
}

@Preview
@Composable
private fun SplashScreenComponentPreview() {
    AdaptThemeFade {
        SplashScreenComponent(
            splashComponent = SplashModule.Preview().createSplashComponent(FakeComponentContext()),
            onIconClicked = {}
        )
    }
}
