package com.example.task6

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    /*
    private lateinit var broadcast: Broadcast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        broadcast = Broadcast()
        val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(broadcast, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcast)
    }

    class Broadcast : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d(Broadcast::class.java.simpleName, "Air Plane mode")
        }
    }
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent("theBroadcast")
        intent.putExtra("phonenumber", "+84900909090")
        intent.putExtra("newpass","Please give me a cup of coffee")
        sendBroadcast(intent)
    }
}
