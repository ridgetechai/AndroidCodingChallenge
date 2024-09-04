package com.example.otchallenge.presentation.bookList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.otchallenge.common.adapter.DelegateAdapter
import com.example.otchallenge.common.adapter.ItemModel
import com.example.otchallenge.databinding.ItemBookBinding
import com.example.otchallenge.presentation.bookList.model.BookItemModel

class BookDelegateAdapter : DelegateAdapter<BookDelegateAdapter.BookViewHolder, ItemModel> {

    override fun onCreateViewHolder(parent: ViewGroup): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ItemModel) {
        (holder as BookViewHolder).bind(item)
    }

    override fun isForViewType(item: ItemModel): Boolean = item is ItemModel

    class BookViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemModel) {
            val book = item as BookItemModel
            Glide.with(binding.imageView)
                .load(book.imageUrl)
                .into(binding.imageView)

        }
    }
}