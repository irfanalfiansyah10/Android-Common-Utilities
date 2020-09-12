package com.mcnmr.utilities.extension

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.Settings
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun Context.openPermissionSettings(){
    val intent = Intent()
    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS

    val uri = Uri.fromParts("package", this.packageName, null)
    intent.data = uri

    startActivity(intent)
}

fun Context.getCompatDrawable(@DrawableRes resId: Int): Drawable? =
    ContextCompat.getDrawable(this, resId)

fun Context.getCompatColor(@ColorRes resId: Int): Int = ContextCompat.getColor(this, resId)

fun Context.launchUrl(url: String?){
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}