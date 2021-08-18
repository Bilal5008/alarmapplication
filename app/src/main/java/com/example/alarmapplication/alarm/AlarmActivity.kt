package com.example.alarmapplication.alarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alarmapplication.databinding.ActivityAlarmBinding
import java.text.DateFormat


import java.util.*

class AlarmActivity : AppCompatActivity() {
    var activityBinding: ActivityAlarmBinding? = null
    var globalCalenderInstance = Calendar.getInstance()

    lateinit var viewModel: AlarmViewModel
    lateinit var viewModelFactory: AlarmViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(activityBinding?.root)

        viewModelFactory = AlarmViewModelFactory(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AlarmViewModel::class.java)

        activityBinding?.timePicker?.setOnTimeChangedListener { view, hourOfDay, minute ->

            globalCalenderInstance = Calendar.getInstance().apply {
                timeInMillis = System.currentTimeMillis()
                set(Calendar.HOUR_OF_DAY, hourOfDay)
                set(Calendar.MINUTE, minute)
            }


        }

        activityBinding?.setAlarm?.setOnClickListener {
            settingAlarm()
            updateLiveDataTimeText()



        }
        activityBinding?.cancelAlarm?.setOnClickListener {
            viewModel.cancelAlarm()
        }

        observeLiveData()


    }

    private fun settingAlarm() {
        viewModel.setAlarm(globalCalenderInstance)

    }

    fun updateLiveDataTimeText() {

        var timeText = "Alarm set for: "
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(globalCalenderInstance.time)
        viewModel.getLiveData().value =  timeText


    }

    // observes livedata from current activity
    fun observeLiveData() {
        viewModel
            .getLiveData()
            .observe(this,
                { value -> activityBinding?.timeDisplay?.text = value })
    }
}