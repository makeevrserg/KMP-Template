package com.makeevrserg.applicationtemplate.baselineprofile.log

import android.util.Log

interface LogTagProvider {
    @Suppress("VariableNaming")
    val TAG: String
}

fun LogTagProvider.info(string: () -> String) {
    Log.d(TAG, string.invoke())
}
