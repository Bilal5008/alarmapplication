package com.example.alarmapplication.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.*


class AlarmSetter(var alarmMainActivity: AlarmMainActivity) {

    private var alarmMgr: AlarmManager? = null

    init {
        alarmMgr = alarmMainActivity.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    fun setAlarm(calender: Calendar): Calendar {
        var alarmIntent = Intent(alarmMainActivity, AlarmReceiver::class.java)
        alarmIntent.action = "uniqueCode"

        var pi = PendingIntent.getBroadcast(
            alarmMainActivity,
            1,
            alarmIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val calenderTimeinMillis =  calender.timeInMillis
        alarmMgr?.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calenderTimeinMillis,
            AlarmManager.INTERVAL_DAY,
            pi
        )
        return calender

    }

    fun cancelAlarm() {

        var alarmIntent = Intent(alarmMainActivity, AlarmReceiver::class.java)
        var pendingIntent = PendingIntent.getActivity(
            alarmMainActivity,
            1, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )
        pendingIntent.cancel()
        alarmMgr?.cancel(pendingIntent)

    }


}