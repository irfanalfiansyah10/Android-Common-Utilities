package com.mcnmr.utilities.internal_plugin

import android.app.Activity

/**
 * Note : that you can use this just for lateinit var
 * or add @JvmField annotation to field
 */
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class StringIntent(val value: String)

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class IntIntent(val value: String)

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class BooleanIntent(val value: String)

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class SerializableIntent(val value: String)

fun Activity.obtainIntentData(){
    this::class.java.fields.forEach {
        if(it.isAnnotationPresent(StringIntent::class.java)){
            it.isAccessible = true

            val fromIntent = it.getAnnotation(StringIntent::class.java)
            it.set(this, intent.getStringExtra(fromIntent?.value))
        }else if(it.isAnnotationPresent(SerializableIntent::class.java)){
            it.isAccessible = true

            val fromIntent = it.getAnnotation(SerializableIntent::class.java)
            it.set(this, intent.getSerializableExtra(fromIntent?.value))
        }
    }
}