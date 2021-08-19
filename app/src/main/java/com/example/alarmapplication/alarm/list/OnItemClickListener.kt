package com.example.alarmapplication.alarm.list

import com.example.alarmapplication.alarm.database.Alarm

interface OnItemClickListener {
    fun onClick(alarm: Alarm?)
}