package com.yakogdan.multimoduledagger

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.yakogdan.core.api.kinopoisk.KinopoiskApiFactory
import com.yakogdan.core.api.kinopoisk.KinopoiskApiService
import com.yakogdan.core.api.openweathermap.OpenWeatherMapApiFactory
import com.yakogdan.core.api.openweathermap.OpenWeatherMapApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val kinopoiskApiService: KinopoiskApiService =
        KinopoiskApiFactory.kinopoiskApiService

    val openWeatherMapApiService: OpenWeatherMapApiService =
        OpenWeatherMapApiFactory.openWeatherMapApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch(Dispatchers.IO) {
            val filmId = 258687
            val film = kinopoiskApiService.getFilmById(id = filmId)

            withContext(Dispatchers.Main) {
                findViewById<TextView>(R.id.tvFilm).text =
                    film.nameRu ?: film.nameOriginal ?: "Empty"
            }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            val city = "Иркутск"
            val weather = openWeatherMapApiService.getWeather(city)

            val weatherText = "${weather.name} ${weather.main.temp?.toInt()}°C ${weather.weather?.first()?.description}"

            withContext(Dispatchers.Main) {
                findViewById<TextView>(R.id.tvWeather).text = weatherText
            }
        }
    }
}