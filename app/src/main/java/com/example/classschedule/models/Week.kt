package com.example.classschedule.models


data class Week(
    val number: Int,
    val days: List<Day>
){
    fun getDey(dayWeek: DayWeek): Day?{
        return days.find { it.typeDay == dayWeek }
    }
}
