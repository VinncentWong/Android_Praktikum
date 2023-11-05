package com.example.p006_recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.p006_recyclerview.databinding.CardViewBinding
import com.example.p006_recyclerview.model.CardModel

// specify which type of ViewHolder that Adapter need to use
class MainAdapter(
    private val datas: List<CardModel>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    // ViewHolder need to hold the binding since it's functionality is focusing on binding business
    class ViewHolder(private val binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(cardModel: CardModel) {
            this.binding.title.text = cardModel.title
            this.binding.subtitle.text = cardModel.subtitle
        }
    }

    // this method will be called when RecylerView need a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val binding = CardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // position represents the position of data that RecylerView need
    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        val currentData = datas[position]

        // pass the data into the holder
        holder.bind(currentData)
    }

    override fun getItemCount(): Int {
        return this.datas.size
    }
}