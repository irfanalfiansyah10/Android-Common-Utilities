package com.mcnmr.utilities.extension

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.getCompatDrawable(@DrawableRes resId: Int): Drawable? =
    ContextCompat.getDrawable(requireContext(), resId)

fun Fragment.getCompatColor(@ColorRes resId: Int): Int = ContextCompat.getColor(requireContext(), resId)