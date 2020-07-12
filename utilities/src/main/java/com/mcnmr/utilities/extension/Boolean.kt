package com.mcnmr.utilities.extension

fun Boolean?.notNullAndTrue(): Boolean = this ?: false

fun Boolean?.nullOrFalse(): Boolean = !(this ?: false)

fun Boolean.doIfTrue(block: () -> Unit){ if(this){ block.invoke() } }