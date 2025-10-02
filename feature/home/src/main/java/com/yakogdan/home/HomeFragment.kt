package com.yakogdan.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.yakogdan.core.di.dependencies.CoreDependenciesProvider
import com.yakogdan.home.databinding.FragmentHomeBinding
import com.yakogdan.home.di.DaggerHomeComponent
import com.yakogdan.home.state.FilmScreenState
import com.yakogdan.home.state.WeatherScreenState
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        val coreDependencies =
            (requireActivity().application as CoreDependenciesProvider).getCoreDependencies()

        DaggerHomeComponent.factory()
            .create(coreDependencies)
            .inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        viewModel.loadFilm(filmId = 258687)
        viewModel.loadWeather(city = "Иркутск")

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { processFilmScreenState() }
                launch { processWeatherScreenState() }
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

    private suspend fun processWeatherScreenState(): Nothing {
        viewModel.weatherScreenState.collect { screenState ->

            when (screenState) {

                WeatherScreenState.Loading -> {
                    binding.tvWeather.text = "Loading..."
                }

                is WeatherScreenState.Content -> {
                    screenState.weather.apply {
                        val weatherText = "$city $temp°C $description"
                        binding.tvWeather.text = weatherText
                    }
                }

                is WeatherScreenState.Error -> {
                    binding.tvWeather.text = screenState.throwable.message
                }

                WeatherScreenState.Initial -> {}
            }
        }
    }
}