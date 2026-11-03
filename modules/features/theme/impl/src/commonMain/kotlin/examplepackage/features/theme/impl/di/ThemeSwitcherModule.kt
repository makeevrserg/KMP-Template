package examplepackage.features.theme.impl.di

import com.russhwolf.settings.Settings
import examplepackage.features.theme.impl.api.ThemeSwitcherRepository
import examplepackage.features.theme.impl.component.DefaultThemeSwitcherComponentComponent
import examplepackage.features.theme.impl.component.ThemeSwitcherComponent
import examplepackage.features.theme.impl.krate.KrateThemeSwitcherRepository

interface ThemeSwitcherModule {

    val themeSwitcherComponent: ThemeSwitcherComponent

    class Default(settings: Settings) : ThemeSwitcherModule {
        private val themeSwitcherRepository: ThemeSwitcherRepository = KrateThemeSwitcherRepository(settings)
        override val themeSwitcherComponent: ThemeSwitcherComponent by lazy {
            DefaultThemeSwitcherComponentComponent(themeSwitcherRepository)
        }
    }
}
