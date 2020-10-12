package com.example.labmobileprogramming.view.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labmobileprogramming.view.`interface`.HasItemRecyclerView
import com.example.labmobileprogramming.R
import com.example.labmobileprogramming.view.adapter.TodoAdapter
import com.example.labmobileprogramming.model.TodoModel
import com.example.labmobileprogramming.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), HasItemRecyclerView {
    override fun onEditItem(index:Int) {
        val fragmentTransaction:FragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.container, EditTodoFragment.newInstance(index))
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun addItem(text:String){
        viewModel.items.add(TodoModel(text))
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this.activity!!).get(MainViewModel::class.java)

        recycler_view.layoutManager = LinearLayoutManager(this.activity!!.applicationContext)
        val adapter = TodoAdapter(viewModel.items, this.activity!!.applicationContext,this)
        recycler_view.adapter = adapter

        add.setOnClickListener {
            text_in.isFocusableInTouchMode = false
            text_in.setFocusable(false);
            text_in.isFocusableInTouchMode = true
            text_in.setFocusable(true);
            if (!text_in.text.isEmpty()){
                addItem(text_in.text.toString())
                adapter.notifyDataSetChanged()
                text_in.text.clear()
            }
        }
    }

}
