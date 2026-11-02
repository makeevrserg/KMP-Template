package examplepackage.features.theme.impl.di

import com.russhwolf.settings.Settings

fun buildThemeSwitcherModule(settings: Settings): ThemeSwitcherModule = ThemeSwitcherModule.Default(settings)
