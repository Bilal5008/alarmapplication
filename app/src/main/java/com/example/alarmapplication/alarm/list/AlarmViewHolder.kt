package com.example.alarmapplication.alarm.list

import android.view.View

import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.example.alarmapplication.alarm.database.Alarm
import android.widget.ImageView
import android.widget.Switch
import androidx.cardview.widget.CardView
import com.example.alarmapplication.R

class AlarmViewHolder(
    private var itemView: View,
    private var itemClickListener: OnItemClickListener,
    private var listener: OnToggleAlarmListener
) : RecyclerView.ViewHolder(itemView) {
    private val alarmTime: TextView
    private val alarmRecurring: ImageView
    private val alarmRecurringDays: TextView
    private val alarmTitle: TextView
    private val cardView: CardView
    var alarmStarted: Switch

    fun bind(alarm: Alarm) {
        val alarmText = String.format("%02d:%02d", alarm.hour, alarm.minute)
        alarmTime.text = alarmText
        alarmStarted.isChecked = alarm.started
        //
//        if (alarm.getRecurring()) {
//            alarmRecurring.setImageResource(R.drawable.ic_repeat_black_24dp);
//            alarmRecurringDays.setText(alarm.getRecurringDaysText());
//        } else {
//            alarmRecurring.setImageResource(R.drawable.ic_looks_one_black_24dp);
//            alarmRecurringDays.setText("Once Off");
//        }
        if (alarm.title!!.isNotEmpty()) {
            alarmTitle.text =
                String.format("%s | %d | %d", alarm.title, alarm.alarmId, alarm.created)
        } else {
            alarmTitle.text = String.format("%s | %d | %d", "Alarm", alarm.alarmId, alarm.created)
        }
        alarmStarted.setOnCheckedChangeListener { _, isChecked -> listener.onToggle(alarm) }
        cardView.setOnClickListener {
            itemClickListener.onClick(alarm)

        }
    }

    init {
        alarmTime = itemView.findViewById(R.id.item_alarm_time)
        alarmStarted = itemView.findViewById(R.id.item_alarm_started)
        alarmRecurring = itemView.findViewById(R.id.item_alarm_recurring)
        alarmRecurringDays = itemView.findViewById(R.id.item_alarm_recurringDays)
        alarmTitle = itemView.findViewById(R.id.item_alarm_title)
        cardView = itemView.findViewById(R.id.item)
    }
}