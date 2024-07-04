package com.example.backgroundservicemanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log

object AlarmScheduler {

    fun scheduleRepeatingAlarm(context: Context) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE // Using FLAG_IMMUTABLE
        )

        val intervalMillis: Long = 1 * 60 * 1000 // 1 minute for testing
        val triggerAtMillis = SystemClock.elapsedRealtime() + intervalMillis

        Log.d("AlarmScheduler", "Scheduling alarm to trigger every $intervalMillis milliseconds")

        alarmManager.setRepeating(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            triggerAtMillis,
            intervalMillis,
            pendingIntent
        )
    }
}