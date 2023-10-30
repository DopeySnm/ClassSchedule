package com.example.classschedule.models

enum class DayWeek(val displayName: String, val num: Int) {
    MONDAY("Понедельник", 2),
    TUESDAY("Вторник", 3),
    WEDNESDAY("Среда", 4),
    THURSDAY("Четверг", 5),
    FRIDAY("Пятница", 6),
    SATURDAY("Суббота", 7),
    SUNDAY("Воскресенье", 1)
}