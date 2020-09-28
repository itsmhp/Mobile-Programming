package com.example.labmobileprogramming

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab2.*

class Lab2Activity : AppCompatActivity() {
    private var counterTxt: TextView? = null
    private var decrementBtn: Button? = null
    private var resetBtn: Button? = null
    private var incrementBtn: Button? = null
    private var value = 0
    private val clickListener =
        View.OnClickListener { v ->
            when (v.id) {
                R.id.decrementBtn -> decrementCounter()
                R.id.resetBtn -> initCounter()
                R.id.incrementBtn -> incrementCounter()
            }
        }

    fun getValue(): Int {
        return this.value
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2)
        value = 0
        counterTxt = findViewById<View>(R.id.counterTxt) as TextView
        decrementBtn = findViewById<View>(R.id.decrementBtn) as Button
        resetBtn = findViewById<View>(R.id.resetBtn) as Button
        incrementBtn = findViewById<View>(R.id.incrementBtn) as Button
        decrementBtn!!.setOnClickListener(clickListener)
        resetBtn!!.setOnClickListener(clickListener)
        incrementBtn!!.setOnClickListener(clickListener)
        initCounter()
    }

    fun initCounter() {
        this.value = 0
        counterTxt?.text = this.value.toString()
    }

    fun decrementCounter() {
        this.value--
        counterTxt?.text = this.value.toString()
    }

    fun incrementCounter() {
        this.value++
        counterTxt?.text = this.value.toString()
    }
}