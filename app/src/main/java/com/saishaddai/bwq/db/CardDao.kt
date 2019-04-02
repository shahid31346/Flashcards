package com.saishaddai.bwq.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.saishaddai.bwq.model.CardEntity

@Dao
interface CardDao {

    @Insert
    fun saveAll(cards: ArrayList<CardEntity>)

    @Insert
    fun save(card: CardEntity)

    @Query("DELETE FROM card_table")
    fun deleteAll()


    @Query("SELECT * FROM card_table ORDER BY deck DESC")
    fun getCardsByDeck() : LiveData<ArrayList<CardEntity>>



}