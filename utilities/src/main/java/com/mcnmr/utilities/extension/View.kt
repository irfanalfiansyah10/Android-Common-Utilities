package com.mcnmr.utilities.extension

import android.view.View
import android.view.ViewAnimationUtils
import androidx.core.animation.addListener
import androidx.core.view.ViewCompat
import kotlin.math.hypot

fun View.visibleOrGoneIf(condition: Boolean){
    visibility = if(condition) View.VISIBLE else View.GONE
}
fun View.visibleOrInvisibleIf(condition: Boolean){
    visibility = if(condition) View.VISIBLE else View.INVISIBLE
}

fun View.gone(){ visibility = View.GONE }

fun View.visible(){ visibility = View.VISIBLE }

fun View.circularReveal(){
    if(ViewCompat.isAttachedToWindow(this)){
        val cx = width / 2
        val cy = height / 2

        val finalRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()
        val anim = ViewAnimationUtils.createCircularReveal(this, cx, cy, 0f, finalRadius)

        visibility = View.VISIBLE
        anim.start()
    }
}

fun View.visibleIf(condition: Boolean){
    if(condition) {
        visibility = View.VISIBLE
    }
}

fun View.doWhenVisible(expression: (View) -> Unit){
    if(visibility == View.VISIBLE) expression(this)
}

fun ArrayList<View>.doWhenVisible(expression: (View) -> Unit){
    forEach {
        if(it.visibility == View.VISIBLE) expression(it)
    }
}

fun View.doWhenGone(expression: (View) -> Unit){
    if(visibility == View.GONE) expression(this)
}

fun ArrayList<View>.doWhenGone(expression: (View) -> Unit){
    forEach {
        if(it.visibility == View.GONE) expression(it)
    }
}

fun View.doWhenInvisible(expression: (View) -> Unit){
    if(visibility == View.INVISIBLE) expression(this)
}

fun ArrayList<View>.doWhenInvisible(expression: (View) -> Unit){
    forEach {
        if(it.visibility == View.INVISIBLE) expression(it)
    }
}

fun View.circularHide(){
    if(ViewCompat.isAttachedToWindow(this)){
        val cx = width / 2
        val cy = height / 2

        val finalRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()
        val anim = ViewAnimationUtils.createCircularReveal(this, cx, cy, finalRadius, 0f)
        anim.addListener({
            visibility = View.INVISIBLE
        })
        anim.start()
    }
}

infix fun View.and(v: View): ArrayList<View>{
    val list = ArrayList<View>()
    list.add(this)
    list.add(v)
    return list
}

infix fun ArrayList<View>.and(v: View): ArrayList<View>{
    this.add(v)
    return this
}
