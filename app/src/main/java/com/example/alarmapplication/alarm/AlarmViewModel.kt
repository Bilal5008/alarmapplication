package com.example.alarmapplication.alarm

import androidx.lifecycle.ViewModel
import com.example.alarmapplication.alarm.AlarmSetter
import java.text.DateFormat
import java.util.*
import androidx.lifecycle.MutableLiveData




class AlarmViewModel( context: AlarmActivity) : ViewModel() {
     var alarmSetter = AlarmSetter(context)



    private var liveData = MutableLiveData<String>()

    internal fun setAlarm(calender: Calendar) {
        alarmSetter.setAlarm(calender)


    }

    fun getLiveData(): MutableLiveData<String> {
        return liveData
    }

    internal fun cancelAlarm() {

        alarmSetter.cancelAlarm()
    }





}