package examplepackage.features.theme.di

import com.russhwolf.settings.Settings
import examplepackage.features.theme.data.repository.ThemeSwitcherRepository
import examplepackage.features.theme.data.repository.ThemeSwitcherRepositoryImpl
import examplepackage.features.theme.presentation.DefaultThemeSwitcherComponentComponent
import examplepackage.features.theme.presentation.ThemeSwitcherComponent

interface ThemeSwitcherModule {

    val themeSwitcherComponent: ThemeSwitcherComponent

    class Default(settings: Settings) : ThemeSwitcherModule {
        private val themeSwitcherRepository: ThemeSwitcherRepository = ThemeSwitcherRepositoryImpl(settings)
        override val themeSwitcherComponent: ThemeSwitcherComponent by lazy {
            DefaultThemeSwitcherComponentComponent(themeSwitcherRepository)
        }
    }
}
