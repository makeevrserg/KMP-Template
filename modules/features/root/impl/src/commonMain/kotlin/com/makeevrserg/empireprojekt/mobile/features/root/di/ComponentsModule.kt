package com.makeevrserg.empireprojekt.mobile.features.root.di

import com.makeevrserg.empireprojekt.mobile.features.theme.DefaultThemeSwitcherComponentComponent
import com.makeevrserg.empireprojekt.mobile.features.theme.ThemeSwitcherComponent
import com.makeevrserg.empireprojekt.mobile.features.theme.di.ThemeSwitcherModule
import ru.astrainteractive.klibs.kdi.Single

interface ComponentsModule {
    // Global components
    val themeSwitcherComponent: Single<ThemeSwitcherComponent>

    class Default(
        rootModule: RootModule
    ) : ComponentsModule {
        override val themeSwitcherComponent: Single<ThemeSwitcherComponent> = Single {
            val module = ThemeSwitcherModule.Default(
                settings = rootModule.coreModule.settings.value
            )
            DefaultThemeSwitcherComponentComponent(module)
        }
    }
}
