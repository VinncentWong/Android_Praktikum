package com.example.p006_recyclerview.data.card

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p006_recyclerview.data.card.CardDao
import com.example.p006_recyclerview.model.CardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CardViewModel(
    private val cardDao: CardDao
): ViewModel() {

    private val TAG = "CardViewModel"

    fun getListCard(): Flow<List<CardModel>>{
        return this.cardDao.getListCard()
    }

    suspend fun insertCard(card: CardModel) = withContext(Dispatchers.IO) {
        Log.d(TAG, "insert card with card $card is called")
        cardDao.insertCard(card)
    }

    suspend fun deleteCard(id: Int): Int = withContext(Dispatchers.IO) {
        cardDao.deleteCard(id)
    }

    suspend fun deleteAllCard() = withContext(Dispatchers.IO){
        cardDao.deleteAll()
    }
}