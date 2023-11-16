package com.example.p006_recyclerview.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("card")
data class CardModel(

    @ColumnInfo("title")
    var title: String,

    @ColumnInfo("subtitle")
    var subtitle: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    var id: Int? = null,
)