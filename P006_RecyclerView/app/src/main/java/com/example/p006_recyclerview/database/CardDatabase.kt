package com.example.p006_recyclerview.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.p006_recyclerview.data.card.CardDao
import com.example.p006_recyclerview.model.CardModel
import java.util.concurrent.Executors

@Database(entities = [CardModel::class], version = 1)
abstract class CardDatabase: RoomDatabase(){

    // database hold dao and it's database configuration and it's instance
    // it's implementation will be written by Room
    abstract fun cardDao(): CardDao

    companion object{

        @Volatile
        private var INSTANCE: CardDatabase? = null

        fun getDatabase(context: Context): CardDatabase{
            INSTANCE?.let {
                return it;
            }
            val db = Room
                .databaseBuilder(context.applicationContext, CardDatabase::class.java, "card_db")
                .fallbackToDestructiveMigration()
                .build()
            INSTANCE = db
            return db
        }
    }
}