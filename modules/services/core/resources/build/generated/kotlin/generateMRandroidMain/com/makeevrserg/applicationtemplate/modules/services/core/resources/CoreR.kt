package com.makeevrserg.applicationtemplate.modules.services.core.resources

import com.makeevrserg.applicationtemplate.modules.services.core.resources.R
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.ResourceContainer
import dev.icerock.moko.resources.ResourcePlatformDetails
import dev.icerock.moko.resources.StringResource
import kotlin.String
import kotlin.collections.List

public actual object CoreR {
  private val contentHash: String = "eca84e44b7cee39d9dab66fdd525bf91"

  public actual object strings : ResourceContainer<StringResource> {
    actual override val __platformDetails: ResourcePlatformDetails = ResourcePlatformDetails()

    public actual val app_name: StringResource = StringResource(R.string.app_name)

    public actual val info_more_links: StringResource = StringResource(R.string.info_more_links)

    actual override fun values(): List<StringResource> = listOf(app_name, info_more_links)
  }

  public actual object images : ResourceContainer<ImageResource> {
    actual override val __platformDetails: ResourcePlatformDetails = ResourcePlatformDetails()

    public actual val ic_splash_padding: ImageResource = ImageResource(R.drawable.ic_splash_padding)

    public actual val alearner: ImageResource = ImageResource(R.drawable.alearner)

    public actual val github: ImageResource = ImageResource(R.drawable.github)

    public actual val ic_esmp: ImageResource = ImageResource(R.drawable.ic_esmp)

    public actual val esmptelegram: ImageResource = ImageResource(R.drawable.esmptelegram)

    public actual val gplay: ImageResource = ImageResource(R.drawable.gplay)

    public actual val ainteractivelogo: ImageResource = ImageResource(R.drawable.ainteractivelogo)

    public actual val boosty: ImageResource = ImageResource(R.drawable.boosty)

    actual override fun values(): List<ImageResource> = listOf(ic_splash_padding, alearner, github, ic_esmp, esmptelegram, gplay, ainteractivelogo, boosty)
  }
}
