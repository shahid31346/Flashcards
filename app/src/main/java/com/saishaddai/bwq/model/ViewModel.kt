package com.saishaddai.bwq.model

class ViewModel {
    class User(val id: Int, val username: String)
    class QuestionDeck(val id: Long, val name : String)
    class QuestionItem(val id: Long, val deckId: Long, val question : String, val answer : String)

}