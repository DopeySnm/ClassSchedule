package com.example.classschedule.screens

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classschedule.R
import com.example.classschedule.adapters.DaysAdapter
import com.example.classschedule.databinding.FragmentWeekBinding
import com.example.classschedule.models.Day
import com.example.classschedule.models.DayWeek
import com.example.classschedule.models.Lesson
import com.example.classschedule.models.Week
import java.sql.Time


class WeekFragment : Fragment() {
    private var binding: FragmentWeekBinding? = null
    private var adapter: DaysAdapter = DaysAdapter()

    private var firstWeek: Week? = null
    private var secondWeek: Week? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding?.rcviewWeeks) {
            this ?: return
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@WeekFragment.adapter
            addItemDecoration(createItemDecorator())
        }

        firstWeek = Week(
            number=1,
            days=listOf(
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
            ),
        )

        secondWeek = Week(
            number=2,
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
        ),
        )

        adapter.submitList(firstWeek?.days!!)

        binding?.toolbar?.title = "Первая неделя ↑"
        binding?.toolbar?.setOnClickListener {
            showPopupMenu(binding?.toolbar!!)
            binding?.toolbar?.title = "${binding?.toolbar?.title?.subSequence(0, binding?.toolbar?.title?.length!! - 2).toString()} ↓"
        }

        binding?.toolbar?.setTitleTextColor(Color.WHITE);
        binding?.toolbar?.setSubtitleTextColor(Color.GRAY);
    }

    private fun showPopupMenu(v: View) {
        val popupMenu = PopupMenu(binding?.root?.context, v)
        popupMenu.inflate(R.menu.popupmenu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu1 -> {
                    binding?.toolbar?.title = "Первая неделя ↑"
                    adapter.clearList()
                    adapter.submitList(firstWeek?.days!!)
                    true
                }
                R.id.menu2 -> {
                    binding?.toolbar?.title = "Вторая неделя ↑"
                    adapter.clearList()
                    adapter.submitList(secondWeek?.days!!)
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

    private fun createItemDecorator() =
        DividerItemDecoration(requireContext(), RecyclerView.VERTICAL).apply {
            ContextCompat.getDrawable(requireContext(), R.drawable.day_item_decorator)
                ?.let { this@apply.setDrawable(it) }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeekBinding.inflate(inflater, container, false)
        return binding?.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = WeekFragment()
    }
}