package com.example.alarmapplication.alarm.database

data class Alarm (
    val alarmId: Int = 0,
    val hour: Int = 0,
    var minute:Int = 0,
    val started: Boolean = false,
    var recurring: Boolean = false,
    val monday: Boolean = false,
    var tuesday: Boolean = false,
    var wednesday: Boolean = false,
    var thursday: Boolean = false,
    var friday: Boolean = false,
    var saturday: Boolean = false,
    var sunday: Boolean = false,
    val title: String? = null,
    val created: Long = 0
)
