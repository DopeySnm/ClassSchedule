package com.example.classschedule.screens

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classschedule.MainActivity
import com.example.classschedule.R
import com.example.classschedule.adapters.LessonsAdapter
import com.example.classschedule.databinding.FragmentDayBinding
import com.example.classschedule.models.Day
import com.example.classschedule.models.DayWeek
import com.example.classschedule.models.Lesson
import com.example.classschedule.models.Week
import com.example.classschedule.utils.DateHelper
import java.sql.Time
import java.util.*


class DayFragment : Fragment() {
    private var binding: FragmentDayBinding? = null
    private var adapter: LessonsAdapter = LessonsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding?.rcviewLessons) {
            this ?: return
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@DayFragment.adapter
        }

        val week = Week(
            number=1,
            days=listOf(
                Day(
                    typeDay=DayWeek.MONDAY,
                    lessons = listOf(
                        Lesson(
                            title="Матан",
                            timeStart = Time(11, 25, 0),
                            timeEnd = Time(12, 50, 0),
                            audience="Нагуманова",
                            teacher="A-13"
                        ),
                        Lesson(
                            title="Русский",
                            timeStart = Time(11, 25, 0),
                            timeEnd = Time(12, 50, 0),
                            audience="Подгуманова",
                            teacher="A-15"
                        ),
                        Lesson(
                            title="Русский",
                            timeStart = Time(11, 25, 0),
                            timeEnd = Time(12, 50, 0),
                            audience="Подгуманова",
                            teacher="A-15"
                        ),
                    )
                ),
                Day(
                    typeDay=DayWeek.SUNDAY,
                    lessons = listOf(
                        Lesson(
                            title="Матан1",
                            timeStart = Time(11, 25, 0),
                            timeEnd = Time(12, 50, 0),
                            audience="Нагуманова",
                            teacher="A-13"
                        ),
                        Lesson(
                            title="Русский1",
                            timeStart = Time(11, 25, 0),
                            timeEnd = Time(12, 50, 0),
                            audience="Подгуманова",
                            teacher="A-15"
                        ),
                    )
                ),
                Day(
                    typeDay=DayWeek.THURSDAY,
                    lessons = listOf(
                        Lesson(
                            title="Матан2",
                            timeStart = Time(11, 25, 0),
                            timeEnd = Time(12, 50, 0),
                            audience="Нагуманова",
                            teacher="A-13"
                        ),
                        Lesson(
                            title="Русский2",
                            timeStart = Time(11, 25, 0),
                            timeEnd = Time(12, 50, 0),
                            audience="Подгуманова",
                            teacher="A-15"
                        ),
                    )
                ),
                Day(
                    typeDay=DayWeek.FRIDAY,
                    lessons = listOf(
                        Lesson(
                            title="Матан3",
                            timeStart = Time(11, 25, 0),
                            timeEnd = Time(12, 50, 0),
                            audience="Нагуманова",
                            teacher="A-13"
                        ),
                        Lesson(
                            title="Русский3",
                            timeStart = Time(11, 25, 0),
                            timeEnd = Time(12, 50, 0),
                            audience="Подгуманова",
                            teacher="A-15"
                        ),
                    )
                )
        )
        )
        val dayWeek = DateHelper.getThisDayWeek()
        if (dayWeek != null) {
            val day = week.getDey(dayWeek)
            if (day != null){
                adapter.submitList(day.lessons)
                binding?.toolbar?.title = day.typeDay.displayName
            }
            else{
                binding?.toolbar?.title = "Сегодня нет занятий"
            }
        }
        binding?.toolbar?.setTitleTextColor(Color.WHITE)
        binding?.toolbar?.setSubtitleTextColor(Color.GRAY)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDayBinding.inflate(inflater, container, false)
        return binding?.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = DayFragment()
    }
}