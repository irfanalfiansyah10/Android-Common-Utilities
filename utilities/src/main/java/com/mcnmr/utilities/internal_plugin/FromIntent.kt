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
annotation class IntIntent(val value: String, val default: Int = 0)

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class BooleanIntent(val value: String, val default: Boolean = false)

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class SerializableIntent(val value: String)

fun Activity.obtainIntentData(){
    this::class.java.fields.forEach {
        when {
            it.isAnnotationPresent(StringIntent::class.java) -> {
                it.isAccessible = true

                val fromIntent = it.getAnnotation(StringIntent::class.java)
                it.set(this, intent.getStringExtra(fromIntent!!.value))
            }
            it.isAnnotationPresent(SerializableIntent::class.java) -> {
                it.isAccessible = true

                val fromIntent = it.getAnnotation(SerializableIntent::class.java)
                it.set(this, intent.getSerializableExtra(fromIntent!!.value))
            }
            it.isAnnotationPresent(IntIntent::class.java) -> {
                it.isAccessible = true

                val fromIntent = it.getAnnotation(IntIntent::class.java)
                it.set(this, intent.getIntExtra(fromIntent!!.value, fromIntent.default))
            }
            it.isAnnotationPresent(BooleanIntent::class.java) -> {
                it.isAccessible = true

                val fromIntent = it.getAnnotation(BooleanIntent::class.java)
                it.set(this, intent.getBooleanExtra(fromIntent!!.value, fromIntent.default))
            }
        }
    }
}