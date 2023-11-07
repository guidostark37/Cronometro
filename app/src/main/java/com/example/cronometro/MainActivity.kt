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
        var second:Long = 1000 * 61
        var minute =0
        timer = object : CountDownTimer(second,1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.imageView.setImageDrawable(getDrawable(R.drawable.minutes))
                binding.txttime.setTextColor(getColor(R.color.orange))
                if (count == 60){
                    minute +=1
                    count = 0
                }
                binding.txttime.text ="00:0${minute}:${count++}"
            }
            override fun onFinish() {
                this.start()
            }
        }
        binding.btnstart.setOnClickListener {
              timer.start()
        }
        binding.btncancelar.setOnClickListener {
            timer.cancel()
        }
        binding.btnterminar.setOnClickListener {

            binding.imageView.setImageDrawable(getDrawable(R.drawable.minute))
            timer.cancel()
            count = 0
            minute = 0
            binding.txttime.text ="00:0${minute}:${count++}"
        }



    }
}