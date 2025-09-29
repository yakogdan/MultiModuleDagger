package com.yakogdan.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.yakogdan.home.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        viewModel.loadFilm(filmId = 258687)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    processFilmScreenState()
                }
            }
        }

    }

    private suspend fun processFilmScreenState(): Nothing {
        viewModel.filmScreenState.collect { screenState ->

            when (screenState) {

                FilmScreenState.Loading -> {
                    binding.tvFilm.text = "Loading..."
                }

                is FilmScreenState.Content -> {
                    binding.tvFilm.text = screenState.film.name
                }

                is FilmScreenState.Error -> {
                    binding.tvFilm.text = screenState.throwable.message
                }

                FilmScreenState.Initial -> {}
            }
        }
    }
}