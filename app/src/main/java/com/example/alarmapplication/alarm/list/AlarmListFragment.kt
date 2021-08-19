package com.example.alarmapplication.alarm.list

import android.graphics.Path
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alarmapplication.R
import com.example.alarmapplication.alarm.database.Alarm
import com.example.alarmapplication.databinding.FragmentAlarmListBinding

class AlarmListFragment : Fragment(), OnToggleAlarmListener, OnItemClickListener {
    private var alarmRecyclerViewAdapter: AlarmRecyclerViewAdapter? = null
    private var binding: FragmentAlarmListBinding?= null
    private var alarms = arrayListOf(
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        ),
        Alarm(
            0,
            0,
            0,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            "First Alaram",
            1
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_alarm_list, container, false
        )
        setRecyclerViewAdapter()
        setClickListener()
        return binding?.root
    }

    private fun setRecyclerViewAdapter() {
        alarmRecyclerViewAdapter = AlarmRecyclerViewAdapter(alarms, this, this)
        binding?.listAlarmRecycler?.layoutManager = LinearLayoutManager(context)
        binding!!.listAlarmRecycler.adapter = alarmRecyclerViewAdapter
    }

    private fun setClickListener() {
        binding?.addAlarm?.setOnClickListener {
            findNavController().navigate(R.id.action_alarmListFragment_to_editAlarmFragment)
        }
    }

    override fun onToggle(alarm: Alarm?) {

    }



    override fun onClick(alarm: Alarm?) {
        if (alarm != null)
        findNavController().navigate(R.id.action_alarmListFragment_to_alarmDetailFragment)
    }

}