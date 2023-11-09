package com.example.cronometro

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var timer: CountDownTimer
    lateinit var  mp:MediaPlayer
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count =1
        var second:Long = 1000 * 61
        var minute =0
        var hora = 0
        mp = MediaPlayer.create(this,R.raw.sonido)


        timer = object : CountDownTimer(second,1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.imageView.setImageDrawable(getDrawable(R.drawable.minutes))
                binding.txttime.setTextColor(getColor(R.color.orange))


                if (count == 60){
                    minute ++
                    count = 0
                    if (minute ==60){
                        hora ++
                        minute = 0
                    }
                }
                binding.txttime.text ="${hora}:${minute}:${count++}"
            }
            override fun onFinish() {
                this.start()
            }
        }
        binding.btnstart.setOnClickListener {

            mp.start()
            timer.start()



        }

        binding.btnterminar.setOnClickListener {

            binding.imageView.setImageDrawable(getDrawable(R.drawable.minute))
            timer.cancel()
            mp.pause()
            count = 0
            minute = 0
            binding.txttime.text ="00:0${minute}:${count++}"
        }

        binding.btntemporizador.setOnClickListener {
            startActivity(Intent(this,Temporizador::class.java))
        }

    }
}