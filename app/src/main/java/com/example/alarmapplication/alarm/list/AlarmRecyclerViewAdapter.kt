package com.example.alarmapplication.alarm.list

import androidx.recyclerview.widget.RecyclerView
import com.example.alarmapplication.alarm.database.Alarm
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.alarmapplication.R

class AlarmRecyclerViewAdapter(
    private val alarms: List<Alarm>,
    private val itemClickListener: OnItemClickListener,
    private val toggleClickListener: OnToggleAlarmListener
) :
    RecyclerView.Adapter<AlarmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_alarm, parent, false)
        return AlarmViewHolder(itemView, itemClickListener ,toggleClickListener)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        val alarm = alarms[position]
        holder.bind(alarm)
    }

    override fun getItemCount(): Int {
        return alarms.size;

    }

//    fun setAlarms(alarms: List<Alarm>) {
//        this.alarms = alarms
//        notifyDataSetChanged()
//    }

    override fun onViewRecycled(holder: AlarmViewHolder) {
        super.onViewRecycled(holder)
        holder.alarmStarted.setOnCheckedChangeListener(null)
    }


}