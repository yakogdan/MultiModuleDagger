package com.yakogdan.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.yakogdan.home.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        binding.tvHome.text = "FragmentHomeBinding"
    }
}