package com.example.q.myapplication


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    // class three buttom
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Move between pages
        but_admin.setOnClickListener{

            var admin= Intent(this,adminActivity::class.java)
            startActivity(admin)
        }
        but_new.setOnClickListener{

            var newTeacher= Intent(this,newActivity::class.java)
            startActivity(newTeacher)
        }
        but_current.setOnClickListener{

            var current= Intent(this,currentActivity::class.java)
            startActivity(current)
        }
        // end Move between pages
    }
}
