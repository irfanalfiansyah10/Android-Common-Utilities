package com.mcnmr.utilities.extension

fun ByteArray.toHexString() = joinToString("") { "%02x".format(it) }