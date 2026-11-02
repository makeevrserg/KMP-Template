package examplepackage.features.theme.impl.stub

import examplepackage.features.theme.impl.component.ThemeSwitcherComponent
import examplepackage.features.theme.impl.model.Theme
import kotlinx.coroutines.flow.MutableStateFlow
import ru.astrainteractive.klibs.mikro.core.util.next

class PreviewThemeSwitcherComponent : ThemeSwitcherComponent {
    override val theme: MutableStateFlow<Theme> = MutableStateFlow(Theme.LIGHT)

    override fun selectTheme(theme: Theme) {
        this.theme.value = theme
    }

    override fun selectDarkTheme() {
        selectTheme(Theme.DARK)
    }

    override fun selectLightTheme() {
        selectTheme(Theme.LIGHT)
    }

    override fun next() {
        theme.value.next(Theme.entries.toTypedArray()).run(::selectTheme)
    }
}
