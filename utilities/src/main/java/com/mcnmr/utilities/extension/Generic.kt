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

inline fun <T: Any> guardLet(vararg elements: T?, closure: () -> Nothing): List<T> {
    return if (elements.all { it != null }) {
        elements.filterNotNull()
    } else {
        closure()
    }
}

inline fun <T: Any> ifLet(vararg elements: T?, closure: (List<T>) -> Unit) {
    if (elements.all { it != null }) {
        closure(elements.filterNotNull())
    }
}