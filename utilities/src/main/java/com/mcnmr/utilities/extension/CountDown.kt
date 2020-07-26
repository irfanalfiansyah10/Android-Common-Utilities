package com.mcnmr.utilities.extension

import android.os.CountDownTimer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

fun interval(lifecycleOwner: LifecycleOwner, future: Long = 5000, interval: Long = 1000, onTick: () -> Unit = {}, onFinish: () -> Unit = {}): CountDownTimer?{
    var countDown: CountDownTimer?

    //called on 0 millisecond
    onTick()

    fun countDownInstance(): CountDownTimer = object : CountDownTimer(future, interval){
        override fun onFinish() {
            onFinish()
        }

        override fun onTick(p0: Long) {
            onTick()
        }
    }.apply { start() }

    countDown = countDownInstance()

    lifecycleOwner.lifecycle.addObserver(object : LifecycleObserver{
        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun onPause(){
            countDown?.cancel()
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onStop(){
            countDown?.cancel()
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy(){
            countDown?.cancel()
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun onResume(){
            countDown = countDownInstance()
        }
    })

    return countDown
}