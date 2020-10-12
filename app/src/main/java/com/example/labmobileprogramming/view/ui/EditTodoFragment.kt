package com.example.labmobileprogramming.view.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.labmobileprogramming.R
import com.example.labmobileprogramming.model.TodoModel
import com.example.labmobileprogramming.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_edit_todo.*
import java.text.SimpleDateFormat
import java.util.*

class EditTodoFragment(var index: Int) : Fragment() {

    companion object {
        fun newInstance(index:Int) = EditTodoFragment(index)
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_todo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this.activity!!).get(MainViewModel::class.java)
        val todoItem: TodoModel = viewModel.items[index]
        toolbar.setNavigationOnClickListener {
            this.activity!!.onBackPressed()
        }
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())
        this.text_in.setText(todoItem.text)
        this.notedate.text = currentDate
        this.toolbar.title = currentDate
        this.text_in.requestFocus()
        if (text_in.text.isNotEmpty()){
            save.setOnClickListener {
                submit(text_in.text.toString())
            }
        }


    }

    fun submit(text:String){
        viewModel.items[index].text = text
        this.activity!!.onBackPressed()
    }

}
