package com.example.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_complete_to_do.*

class CompleteToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_to_do)

        val todo = intent.extras?.getString("title")

        toDoTextView.text = todo

        completeButton.setOnClickListener {
            var prefs = getSharedPreferences("com.example.todolist.shredprefs", Context.MODE_PRIVATE)
            var todoStrings = prefs.getStringSet("todostrings", setOf())?.toMutableSet()
            if (todoStrings != null) {
                todoStrings.remove(todo)
            }
            prefs.edit().putStringSet("todostrings", todoStrings).apply()

            finish()
        }

    }


}
