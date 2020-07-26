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

fun String?.isEmailAddress(): Boolean{
    if(this == null){
        return false
    }

    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String?.isAlphanumeric(): Boolean{
    if(this == null){
        return false
    }

    val isContainsAlphabet = this.matches(".*[A-Za-z].*".toRegex())
    val isContainsNumber = this.matches(".*[0-9].*".toRegex())
    val isOnlyAlphanumeric = this.matches("[A-Za-z0-9]*".toRegex())

    return isContainsAlphabet && isContainsNumber && isOnlyAlphanumeric
}

fun String?.isEmpty(): Boolean{
    if(this == null){
        return false
    }

    return this == ""
}