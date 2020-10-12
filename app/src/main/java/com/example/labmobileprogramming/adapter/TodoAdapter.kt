package com.example.labmobileprogramming.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.labmobileprogramming.HasItemRecyclerView
import com.example.labmobileprogramming.R
import com.example.labmobileprogramming.model.TodoModel
import kotlinx.android.synthetic.main.item_recycler.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TodoAdapter(val items : ArrayList<TodoModel>, val context: Context, val caller:HasItemRecyclerView) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())
        holder.text?.text = "${items[position].text}"
        holder.dateNote?.text = "${currentDate}"
        holder.edit.setOnClickListener {
            caller.onEditItem(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val text = view.todocontextTxt
    val dateNote = view.datenoteTxt
    val edit = view.edit
}