package com.example.cronometro

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count =1
        var second:Long = 1000 * 60
        timer = object : CountDownTimer(second,1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.txttime.text ="00:00:"+count++.toString()

            }

            override fun onFinish() {

            }
        }
        var iniciar = false
        binding.btnstart.setOnClickListener {
          if (!iniciar){
              timer.start()
              iniciar = true
              binding.btnstart.text = "Detener"
          }else{
              timer.onFinish()
              iniciar = false

          }
        }



    }
}