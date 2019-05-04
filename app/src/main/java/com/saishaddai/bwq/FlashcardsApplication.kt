package com.saishaddai.bwq

import android.app.Application
import android.util.Log

class FlashcardsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "starting application walla")
        //create all the singleton object for room and check if the tables for decks and cards are filled.
        //if this is the first time the app is running then read from assets and store in the database

    }

    companion object {
        private val TAG = FlashcardsApplication::class.java.simpleName
    }

}