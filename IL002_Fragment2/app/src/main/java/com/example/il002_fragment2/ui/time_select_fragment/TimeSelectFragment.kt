package com.example.il002_fragment2.ui.time_select_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.il002_fragment2.databinding.FragmentTimeSelectBinding

class TimeSelectFragment : Fragment() {

    private lateinit var _binding: FragmentTimeSelectBinding

    private val binding
        get() = _binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTimeSelectBinding.inflate(inflater, container, false)
        return binding.root
    }
}