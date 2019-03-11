package com.saishaddai.bwq.model

class APIModel {
    open class User {
        //@PrimaryKey
        var id : Long = 0L
        var username : String = ""

        //@SerializedName("full_name") //gson
        var fullName : String? = ""


    }
    class QuestionDeck(val id: Long, val name : String)
    class QuestionItem(val id: Long, val deckId: Long, val question : String, val answer : String)

}