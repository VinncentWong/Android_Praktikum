package com.example.p006_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.p006_recyclerview.adapter.MainAdapter
import com.example.p006_recyclerview.data.card.CardViewModel
import com.example.p006_recyclerview.data.card.CardViewModelFactory
import com.example.p006_recyclerview.database.CardDatabase
import com.example.p006_recyclerview.databinding.ActivityMainBinding
import com.example.p006_recyclerview.model.CardModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

//    private val data = mutableListOf<CardModel>(
//        CardModel(title = "Title1", subtitle = "Subtitle1"),
//        CardModel(title = "Title2", subtitle = "Subtitle2"),
//        CardModel(title = "Title3", subtitle = "Subtitle3"),
//        CardModel(title = "Title4", subtitle = "Subtitle4"),
//        CardModel(title = "Title5", subtitle = "Subtitle5"),
//        CardModel(title = "Title6", subtitle = "Subtitle6"),
//        CardModel(title = "Title7", subtitle = "Subtitle7"),
//        CardModel(title = "Title8", subtitle = "Subtitle8"),
//        CardModel(title = "Title9", subtitle = "Subtitle9"),
//        CardModel(title = "Title10", subtitle = "Subtitle10"),
//        CardModel(title = "Title11", subtitle = "Subtitle11"),
//        CardModel(title = "Title12", subtitle = "Subtitle12"),
//        CardModel(title = "Title13", subtitle = "Subtitle13"),
//        CardModel(title = "Title14", subtitle = "Subtitle14"),
//        CardModel(title = "Title15", subtitle = "Subtitle15"),
//        CardModel(title = "Title16", subtitle = "Subtitle16"),
//        CardModel(title = "Title17", subtitle = "Subtitle17"),
//        CardModel(title = "Title18", subtitle = "Subtitle18"),
//        CardModel(title = "Title19", subtitle = "Subtitle19"),
//        CardModel(title = "Title20", subtitle = "Subtitle20"),
//        CardModel(title = "Title21", subtitle = "Subtitle21"),
//        CardModel(title = "Title22", subtitle = "Subtitle22"),
//        CardModel(title = "Title23", subtitle = "Subtitle23"),
//        CardModel(title = "Title24", subtitle = "Subtitle24"),
//        CardModel(title = "Title25", subtitle = "Subtitle25")
//    )

    private val TAG = "MainActivity"

    private val data = mutableListOf<CardModel>()

    private val mainAdapter = MainAdapter(data)

    private lateinit var cardViewModel: CardViewModel

    private lateinit var binding: ActivityMainBinding

    private lateinit var tambah: Button

    private lateinit var hapus: Button

    private lateinit var hapusSemua: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(this.layoutInflater)

        val root = binding.root

        setContentView(root)

        tambah = binding.tambah

        hapus = binding.hapus

        binding.recyclerView.adapter = mainAdapter

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        hapusSemua = binding.hapusAll

        cardViewModel = CardViewModelFactory(
            CardDatabase
                .getDatabase(this)
                .cardDao()
        )
            .create(CardViewModel::class.java)

        lifecycle.coroutineScope.launch {
            cardViewModel.getListCard().collect{
                data.clear()
                data.addAll(it)
                mainAdapter.notifyDataSetChanged()
            }
        }

        tambah.setOnClickListener {
            val cardModel = CardModel("title ${data.size}", "subtitle ${data.size}")
            lifecycle.coroutineScope.launch {
                Log.d(TAG, "tambah terpanggil, cardmodel = $cardModel")
                cardViewModel.insertCard(cardModel)
                cardViewModel.getListCard().collect{
                    data.clear()
                    data.addAll(it)
                    mainAdapter.notifyDataSetChanged()
                }
            }
        }

        hapus.setOnClickListener {
            lifecycle.coroutineScope.launch {
                val removedLatestData = data.removeLast()
                Log.d(TAG, "removed = $removedLatestData")
                cardViewModel.deleteCard(removedLatestData.id!!)
                mainAdapter.notifyDataSetChanged()
            }
        }

        hapusSemua.setOnClickListener {
            lifecycle.coroutineScope.launch {
                cardViewModel.deleteAllCard()
                data.clear()
                mainAdapter.notifyDataSetChanged()
            }
        }
    }
}