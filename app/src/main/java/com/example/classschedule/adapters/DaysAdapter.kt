package com.example.classschedule.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classschedule.databinding.DayItemBinding
import com.example.classschedule.models.Day

class DaysAdapter: RecyclerView.Adapter<DaysAdapter.WeekViewHolder>() {

    private val list: MutableList<Day> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DayItemBinding.inflate(inflater, parent, false)
        return WeekViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int =
        list.size

    fun clearList(){
        this.list.clear()
        notifyDataSetChanged()
    }

    fun submitList(list: List<Day>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class WeekViewHolder(
            private val binding: DayItemBinding
        ): RecyclerView.ViewHolder(binding.root){
        private var adapter: LessonsAdapter = LessonsAdapter()

        fun bind(day: Day) = with(binding){
            binding.RCviewLessons.adapter = adapter
            binding.RCviewLessons.layoutManager = LinearLayoutManager(binding.root.context)
            adapter.submitList(day.lessons)
            binding.nameDayWeek.text = day.typeDay.displayName
        }

    }

}