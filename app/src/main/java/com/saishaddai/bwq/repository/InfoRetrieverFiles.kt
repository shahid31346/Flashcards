package com.saishaddai.bwq.repository

import android.content.res.AssetManager
import android.util.Log
import com.google.gson.Gson
import com.saishaddai.bwq.BuildConfig
import com.saishaddai.bwq.commons.FileUtilities
import com.saishaddai.bwq.model.Card
import com.saishaddai.bwq.model.Deck

/**
 * Gets all the cards and decks from assets files
 */
class InfoRetrieverFiles(private var assets: AssetManager) : InfoRetriever<Card, Deck> {

    override fun getCards(decks: List<Deck>): List<Card> {
        val cards = mutableListOf<Card>()
        for(deck in decks) {
            Log.d(TAG, "retrieving cards from " + deck.source)
            val contents = FileUtilities.getFileContents(assets, deck.source)
            val cardsArray = Gson().fromJson(contents, Array<Card>::class.java)
            cards.addAll(cardsArray)
        }
        return cards
    }

    override fun getDecks(): List<Deck> {
        val contents = FileUtilities.getFileContents(assets, BuildConfig.DECKS_SOURCE)
        Log.d(TAG, "retrieving decks from " + BuildConfig.DECKS_SOURCE)
        return Gson().fromJson(contents, Array<Deck>::class.java).sortedBy { it.priority }
    }

    companion object {
        private val TAG = InfoRetrieverFiles::class.java.simpleName
    }

}