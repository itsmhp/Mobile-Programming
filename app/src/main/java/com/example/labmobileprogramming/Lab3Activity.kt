package com.example.labmobileprogramming

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab3.*

class Lab3Activity : AppCompatActivity() {

    var handler:Handler = Handler()
    var runnable:Runnable = Runnable{}
    var stopwatchRunning=false

    var milliSecond:Int = 0
    var second:Int = 0
    var minute:Int = 0

    fun stopwatchPause(){
        stopwatchRunning=false
        handler.removeCallbacks(runnable)
    }

    fun stopwatchReset(){
        stopwatchRunning=false
        handler.removeCallbacks(runnable)
        milliSecond = 0
        second = 0
        minute = 0
        timeChronometer.setText("00:00:00")
    }

    fun stopwatchStart(){
        stopwatchRunning=true
        handler.removeCallbacks(runnable)
        runnable = object:Runnable{
            override fun run(){
                milliSecond+=1
                if (milliSecond == 100){
                    milliSecond = 0
                    second+=1
                }
                if (second == 60){
                    second = 0
                    minute += 1
                }
                timeChronometer.setText(String.format("%02d", minute)+":"+String.format("%02d", second)+":"+String.format("%02d", milliSecond))
                if (minute == 60){
                    handler.removeCallbacks(runnable)
                    return
                }

                handler.postDelayed(this, 1)
            }
        }
        handler.post(runnable)
    }

    override fun onBackPressed() {
        Toast.makeText(applicationContext, "PRESS EXIT BUTTON", Toast.LENGTH_LONG).show()
    }

    fun exit(){
        super.onBackPressed()
    }

    override fun onPause() {
        if (stopwatchRunning){
            super.onResume()
        }
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab3)

        playBtn.setOnClickListener {
            stopwatchStart()
        }

        pauseBtn.setOnClickListener {
            stopwatchPause()
        }

        resetBtn.setOnClickListener {
            stopwatchReset()
        }

        exitBtn.setOnClickListener {
            exit()
        }
    }
}
