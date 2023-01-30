package com.example.myseekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.myseekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupSeekBarSky()
        setupSeekBarRain()
        setupSeekBarTemp()
    }

    private fun setupSeekBarSky() {
        binding.apply {

            skyLevel.text = "Despejado"
            skyLevel.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_sun, 0,0,0)

            seekBarSky.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    selectedSky(progress)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    seekBar?.apply {
                        selectedSky(progress)
                    }
                }

            })
        }
    }

    private fun ActivityMainBinding.selectedSky(progress: Int) {
        when (progress) {
            0 -> {
                skyLevel.text = "Despejado"
                skyLevel.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_sun, 0, 0, 0)
            }
            1 -> {
                skyLevel.text = "Nuves y claros"
                skyLevel.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    R.drawable.ic_clouds_and_clear,
                    0,
                    0,
                    0
                )
            }
            2 -> {
                skyLevel.text = "Nublado"
                skyLevel.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    R.drawable.ic_cloudy,
                    0,
                    0,
                    0
                )
            }
        }
    }

    private fun ActivityMainBinding.selectedRain(progress: Int) {
        when (progress) {
            0 -> {
                rainLavel.text = "LLuvia débil"
                rainLavel.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_rain_01, 0, 0, 0)
            }
            1 -> {
                rainLavel.text = "LLuvia moderada"
                rainLavel.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_rain_02, 0, 0, 0)
            }
            2 -> {
                rainLavel.text = "LLuvia fuerte"
                rainLavel.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_rain_03, 0, 0, 0)
            }
            3 -> {
                rainLavel.text = "Granizo"
                rainLavel.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_hail, 0, 0, 0)
            }
            4 -> {
                rainLavel.text = "Nieve"
                rainLavel.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_snow, 0, 0, 0)
            }
            5 -> {
                rainLavel.text = "Ventisca"
                rainLavel.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_bizzard, 0, 0, 0)
            }
        }
    }

    private fun setupSeekBarRain() {
        binding.apply {

            rainLavel.text = "LLuvia débil"
            rainLavel.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_rain_01, 0, 0, 0)

            seekBarRain.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    selectedRain(progress)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    seekBar?.apply {
                        selectedRain(progress)
                    }

                }

            })

        }
    }

    private fun setupSeekBarTemp() {
        binding.apply {

            tempLavel.text = "< 0ºC (Frio intenso)"

            seekBarTemperature.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    tempLavel.text = when (progress) {
                        0 -> "< 0ºC (Frío intenso)"
                        1 -> "> 0-10ºC (Frío)"
                        2 -> ">10-25ºC (Normal)"
                        3 -> ">25ªC (calor)"
                        else ->"Desconocido"

                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                   seekBar?.apply {
                       tempLavel.text = when (progress) {
                           0 -> "< 0ºC (Frío intenso)"
                           1 -> "> 0-10ºC (Frío)"
                           2 -> ">10-25ºC (Normal)"
                           3 -> ">25ªC (calor)"
                           else ->"Desconocido"
                       }
                   }
                }

            })

        }

    }
}

enum class Sky {
    DESPEJADO,
    NUBES_Y_CLAROS,
    NUBLADO

}