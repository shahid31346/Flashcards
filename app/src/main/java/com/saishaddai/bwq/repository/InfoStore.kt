package com.saishaddai.bwq.repository

interface InfoStore<C, D> {

    fun saveDecks(decks: List<D>)
    fun saveCards(cards: List<C>)
}