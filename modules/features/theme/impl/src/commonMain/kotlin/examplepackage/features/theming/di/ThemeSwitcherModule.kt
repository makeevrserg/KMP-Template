package examplepackage.features.theming.di

import com.russhwolf.settings.Settings
import examplepackage.features.theming.api.ThemeSwitcherComponent
import examplepackage.features.theming.api.ThemeSwitcherRepository
import examplepackage.features.theming.component.DefaultThemeSwitcherComponentComponent
import examplepackage.features.theming.krate.KrateThemeSwitcherRepository

interface ThemeSwitcherModule {

    val themeSwitcherComponent: ThemeSwitcherComponent

    class Default(settings: Settings) : ThemeSwitcherModule {
        private val themeSwitcherRepository: ThemeSwitcherRepository = KrateThemeSwitcherRepository(settings)
        override val themeSwitcherComponent: ThemeSwitcherComponent by lazy {
            DefaultThemeSwitcherComponentComponent(themeSwitcherRepository)
        }
    }
}
