package com.saishaddai.bwq.repository

import com.saishaddai.bwq.model.Card
import com.saishaddai.bwq.model.Deck

class InfoRetrieverFiles : InfoRetriever<Card, Deck> {
    override fun getListOfCards(deck: String): ArrayList<Card> {
        return ArrayList()
    }

    override fun getDecks(type: String): ArrayList<Deck> {
        return ArrayList()
    }

}