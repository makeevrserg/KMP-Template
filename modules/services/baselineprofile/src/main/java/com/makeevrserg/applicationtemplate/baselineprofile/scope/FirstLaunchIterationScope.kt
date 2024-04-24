package com.makeevrserg.applicationtemplate.baselineprofile.scope

import androidx.benchmark.macro.MacrobenchmarkScope
import com.makeevrserg.applicationtemplate.baselineprofile.log.LogTagProvider
import com.makeevrserg.applicationtemplate.baselineprofile.log.info
import com.makeevrserg.applicationtemplate.baselineprofile.util.UiAutomatorExt
import com.makeevrserg.applicationtemplate.baselineprofile.util.UiAutomatorExt.requirePackageName

object FirstLaunchIterationScope : LogTagProvider {
    override val TAG = "FirstLaunchIterationScope"

    fun MacrobenchmarkScope.tryRun() {
        info { "#tryRun" }
        device.waitForIdle()
        device.waitForWindowUpdate(requirePackageName, UiAutomatorExt.MEDIUM_TIMEOUT)
    }
}
