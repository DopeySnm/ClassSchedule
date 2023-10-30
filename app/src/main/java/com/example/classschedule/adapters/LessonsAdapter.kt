package com.example.classschedule.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.classschedule.R
import com.example.classschedule.databinding.LessonItemBinding
import com.example.classschedule.models.Lesson
import java.sql.Time
import java.text.SimpleDateFormat

class LessonsAdapter: RecyclerView.Adapter<LessonsAdapter.DayViewHolder>() {

    private val list: MutableList<Lesson> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LessonItemBinding.inflate(inflater, parent, false)
        return DayViewHolder(binding)
    }

    override fun getItemCount(): Int =
        list.size


    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.bind(list[position])
        if (position == 0){
            holder.itemView.setBackgroundResource(R.drawable.lesson_round_corner_top)
        }
        if (position == list.size - 1){
            holder.itemView.setBackgroundResource(R.drawable.lesson_round_corner_bottom)
        }
    }

    fun submitList(list: List<Lesson>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    class DayViewHolder(
            private val binding: LessonItemBinding
        ): RecyclerView.ViewHolder(binding.root) {

        fun bind(lesson: Lesson) = with(binding) {
            timeStart.text = timestampToString(lesson.timeStart)
            timeEnd.text = timestampToString(lesson.timeEnd)
            title.text = lesson.title
            audience.text = AUDIENCE_FORMAT + lesson.audience
            teacher.text = TEACHER_FORMAT + lesson.teacher
        }

        private fun timestampToString(time: Time) =
            formatter.format(time)

        companion object {
            private const val AUDIENCE_FORMAT = "Аудитория: "
            private const val TEACHER_FORMAT = "Преподаватель: "
            private const val TIME_FORMAT = "HH:mm"
            private val formatter = SimpleDateFormat(TIME_FORMAT)
        }

    }
}