package com.mcnmr.utilities.extension

import java.text.SimpleDateFormat
import java.util.*

fun Long?.toDate(targetFormat: String): String{
    if(this == null) return ""

    val formatter = SimpleDateFormat(targetFormat, Locale.getDefault())

    return formatter.format(Date(this))
}