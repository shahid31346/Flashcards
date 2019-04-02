package com.saishaddai.bwq.repository

import com.saishaddai.bwq.BuildConfig
import com.saishaddai.bwq.model.Card

class InitialInfoRepository {

    fun initInfo() {
        val infoRetriever = InfoRetrieverFiles()
        val infoStore = InfoStoreRoom()
        var type = ""
        if(BuildConfig.FLAVOR == "androidtraining")
            type = "Java"
        val decksArray = infoRetriever.getDecks(type)
        infoStore.saveDecks(decksArray)

        val allCards = ArrayList<Card>()
        for(deck in decksArray) {
            allCards.addAll(infoRetriever.getListOfCards(deck.name))
        }

        infoStore.saveListOfCards(allCards)
    }
}