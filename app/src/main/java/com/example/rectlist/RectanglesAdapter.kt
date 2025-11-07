package com.example.rectlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rectlist.databinding.ItemRectangleBinding


class RectanglesAdapter : ListAdapter<Int, RectanglesAdapter.ViewHolder>(DiffCallback()) {


    class ViewHolder(val binding: ItemRectangleBinding) : RecyclerView.ViewHolder(binding.root)


    class DiffCallback : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRectangleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        val ctx = holder.binding.root.context


        val bgColor = if (item % 2 == 0)
            ContextCompat.getColor(ctx, R.color.colorEven)
        else
            ContextCompat.getColor(ctx, R.color.colorOdd)


        holder.binding.rectangleCard.setCardBackgroundColor(bgColor)
        holder.binding.indexText.text = item.toString()
        holder.binding.rectangleCard.post {
            val width = holder.binding.rectangleCard.width
            holder.binding.rectangleCard.layoutParams.height = width
        }
    }
}