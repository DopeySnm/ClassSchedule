package com.example.classschedule.utils

import com.example.classschedule.models.DayWeek
import java.util.*

class DateHelper {
    companion object{
        @JvmStatic
        fun getThisDayWeek(): DayWeek?{
            val calendar: Calendar = Calendar.getInstance()
            calendar.time = Date()
            val day = calendar.get(Calendar.DAY_OF_WEEK)
            return DayWeek.values().find {it.num == day}
        }
    }
}