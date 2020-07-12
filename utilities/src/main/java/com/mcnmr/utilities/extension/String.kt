package com.mcnmr.utilities.extension

fun String?.isNotEmptyOrNotNull(): Boolean {
    if(this == null){
        return false
    }else {
        if(this == ""){
            return false
        }

        return true
    }
}