package com.example.alarmapplication.alarm.list

import com.example.alarmapplication.alarm.database.Alarm

interface OnToggleAlarmListener {
    fun onToggle(alarm: Alarm?)
}