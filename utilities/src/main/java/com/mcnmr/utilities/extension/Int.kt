package com.mcnmr.utilities.extension

import android.content.Context
import android.content.pm.PackageManager
import kotlin.math.ceil

fun Int.substractByOne(zeroSafe: Boolean): Int{
    val x = this - 1

    return if(zeroSafe && x < 0) this else x
}

fun Int.increaseByOne(maxCount: Int): Int{
    val x = this + 1

    return if(x > maxCount) this else x
}

fun Int?.isMultipliedBy(multiplier: Int): Boolean{
    return if(this == null) false
    else this % multiplier == 0
}

fun Int?.gt(target: Int): Boolean{
    return if(this == null) false
    else this > target
}

//for permission
fun Int.isGranted(): Boolean {
    return this == PackageManager.PERMISSION_GRANTED
}

fun Int.isDenied(): Boolean {
    return this == PackageManager.PERMISSION_DENIED
}

//display
fun Int.toDp(context: Context): Int {
    val density = context.resources.displayMetrics.density
    return if (this.toFloat() == 0f) 0 else ceil((density * this.toFloat()).toDouble()).toInt()
}