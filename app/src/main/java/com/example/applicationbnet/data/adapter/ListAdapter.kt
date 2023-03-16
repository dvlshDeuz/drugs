package com.example.applicationbnet.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationbnet.R
import com.example.applicationbnet.data.Drug

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private lateinit var mListener: OnItemClickListener
    var drugsList = emptyList<Drug>()

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view, mListener)
    }

    override fun getItemCount(): Int {
        return drugsList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.itemTitle).text = drugsList[position].name
        holder.itemView.findViewById<TextView>(R.id.itemDescription).text = drugsList[position].description
    }

    class ListViewHolder(view: View, listener: OnItemClickListener): RecyclerView.ViewHolder(view) {

        init {
            itemView.setOnClickListener {
                listener.onItemClick(bindingAdapterPosition)
            }
        }
    }
}