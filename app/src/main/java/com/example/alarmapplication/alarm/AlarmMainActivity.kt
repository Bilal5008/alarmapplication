package com.example.alarmapplication.alarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.alarmapplication.databinding.ActivityAlarmMainBinding
import java.text.DateFormat


import java.util.*

class AlarmMainActivity : AppCompatActivity() {
    var activityBinding: ActivityAlarmMainBinding? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityAlarmMainBinding.inflate(layoutInflater)
        setContentView(activityBinding?.root)




    }


}