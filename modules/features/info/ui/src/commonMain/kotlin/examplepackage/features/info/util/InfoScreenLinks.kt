package examplepackage.features.info.util

import androidx.compose.material.MaterialTheme
import com.makeevrserg.applicationtemplate.modules.services.core.resources.CoreR
import com.makeevrserg.applicationtemplate.modules.services.core.resources.ainteractivelogo
import com.makeevrserg.applicationtemplate.modules.services.core.resources.alearner
import com.makeevrserg.applicationtemplate.modules.services.core.resources.boosty
import com.makeevrserg.applicationtemplate.modules.services.core.resources.esmptelegram
import com.makeevrserg.applicationtemplate.modules.services.core.resources.github
import com.makeevrserg.applicationtemplate.modules.services.core.resources.gplay
import com.makeevrserg.applicationtemplate.modules.services.core.resources.ic_esmp
import examplepackage.features.info.model.Link

internal fun buildInfoScreenLinks(): List<Link> {
    return buildList {
        Link(
            title = "Astra Github",
            res = CoreR.images.github,
            tint = { MaterialTheme.colors.onPrimary },
            url = "https://github.com/Astra-Interactive/"
        ).run(::add)
        Link(
            title = "Author Github",
            res = CoreR.images.github,
            tint = { MaterialTheme.colors.onPrimary },
            url = "https://github.com/makeevrserg"
        ).run(::add)
        Link(
            title = "Source code",
            res = CoreR.images.github,
            tint = { MaterialTheme.colors.onPrimary },
            url = "https://github.com/makeevrserg/EmpireProjekt-Mobile"
        ).run(::add)
        Link(
            title = "TG Group",
            res = CoreR.images.esmptelegram,
            url = "https://t.me/empiresmp"
        ).run(::add)
        Link(
            title = "TG Chat",
            res = CoreR.images.esmptelegram,
            url = "https://t.me/empiresmp_discussion"
        ).run(::add)
        Link(
            title = "EmpireProjekt.ru",
            res = CoreR.images.ic_esmp,
            url = "https://EmpireProjekt.ru"
        ).run(::add)
        Link(
            title = "AstraInteractive.ru",
            res = CoreR.images.ainteractivelogo,
            url = "https://AstraInteractive.ru"
        ).run(::add)
        Link(
            title = "Boosty",
            res = CoreR.images.boosty,
            url = "https://boosty.to/empireprojekt/donate"
        ).run(::add)
        Link(
            title = "AstraLearner",
            res = CoreR.images.alearner,
            url = "https://play.google.com/store/apps/details?id=com.makeevrserg.astralearner"
        ).run(::add)
        Link(
            title = "Google Play page",
            res = CoreR.images.gplay,
            url = "https://play.google.com/store/apps/details?id=com.makeevrserg.empireprojekt.mobile"
        ).run(::add)
    }
}
