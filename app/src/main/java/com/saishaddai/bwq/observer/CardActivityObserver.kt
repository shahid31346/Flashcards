package com.saishaddai.bwq.observer

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

class CardActivityObserver : LifecycleObserver {

    private val tag : String = CardActivityObserver::class.java.simpleName

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun storeDecksData() {
        Log.d(tag, "lifecycle aware to store values in database")

        //update in database that the user used a deck and the last time he spent there
        return
    }
}