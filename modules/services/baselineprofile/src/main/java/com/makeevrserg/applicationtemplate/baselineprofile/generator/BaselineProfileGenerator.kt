package com.makeevrserg.applicationtemplate.baselineprofile.generator

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.makeevrserg.applicationtemplate.baselineprofile.scope.FirstLaunchIterationScope
import com.makeevrserg.applicationtemplate.baselineprofile.util.UiAutomatorExt
import com.makeevrserg.applicationtemplate.baselineprofile.util.UiAutomatorExt.clearCache
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * THIS WILL WIPE YOUR ANDROID INSTALL
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
@RequiresApi(Build.VERSION_CODES.P)
class BaselineProfileGenerator {

    @get:Rule
    val rule = BaselineProfileRule()

    @Test
    fun generate() {
        rule.collect(
            packageName = UiAutomatorExt.requirePackageName,
            maxIterations = 4,
            stableIterations = 3
        ) {
            device.clearCache()
            pressHome()
            startActivityAndWait()
            with(FirstLaunchIterationScope) { tryRun() }
        }
    }
}
