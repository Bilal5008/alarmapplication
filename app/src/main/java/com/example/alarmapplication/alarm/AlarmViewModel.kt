package com.example.alarmapplication.alarm

import androidx.lifecycle.ViewModel
import java.util.*
import androidx.lifecycle.MutableLiveData
import java.text.DateFormat


class AlarmViewModel(context: AlarmMainActivity) : ViewModel() {

  private   var alarmSetter = AlarmSetter(context)
     var liveData = MutableLiveData<String>()
    private lateinit var _alarm : Calendar

     val alarm: Calendar
        get() = _alarm


    internal fun cancelAlarm() {
        alarmSetter.cancelAlarm()
    }

    fun setAlarm(calender: Calendar) {
        _alarm =  alarmSetter.setAlarm(calender)
        var timeText = "Alarm set for: "
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(_alarm.time)
        liveData.value = timeText
    }


}