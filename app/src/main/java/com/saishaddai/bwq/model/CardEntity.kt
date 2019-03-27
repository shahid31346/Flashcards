package com.saishaddai.bwq.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "cards")
class CardEntity {

    @PrimaryKey(autoGenerate = false)
    var id : Long = 0
    var title: String = ""
    var content: String = ""
    var deck : String = ""

}