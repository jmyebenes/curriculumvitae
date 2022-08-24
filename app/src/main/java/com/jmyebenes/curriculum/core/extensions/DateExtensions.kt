package com.jmyebenes.curriculum.core.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.formatToString(pattern: String): String {
    return SimpleDateFormat(pattern, Locale.getDefault()).format(this)
}