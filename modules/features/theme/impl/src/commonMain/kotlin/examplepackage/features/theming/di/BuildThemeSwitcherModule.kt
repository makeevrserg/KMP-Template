package examplepackage.features.theming.di

import com.russhwolf.settings.Settings

fun buildThemeSwitcherModule(settings: Settings): ThemeSwitcherModule = ThemeSwitcherModule.Default(settings)
