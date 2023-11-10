package com.example.cronometro


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.cronometro.databinding.ActivityTemporizadorBinding


class Temporizador : AppCompatActivity() {
    lateinit var binding: ActivityTemporizadorBinding
    lateinit var time: CountDownTimer
    var tiempo: Long= 1000 * 62
    var hora: Long = 0
    var minuto :Long= 0
    var segundo:Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemporizadorBinding.inflate(layoutInflater)
        setContentView(binding.root)



        time = object : CountDownTimer(tiempo,1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.txtTemporizador.text = "${hora}:${minuto}:${segundo--}"

0
                        if (segundo <1.toLong() && minuto > 0 ){
                            minuto--
                            segundo = 59
                        }
                        if (minuto == 0.toLong() && hora >0){
                            hora--
                            minuto = 59
                        }
                        if (hora==0.toLong() && minuto ==0.toLong() && segundo <0.toLong()){
                            this.cancel()
                        }



            }

            override fun onFinish() {

            }
        }

        binding.btnstartPause.setOnClickListener {
            hora = binding.edthora.text.toString().toLong()
            minuto = binding.edtminutos.text.toString().toLong()
            segundo = binding.edtsegundos.text.toString().toLong()
            time.start()


            }

        binding.btnreset.setOnClickListener {
            time.cancel()
            binding.edthora.setText("0")
            binding.edtminutos.setText("0")
            binding.edtsegundos.setText("0")
        }

        binding.btncronometro.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }



}
