package com.starganteknologi.sigas.ui.notifications

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.starganteknologi.sigas.R
import kotlinx.android.synthetic.main.list_selection_view_holder.view.*


class ListSelectionViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    val listPosition = itemView.itemNumber //itemView.findViewById<TextView>(R.id.itemNumber)
    val listTitle = itemView.itemString//itemView.findViewById<TextView>(R.id.itemString)
}