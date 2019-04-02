package com.saishaddai.bwq.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.saishaddai.bwq.model.CardEntity
import com.saishaddai.bwq.model.DATABASE_NAME
import com.saishaddai.bwq.model.DeckEntity
import org.jetbrains.anko.doAsync
import org.jetbrains.annotations.NotNull

@Database(entities = [CardEntity::class, DeckEntity::class], version = 1)
abstract class CardInformationDatabase : RoomDatabase() {

    abstract fun cardDao(): CardDao
    abstract fun deckDao(): DeckDao

    companion object {
        private var INSTANCE: CardInformationDatabase? = null

        fun getInstance(context: Context): CardInformationDatabase? {
            if (INSTANCE == null) {
                synchronized((CardInformationDatabase::class)) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CardInformationDatabase::class.java,
                        DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(PopulateDecksAndCardsCallBack())
                        .build()
                }
            }
            return INSTANCE
        }

//        fun destroyInstance() {
//            INSTANCE = null
//        }

        class PopulateDecksAndCardsCallBack : RoomDatabase.Callback() {

            override fun onCreate(@NotNull db: SupportSQLiteDatabase) {
                super.onCreate(db)
                doAsync {
                    //get all the decks from the Constants class given the flavor of somewhere else
                    val decks = ArrayList<DeckEntity>()
                    //get all the decks from assets' json file using initialInfoRepository
                    //populate the decks database using DecksDao
                    INSTANCE?.deckDao()?.saveAll(decks)
                    val cards = ArrayList<CardEntity>()
                    //get all the cards from initialInfoRepository from all assets files
                    //populate the cards database using CardDao
                    INSTANCE?.cardDao()?.saveAll(cards)

                }
            }
        }

    }


}