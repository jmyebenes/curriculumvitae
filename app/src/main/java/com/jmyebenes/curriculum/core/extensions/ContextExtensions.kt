package com.jmyebenes.curriculum.core.extensions

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri

fun Context.activity(): Activity? = when (this) {
    is Activity -> this
    else -> (this as? ContextWrapper)?.baseContext?.activity()
}

fun Context.browse(url: String) {
    val intent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("http://$url")
    )
    activity()?.startActivity(intent)
}

fun Context.call(phone: String) {
    val intent = Intent(Intent.ACTION_DIAL)
    intent.data = Uri.parse("tel:$phone")
    activity()?.startActivity(intent)
}

fun Context.mail(mail: String) {
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.data = Uri.parse("mailto:$mail")
    activity()?.startActivity(intent)
}