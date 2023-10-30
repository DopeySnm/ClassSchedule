package com.example.classschedule.models

import java.sql.Time

data class Lesson(
    val title: String,
    val timeStart: Time,
    val timeEnd: Time,
    val audience: String,
    val teacher: String
)
