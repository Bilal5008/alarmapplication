package com.example.alarmapplication.alarm.list

import android.graphics.Path
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import com.example.alarmapplication.R
import com.example.alarmapplication.databinding.FragmentAlarmListBinding

class AlarmListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentAlarmListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_alarm_list, container, false
        )

        setClickListener(binding)
        return binding.root
    }

    private fun setClickListener(binding: FragmentAlarmListBinding) {
        binding.addAlarm.setOnClickListener {


            findNavController().navigate(R.id.action_alarmListFragment_to_editAlarmFragment)
        }
    }

}