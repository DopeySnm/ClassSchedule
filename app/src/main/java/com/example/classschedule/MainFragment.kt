package com.example.classschedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import com.example.classschedule.databinding.FragmentMainBinding
import com.example.classschedule.screens.DayFragment
import com.example.classschedule.screens.WeekFragment

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.bottomNavigation?.setOnItemSelectedListener {
            changeTab(it.itemId)
            true
        }
        changeTab(R.id.select_day)
    }

    private fun changeTab(@IdRes id: Int){
        val navHostId = binding?.navHost?.id
        navHostId ?: return
        val transaction = childFragmentManager.beginTransaction()
        when (id) {
            R.id.select_week ->
                transaction.replace(navHostId, WeekFragment.newInstance())

            R.id.select_day ->
                transaction.replace(navHostId, DayFragment.newInstance())
        }
        transaction.commit()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {

            }
    }
}