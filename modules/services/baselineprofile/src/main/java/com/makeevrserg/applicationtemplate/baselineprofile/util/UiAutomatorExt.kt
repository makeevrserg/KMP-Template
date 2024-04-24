package com.makeevrserg.applicationtemplate.baselineprofile.util

import androidx.test.uiautomator.UiDevice
import com.makeevrserg.applicationtemplate.buildkonfig.BuildKonfig
import org.junit.Assert

object UiAutomatorExt {
    const val MEDIUM_TIMEOUT = 10_000L

    val requirePackageName: String
        get() = BuildKonfig.GROUP

    /**
     * Clear cache and data of current app package
     */
    fun UiDevice.clearCache() {
        val command = "pm clear $requirePackageName"
        val output = executeShellCommand(command)
        Assert.assertTrue(output.contains("Success"))
    }
}
