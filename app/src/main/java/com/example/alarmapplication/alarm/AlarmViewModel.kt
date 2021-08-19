package com.example.alarmapplication.alarm

import androidx.lifecycle.ViewModel
import java.util.*
import androidx.lifecycle.MutableLiveData


class AlarmViewModel(context: AlarmMainActivity) : ViewModel() {

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