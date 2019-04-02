package com.saishaddai.bwq.repository

interface InfoRetriever<T, J> {

    fun getListOfCards(deck: String) : ArrayList<T>
    fun getDecks(type: String) : ArrayList<J>
}