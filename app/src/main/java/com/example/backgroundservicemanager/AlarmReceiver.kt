package com.example.backgroundservicemanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AlarmReceiver  : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        // Perform the API call here
        performApiCall()
    }


    private fun performApiCall() {
        // Your API call logic here
        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        Log.d("AlarmReceiver", "Performing API call at $currentTime")
        // Use a networking library like Retrofit or HttpURLConnection to make the API call
    }
}