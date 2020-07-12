package com.mcnmr.utilities.extension

fun <T> T?.isNotNull(): Boolean{
    return this != null
}

fun <T> T?.isNull(): Boolean{
    return this == null
}

fun <T> T?.doIf(ifNull: () -> Unit = {}, ifNotNull: (T) -> Unit = {}){
    if(this != null){
        ifNotNull(this)
        return
    }

    ifNull()
}