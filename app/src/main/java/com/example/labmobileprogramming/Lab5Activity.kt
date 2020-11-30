package com.example.labmobileprogramming

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab5.*
import java.util.*

class Lab5Activity : AppCompatActivity() {
    private var wifiManager: WifiManager? = null
    private var results: List<ScanResult>? = null
    private val arrayList = ArrayList<String?>()
    private var adapter: ArrayAdapter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab5)

        scanBtn.setOnClickListener(View.OnClickListener { scanWifi() })
        wifiManager = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
        if (!wifiManager!!.isWifiEnabled) {
            Toast.makeText(this, "Wifi is disabled... We need to enable it", Toast.LENGTH_LONG)
                .show()
            wifiManager!!.isWifiEnabled = true
        }
        adapter = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1,
            arrayList as List<Any?>
        )
        wifiListView.setAdapter(adapter)
        scanWifi()
    }

    private fun scanWifi() {
        arrayList.clear()
        registerReceiver(wifiReceiver, IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
        wifiManager!!.startScan()
        Toast.makeText(this, "Scanning Wifi...", Toast.LENGTH_SHORT).show()
    }

    var wifiReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            results = wifiManager!!.scanResults
            unregisterReceiver(this)
            for (scanResult in (results as MutableList<ScanResult>?)!!) {
                arrayList.add(scanResult.SSID)
                adapter!!.notifyDataSetChanged()
            }
        }
    }
}