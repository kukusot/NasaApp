package com.ikukushev.nasaapp.pictures.apod

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ikukushev.nasaapp.R
import com.ikukushev.nasaapp.core.displayImageWithRatio
import com.ikukushev.nasaapp.pictures.apod.data.ApodListItem
import kotlinx.android.synthetic.main.item_apod.view.*

class ApodAdapter : RecyclerView.Adapter<ApodAdapter.ApodViewHolder>() {

    val items: MutableList<ApodListItem> = mutableListOf()

    fun setItems(apods: List<ApodListItem>) {
        items.clear()
        items.addAll(apods)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApodViewHolder {
        return ApodViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_apod, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ApodViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    inner class ApodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image = itemView.image

        fun onBind(apod: ApodListItem) {
            image.displayImageWithRatio(apod.url)
        }
    }
}