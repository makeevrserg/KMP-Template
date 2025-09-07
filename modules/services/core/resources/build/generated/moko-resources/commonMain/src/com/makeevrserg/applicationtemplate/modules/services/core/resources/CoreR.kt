package com.makeevrserg.applicationtemplate.modules.services.core.resources

import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.ResourceContainer
import dev.icerock.moko.resources.ResourcePlatformDetails
import dev.icerock.moko.resources.StringResource
import kotlin.collections.List

public expect object CoreR {
  public object strings : ResourceContainer<StringResource> {
    override val __platformDetails: ResourcePlatformDetails

    public val app_name: StringResource

    public val info_more_links: StringResource

    override fun values(): List<StringResource>
  }

  public object images : ResourceContainer<ImageResource> {
    override val __platformDetails: ResourcePlatformDetails

    public val ic_splash_padding: ImageResource

    public val alearner: ImageResource

    public val github: ImageResource

    public val ic_esmp: ImageResource

    public val esmptelegram: ImageResource

    public val gplay: ImageResource

    public val ainteractivelogo: ImageResource

    public val boosty: ImageResource

    override fun values(): List<ImageResource>
  }
}
