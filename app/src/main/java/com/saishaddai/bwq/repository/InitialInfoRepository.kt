package com.saishaddai.bwq.repository

import android.util.Log
import com.saishaddai.bwq.model.Card
import com.saishaddai.bwq.model.Deck

class InitialInfoRepository (private val infoRetriever: InfoRetrieverFiles, private val infoStore: InfoStoreRoom) {


    fun initInfo() {
//        val infoRetriever = InfoRetrieverFiles()
//        val infoStore = InfoStoreRoom()

        val decks: List<Deck> = infoRetriever.getDecks()
        Log.d(TAG, "storing " + decks.size + " decks")
        infoStore.saveDecks(decks)

        val cards: List<Card>  = infoRetriever.getCards(decks)
        Log.d(TAG, "storing " + cards.size + " cards")
        infoStore.saveCards(cards)

    }

    companion object {
        private val TAG = InitialInfoRepository::class.java.simpleName
    }
}