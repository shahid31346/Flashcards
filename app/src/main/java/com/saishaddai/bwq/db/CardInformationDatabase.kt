package com.saishaddai.bwq.db

import android.arch.persistence.room.*
import android.content.Context
import com.saishaddai.bwq.model.CardEntity
import com.saishaddai.bwq.model.DATABASE_NAME
import com.saishaddai.bwq.model.DeckEntity

@Database(entities = [CardEntity::class, DeckEntity::class], version = 1)
abstract class CardInformationDatabase: RoomDatabase() {

    abstract fun cardDao(): CardDao
    abstract fun deckDao(): DeckDao

    companion object {
        var INSTANCE: CardInformationDatabase? = null

        fun getInstance(context: Context) : CardInformationDatabase? {
            if(INSTANCE == null) {
                synchronized((CardInformationDatabase::class)) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, CardInformationDatabase::class.java,
                        DATABASE_NAME).fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}