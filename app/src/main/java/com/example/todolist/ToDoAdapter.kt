package com.example.todolist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R.*
import kotlinx.android.synthetic.main.todo_row.view.*

class ToDoAdapter(val todoStrings: List<String>): RecyclerView.Adapter<ToDoAdapter.ToDoHolder>() {

    class ToDoHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {

        var view: View = v
        var title: String = ""

        init {
            v.setOnClickListener(this)
        }

        fun bindToDo(title: String) {
            this.title = title
            view.textView.text = title
        }

        override fun onClick(v: View?) {
            val intent = Intent(view.context, CompleteToDoActivity::class.java)
            intent.putExtra("title", title)
            startActivity(view.context, intent, null)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
        return ToDoHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_row, parent, false))
    }

    override fun getItemCount(): Int {
        return todoStrings.count()
    }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
        val title = todoStrings[position]
        holder.bindToDo(title)
    }


}
