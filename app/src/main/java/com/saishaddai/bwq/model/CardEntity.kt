package com.saishaddai.bwq.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "card_table")
class CardEntity {

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

    @ColumnInfo(name = "title")
    var title: String = ""
    var content: String = ""
    var imageUrl: String = ""
    var deck : String = ""

}