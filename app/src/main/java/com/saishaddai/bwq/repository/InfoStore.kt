package com.saishaddai.bwq.repository

interface InfoStore<T, J> {

    fun saveListOfCards(cards: ArrayList<T>)
    fun saveDecks(decks: ArrayList<J>)
}