package com.example.shipapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shipapp.databinding.ItemListBinding
import com.example.shipapp.extensions.load

class Adapter(private val list: MutableList<String>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var onClick: OnClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun setOnClick(onClick: OnClick){
        this.onClick = onClick
    }

    inner class ViewHolder(private var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: String) {
            binding.ivImage.load(s)
            itemView.setOnClickListener {
                if (binding.transparent.visibility == View.GONE) {
                    binding.transparent.visibility = View.VISIBLE
                    onClick.onClicked(s)
                } else {
                    binding.transparent.visibility = View.GONE
                    onClick.onRemoved(s)
                }
            }
        }
    }

    interface OnClick {
        fun onClicked(position: String)
        fun onRemoved(position: String)
    }
}