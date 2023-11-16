package com.example.p006_recyclerview.data.card

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CardViewModelFactory(
    private val dao: CardDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardViewModel::class.java)){
            return CardViewModel(dao) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel model class")
        }
    }
}