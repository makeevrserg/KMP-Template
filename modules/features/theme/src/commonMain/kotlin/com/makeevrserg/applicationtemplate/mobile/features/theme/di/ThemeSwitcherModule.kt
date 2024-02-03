package com.makeevrserg.applicationtemplate.mobile.features.theme.di

import com.makeevrserg.applicationtemplate.mobile.features.theme.data.ThemeSwitcherRepository
import com.makeevrserg.applicationtemplate.mobile.features.theme.data.ThemeSwitcherRepositoryImpl
import com.makeevrserg.applicationtemplate.mobile.features.theme.presentation.DefaultThemeSwitcherComponentComponent
import com.makeevrserg.applicationtemplate.mobile.features.theme.presentation.ThemeSwitcherComponent
import com.russhwolf.settings.Settings
import ru.astrainteractive.klibs.kdi.Single
import ru.astrainteractive.klibs.kdi.getValue

interface ThemeSwitcherModule {

    val themeSwitcherComponent: ThemeSwitcherComponent

    class Default(settings: Settings) : ThemeSwitcherModule {
        private val themeSwitcherRepository: ThemeSwitcherRepository by Single {
            ThemeSwitcherRepositoryImpl(settings)
        }
        override val themeSwitcherComponent: ThemeSwitcherComponent by lazy {
            DefaultThemeSwitcherComponentComponent(themeSwitcherRepository)
        }
    }
}
