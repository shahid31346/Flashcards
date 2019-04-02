package com.saishaddai.bwq.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "deck_table")
class DeckEntity {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var name: String = ""
    var desription: String = ""

}