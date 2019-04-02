package com.saishaddai.bwq.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import com.saishaddai.bwq.db.CardDao
import com.saishaddai.bwq.db.CardInformationDatabase
import com.saishaddai.bwq.db.DeckDao
import com.saishaddai.bwq.model.CardEntity
import com.saishaddai.bwq.model.DeckEntity
import org.jetbrains.anko.doAsync

class DataRepository {

    private lateinit var deckDao: DeckDao
    private lateinit var cardDao: CardDao
    private lateinit var deckList : LiveData<ArrayList<DeckEntity>>
    private lateinit var cardList : LiveData<ArrayList<CardEntity>>

    constructor(application: Application) {
         val database: CardInformationDatabase = CardInformationDatabase.getInstance(application)!!
        deckDao = database.deckDao()
        cardDao = database.cardDao()
        deckList = deckDao.getDecks()
        cardList = cardDao.getCardsByDeck()
    }

    fun saveAllCards(cards: ArrayList<CardEntity>) {
        doAsync {
            cardDao.saveAll(cards)
        }

    }

    fun saveCard(card: CardEntity) {
        doAsync {
            cardDao.save(card)
        }
    }

    fun deleteAllCards() {
        doAsync {
            cardDao.deleteAll()
        }
    }


    fun saveAllDecks(decks: ArrayList<DeckEntity>) {
        doAsync {
            deckDao.saveAll(decks)
        }
    }

    fun saveDeck(deck: DeckEntity) {
        doAsync {
            deckDao.save(deck)
        }
    }

    fun deleteAllDecks() {
        doAsync {
            deckDao.deleteAll()
        }
    }
}