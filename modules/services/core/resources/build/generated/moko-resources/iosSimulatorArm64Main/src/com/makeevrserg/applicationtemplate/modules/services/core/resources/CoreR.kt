package com.makeevrserg.applicationtemplate.modules.services.core.resources

import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.ResourceContainer
import dev.icerock.moko.resources.ResourcePlatformDetails
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.utils.loadableBundle
import kotlin.String
import kotlin.collections.List
import platform.Foundation.NSBundle

public actual object CoreR {
  private val contentHash: String = "eca84e44b7cee39d9dab66fdd525bf91"

  private val bundle: NSBundle by
      lazy { NSBundle.loadableBundle("com.makeevrserg.applicationtemplate.modules.services.core.resources.main") }

  public actual object strings : ResourceContainer<StringResource> {
    actual override val __platformDetails: ResourcePlatformDetails = ResourcePlatformDetails(bundle)

    public actual val app_name: StringResource =
        StringResource(resourceId = "app_name", bundle = __platformDetails.nsBundle)

    public actual val info_more_links: StringResource =
        StringResource(resourceId = "info_more_links", bundle = __platformDetails.nsBundle)

    actual override fun values(): List<StringResource> = listOf(app_name, info_more_links)
  }

  public actual object images : ResourceContainer<ImageResource> {
    actual override val __platformDetails: ResourcePlatformDetails = ResourcePlatformDetails(bundle)

    public actual val ic_splash_padding: ImageResource =
        ImageResource(assetImageName = "ic_splash_padding", bundle = __platformDetails.nsBundle)

    public actual val alearner: ImageResource =
        ImageResource(assetImageName = "alearner", bundle = __platformDetails.nsBundle)

    public actual val github: ImageResource =
        ImageResource(assetImageName = "github", bundle = __platformDetails.nsBundle)

    public actual val ic_esmp: ImageResource =
        ImageResource(assetImageName = "ic_esmp", bundle = __platformDetails.nsBundle)

    public actual val esmptelegram: ImageResource =
        ImageResource(assetImageName = "esmptelegram", bundle = __platformDetails.nsBundle)

    public actual val gplay: ImageResource =
        ImageResource(assetImageName = "gplay", bundle = __platformDetails.nsBundle)

    public actual val ainteractivelogo: ImageResource =
        ImageResource(assetImageName = "ainteractivelogo", bundle = __platformDetails.nsBundle)

    public actual val boosty: ImageResource =
        ImageResource(assetImageName = "boosty", bundle = __platformDetails.nsBundle)

    actual override fun values(): List<ImageResource> = listOf(ic_splash_padding, alearner, github, ic_esmp, esmptelegram, gplay, ainteractivelogo, boosty)
  }
}
