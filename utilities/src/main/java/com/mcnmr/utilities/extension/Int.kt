package com.mcnmr.utilities.extension

import android.content.pm.PackageManager

fun Int.substractByOne(zeroSafe: Boolean): Int{
    val x = this - 1

    return if(zeroSafe && x < 0) this else x
}

fun Int.increaseByOne(maxCount: Int): Int{
    val x = this + 1

    return if(x > maxCount) this else x
}

//for permission
fun Int.isGranted(): Boolean {
    return this == PackageManager.PERMISSION_GRANTED
}

fun Int.isDenied(): Boolean {
    return this == PackageManager.PERMISSION_DENIED
}