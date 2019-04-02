package com.saishaddai.bwq.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.saishaddai.bwq.model.DeckEntity

@Dao
interface DeckDao {

    @Insert
    fun saveAll(decks: ArrayList<DeckEntity>)

    @Insert
    fun save(card: DeckEntity)

    @Query("DELETE FROM deck_table")
    fun deleteAll()


    @Query("SELECT * FROM deck_table")
    fun getDecks() : LiveData<ArrayList<DeckEntity>>



}