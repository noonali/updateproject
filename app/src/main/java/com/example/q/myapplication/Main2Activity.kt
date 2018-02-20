package com.example.q.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import java.util.*


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
         val time= object : CountDownTimer(5000,1000) {
             override fun onFinish(){
                 val NEWT = Intent (this@Main2Activity, MainActivity::class.java)
                 startActivity(NEWT)
             }
             override fun onTick(p0: Long) {

             }



         }
        time.start()
    }
}
