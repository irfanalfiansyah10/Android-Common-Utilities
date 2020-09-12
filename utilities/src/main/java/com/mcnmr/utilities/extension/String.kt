package com.mcnmr.utilities.extension

import android.graphics.Color
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import kotlin.random.Random

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


fun String?.extractYoutubeId(videoIdCallback: (String) -> Unit){
    if(this.isNotEmptyOrNotNull()){
        if(this!!.startsWith("https://www.youtube.com/watch?v=")){
            val videoId = this.split("https://www.youtube.com/watch?v=")
            videoIdCallback(videoId[1])
        }
    }
}

fun String.hexStringToByteArray(): ByteArray {
    val l = this.length
    val data = ByteArray(l / 2)
    var i = 0
    while (i < l) {
        data[i / 2] = ((Character.digit(this[i], 16) shl 4)
                + Character.digit(this[i + 1], 16)).toByte()
        i += 2
    }
    return data
}

fun String.hexEncrypt(method: String,
                      key: String,
                      algorithm: String,
                      ivLength: Int,
                      ivSeparator: String): String{
    return try{
        val cipher = Cipher.getInstance(method)
        val keySpec = SecretKeySpec(key.toByteArray(), algorithm)

        val iv = Random.nextBytes(ivLength)
        val ivSpec = IvParameterSpec(iv)
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec)
        val cipherText = cipher.doFinal(this.toByteArray())

        "${iv.toHexString()}${ivSeparator}${cipherText.toHexString()}"
    }catch (e: Exception){
        this
    }
}

fun String.hexDecrypt(method: String,
                      key: String,
                      algorithm: String,
                      ivSeparator: String): String{
    return try{
        val cipher = Cipher.getInstance(method)
        val keySpec = SecretKeySpec(key.toByteArray(), algorithm)

        val parts = this.split(ivSeparator)
        val ivDecrypt = IvParameterSpec(parts[0].hexStringToByteArray())
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivDecrypt)
        val decodedEncryptedData: ByteArray = parts[1].hexStringToByteArray()
        val original = cipher.doFinal(decodedEncryptedData)

        String(original)
    }catch(e: Exception){
        this
    }
}

fun String.asColor(): Int {
    return try{
        Color.parseColor(this)
    }catch(e: Exception){
        Color.parseColor("#00000000")
    }
}