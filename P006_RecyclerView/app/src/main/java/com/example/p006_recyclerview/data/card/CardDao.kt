package com.example.p006_recyclerview.data.card

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.p006_recyclerview.model.CardModel
import kotlinx.coroutines.flow.Flow


@Dao
interface CardDao {

    @Query("""
        SELECT 
            id,
            title,
            subtitle
        FROM    
            card
    """)
    fun getListCard(): Flow<List<CardModel>>

    @Transaction
    @Insert
    fun insertCard(card: CardModel)

    @Transaction
    @Query("""
        DELETE FROM card
        WHERE
        id=:id
    """)
    fun deleteCard(id: Int): Int

    @Transaction
    @Query("""
        DELETE FROM card
    """)
    fun deleteAll()
}