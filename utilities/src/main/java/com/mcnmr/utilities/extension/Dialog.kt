package com.mcnmr.utilities.extension

import android.app.Dialog
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

fun Dialog.getString(@StringRes resId: Int): String = context.getString(resId)
fun Dialog.getColor(@ColorRes resId: Int): Int = ContextCompat.getColor(context, resId)

fun Dialog.showIfNotShowing(){
    if(!isShowing){
        show()
    }
}

fun Dialog.dismissIfShowing(){
    if(isShowing){
        dismiss()
    }
}