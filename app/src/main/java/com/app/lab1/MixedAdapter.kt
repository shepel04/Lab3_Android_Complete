package com.app.lab1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.lab1.databinding.DogItemBinding
import com.app.lab1.databinding.HeaderItemBinding

class MixedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemList = emptyList<ListItem>()

    // DogItem
    class DogHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = DogItemBinding.bind(item)
        fun bind(dog: DogItem) = with(binding) {
            im.setImageResource(dog.imageId)
            tvTitle.text = dog.title
        }
    }

    // HeaderItem
    class HeaderHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = HeaderItemBinding.bind(item)
        fun bind(header: HeaderItem) = with(binding) {
            tvHeader.text = header.header
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_TYPE_DOG -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.dog_item, parent, false)
                DogHolder(view)
            }
            ITEM_TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.header_item, parent, false)
                HeaderHolder(view)
            }
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = itemList[position]) {
            is DogItem -> (holder as DogHolder).bind(item)
            is HeaderItem -> (holder as HeaderHolder).bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].type
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun submitList(newList: List<ListItem>) {
        itemList = newList
        notifyDataSetChanged()
    }
}

