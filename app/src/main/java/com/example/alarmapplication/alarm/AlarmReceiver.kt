package com.example.alarmapplication.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        makeNotification(context, intent)

    }

    private fun makeNotification(context: Context?, intent: Intent?) {

        if (context != null) {
            makeStatusNotification("context", context)
        }
    }

}
