package com.example.labmobileprogramming.ui.main

import androidx.lifecycle.ViewModel
import com.example.labmobileprogramming.model.TodoModel

class MainViewModel : ViewModel() {
    val items:ArrayList<TodoModel> = ArrayList()
}
