package examplepackage.features.info.ui.data

import androidx.compose.material.MaterialTheme
import examplepackage.features.info.ui.model.LinkModel
import com.makeevrserg.applicationtemplate.modules.services.core.resources.CoreR

internal object InfoScreenLinks {
    fun get(): List<LinkModel> {
        return buildList {
            LinkModel(
                title = "Astra Github",
                res = CoreR.images.github,
                tint = { MaterialTheme.colors.onPrimary },
                url = "https://github.com/Astra-Interactive/"
            ).run(::add)
            LinkModel(
                title = "Author Github",
                res = CoreR.images.github,
                tint = { MaterialTheme.colors.onPrimary },
                url = "https://github.com/makeevrserg"
            ).run(::add)
            LinkModel(
                title = "Source code",
                res = CoreR.images.github,
                tint = { MaterialTheme.colors.onPrimary },
                url = "https://github.com/makeevrserg/EmpireProjekt-Mobile"
            ).run(::add)
            LinkModel(
                title = "TG Group",
                res = CoreR.images.esmptelegram,
                url = "https://t.me/empiresmp"
            ).run(::add)
            LinkModel(
                title = "TG Chat",
                res = CoreR.images.esmptelegram,
                url = "https://t.me/empiresmp_discussion"
            ).run(::add)
            LinkModel(
                title = "EmpireProjekt.ru",
                res = CoreR.images.ic_esmp,
                url = "https://EmpireProjekt.ru"
            ).run(::add)
            LinkModel(
                title = "AstraInteractive.ru",
                res = CoreR.images.ainteractivelogo,
                url = "https://AstraInteractive.ru"
            ).run(::add)
            LinkModel(
                title = "Boosty",
                res = CoreR.images.boosty,
                url = "https://boosty.to/empireprojekt/donate"
            ).run(::add)
            LinkModel(
                title = "AstraLearner",
                res = CoreR.images.alearner,
                url = "https://play.google.com/store/apps/details?id=com.makeevrserg.astralearner"
            ).run(::add)
            LinkModel(
                title = "Google Play page",
                res = CoreR.images.gplay,
                url = "https://play.google.com/store/apps/details?id=com.makeevrserg.empireprojekt.mobile"
            ).run(::add)
        }
    }
}
