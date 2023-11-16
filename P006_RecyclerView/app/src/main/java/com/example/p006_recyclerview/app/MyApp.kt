package com.example.p006_recyclerview.app

import android.app.Application
import com.example.p006_recyclerview.database.CardDatabase

class MyApp : Application() {

    // make the bean lazy by default by propagating into lazy implementation
    val cardDatabase: CardDatabase by lazy{
        CardDatabase.getDatabase(this)
    }
}