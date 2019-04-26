package com.saishaddai.bwq.repository

interface InfoRetriever<C, D> {

    fun getCards(decks: List<D>) : List<C>
    fun getDecks() : List<D>
}