package com.saishaddai.bwq.repository

import android.util.Log
import com.saishaddai.bwq.model.Card
import com.saishaddai.bwq.model.Deck

/**
 * Stores the information in SQLite using Room
 */
class InfoStoreRoom : InfoStore<Card, Deck> {

    override fun saveDecks(decks: List<Deck>) {
        Log.d(TAG, "saving decks in Room")
    }

    override fun saveCards(cards: List<Card>) {
        Log.d(TAG, "saving cards in Room")
    }

    companion object {
        private val TAG = InfoStoreRoom::class.java.simpleName
    }

}