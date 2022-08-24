package com.jmyebenes.curriculum.core.extensions

import android.view.View

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.visibleOrInvisible(show: Boolean) {
    if (show) visible() else invisible()
}

fun View.visibleOrGone(show: Boolean) {
    if (show) visible() else gone()
}