package examplepackage.features.theme.presentation

import examplepackage.features.theme.data.model.Theme
import examplepackage.features.theme.data.repository.ThemeSwitcherRepository
import kotlinx.coroutines.flow.StateFlow
import ru.astrainteractive.klibs.mikro.core.util.next

internal class DefaultThemeSwitcherComponentComponent(
    private val themeSwitcherRepository: ThemeSwitcherRepository
) : ThemeSwitcherComponent {
    private val themeFlowStorageValue = themeSwitcherRepository.themeFlowStorageValue

    override val theme: StateFlow<Theme> = themeFlowStorageValue.cachedStateFlow

    override fun selectDarkTheme() {
        themeFlowStorageValue.save(Theme.DARK)
    }

    override fun selectLightTheme() {
        themeFlowStorageValue.save(Theme.LIGHT)
    }

    override fun selectTheme(theme: Theme) {
        themeFlowStorageValue.save(theme)
    }

    override fun next() {
        val entries = Theme.entries.toTypedArray()
        val nextTheme = theme.value.next(entries)
        selectTheme(nextTheme)
    }

    init {
        themeFlowStorageValue.loadAndGet()
    }
}
