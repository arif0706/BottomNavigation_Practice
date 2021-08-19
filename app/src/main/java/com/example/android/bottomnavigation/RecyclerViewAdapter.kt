package com.example.android.bottomnavigation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val context: Context,val list: List<ModelClass>,val itemClickListener: ItemClickListener ) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view:View=LayoutInflater.from(context).inflate(R.layout.recyler_view_list_item,parent,false);
        return ItemViewHolder(view);
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.title.text=list[position].title
        holder.description.text=list[position].description


    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ItemViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title:TextView=itemView.findViewById(R.id.title)
        val description:TextView=itemView.findViewById(R.id.description)

        init{
            itemView.setOnClickListener{
                itemClickListener.onItemClick(adapterPosition)
            }
        }


    }

    interface ItemClickListener{
        fun onItemClick(position:Int)
    }

}