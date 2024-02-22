package com.makeevrserg.applicationtemplate.mobile.features.info.linkbrowser

import android.content.Context
import android.content.Intent
import android.net.Uri

internal class AndroidLinkBrowser(
    private val context: Context
) : LinkBrowser {
    override fun openInBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
        }
        context.startActivity(intent)
    }
}
