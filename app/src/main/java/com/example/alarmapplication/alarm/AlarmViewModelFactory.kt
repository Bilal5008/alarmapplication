package com.example.alarmapplication.alarm

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class AlarmViewModelFactory(private val alarmActivity: AppCompatActivity) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(AlarmViewModel::class.java)) {
            AlarmViewModel(alarmActivity as AlarmMainActivity) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}