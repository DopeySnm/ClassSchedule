package com.example.classschedule.models

data class Day(
    val typeDay: DayWeek,
    val lessons: List<Lesson>
)
