package com.example.alarmapplication.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.*
import android.R.id


class AlarmSetter(var alarmActivity: AlarmActivity) {

    private var alarmMgr: AlarmManager? = null

    init {
        alarmMgr = alarmActivity.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    fun setAlarm(calender: Calendar) {
        var alarmIntent = Intent(alarmActivity, AlarmReceiver::class.java)
        alarmIntent.action = "uniqueCode"

        var pi = PendingIntent.getBroadcast(
            alarmActivity,
            1,
            alarmIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )


        alarmMgr?.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calender.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pi
        )

    }

    fun cancelAlarm() {

        var alarmIntent = Intent(alarmActivity, AlarmReceiver::class.java)
        var pendingIntent = PendingIntent.getActivity(
            alarmActivity,
            1, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )
        pendingIntent.cancel()
        alarmMgr?.cancel(pendingIntent)

    }


}