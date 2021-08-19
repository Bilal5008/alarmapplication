package com.example.alarmapplication.alarm.editalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.alarmapplication.R
import com.example.alarmapplication.alarm.AlarmViewModel
import com.example.alarmapplication.alarm.AlarmViewModelFactory
import com.example.alarmapplication.databinding.FragmentEditAlarmBinding
import java.text.DateFormat
import java.util.*


class EditAlarmFragment : Fragment() {
    var globalCalenderInstance = Calendar.getInstance()
    lateinit var viewModel: AlarmViewModel
    lateinit var viewModelFactory: AlarmViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val activityBinding: FragmentEditAlarmBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_edit_alarm, container, false
        )


        viewModelFactory = AlarmViewModelFactory(activity as AppCompatActivity)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AlarmViewModel::class.java)

        activityBinding.timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->

            globalCalenderInstance = Calendar.getInstance().apply {
                timeInMillis = System.currentTimeMillis()
                set(Calendar.HOUR_OF_DAY, hourOfDay)
                set(Calendar.MINUTE, minute)
            }


        }

        activityBinding.setAlarm.setOnClickListener {
            settingAlarm()
            updateLiveDataTimeText()


        }
        activityBinding.cancelAlarm.setOnClickListener {
            viewModel.cancelAlarm()
        }

        observeLiveData(activityBinding)
        return activityBinding.root
    }

    private fun settingAlarm() {
        viewModel.setAlarm(globalCalenderInstance)

    }

    fun updateLiveDataTimeText() {

        var timeText = "Alarm set for: "
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(globalCalenderInstance.time)
        viewModel.getLiveData().value = timeText


    }

    // observes livedata from current activity
    fun observeLiveData(activityBinding: FragmentEditAlarmBinding) {
        viewModel
            .getLiveData()
            .observe(activity as AppCompatActivity,
                { value -> activityBinding.timeDisplay.text = value })
    }


}