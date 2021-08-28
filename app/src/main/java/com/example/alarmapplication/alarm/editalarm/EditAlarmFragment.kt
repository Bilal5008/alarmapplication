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
import java.util.*


class EditAlarmFragment : Fragment() {
    private var globalCalenderInstance: Calendar = Calendar.getInstance()
    private lateinit var viewModel: AlarmViewModel
    private lateinit var viewModelFactory: AlarmViewModelFactory
    private lateinit var activityBinding: FragmentEditAlarmBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        activityBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_edit_alarm, container, false
        )

        viewModelFactory = AlarmViewModelFactory(activity as AppCompatActivity)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AlarmViewModel::class.java)

        activityBinding.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->

            globalCalenderInstance = Calendar.getInstance().apply {
                timeInMillis = System.currentTimeMillis()
                set(Calendar.HOUR_OF_DAY, hourOfDay)
                set(Calendar.MINUTE, minute)
            }
        }

        activityBinding.setAlarm.setOnClickListener {
            settingAlarm()
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

    // observes livedata from current activity
    private fun observeLiveData(activityBinding: FragmentEditAlarmBinding) {

        viewModel.liveData.observe(activity as AppCompatActivity) { value ->
            activityBinding.timeDisplay.text = value
        }
    }


}