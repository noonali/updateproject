package com.example.q.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_new.*
import org.json.JSONException
import org.json.JSONObject
import java.util.*



class newActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

    }
        //sign_new.setOnClickListener {
           // var ID = new_id.text.toString()
            //var Email = new_email.text.toString()
            //val exp = Regex("\\W+([-_.]\\W+)*@\\W+([-.]\\W+)*\\.\\W+([-.]\\W+)*")
            //if (exp.matches(Email)) {
             //   var pass = genRandomNumber()
           // }else{
               // showtext.text = "Email is not correct"
            //}


    fun sign_new(view: View) {
        var id_i = new_id.text.toString()
        var Email = new_email.text.toString()

        val ex = Regex("\\W+([-_.]\\W+)*@\\W+([-.]\\W+)*\\.\\W+([-.]\\W+)*")


        if (ex.matches(Email)) {
            //The result is received from a file php
            val lis = Response.Listener<String> { response ->
                try {
                    val j = JSONObject(response)
                    //check up  the  result correct or no
                    val succ: Boolean = j.getBoolean("success")
                    if (succ) {
                        Toast.makeText(this, "successfully Registered", Toast.LENGTH_LONG).show()
                        var NEWT = Intent(this, MainActivity::class.java)
                        var pass = genRandomNumber()
                        startActivity(NEWT)
                    } else {
                        Toast.makeText(this, "The registration was not successful", Toast.LENGTH_LONG).show()
                    }
                } catch (e: JSONException) {
                    Toast.makeText(this, "Catch", Toast.LENGTH_LONG).show()
                }
            }
            // move to constructor
            val send: send = send(id_i, Email, lis)
            val request: RequestQueue = Volley.newRequestQueue(this)
            request.add(send)

        }  else {
            showtext.text = "Email is not correct"
        }

    }
    // class send data to php file Because check login
    class send: StringRequest {
        //Url is static
        companion object {
            private val Url = "http://localhost/Lab/application3.php" }

        //store data in list
        private var list: MutableMap<String, String> = HashMap()

        constructor(ID: String, email: String, listener: Response.Listener<String>)
                : super(Request.Method.POST, Url, listener, null){

            list.put("id",ID)
            list.put("Email",email) }
        //send to php file
        override fun getParams(): MutableMap<String,String>{
            return list
        }

    }

    fun genRandomNumber():Int
    {
        var ran="${Random().nextInt((8000-10)+10)}"
        var ran1:Int
        ran1=ran.toInt()
        return ran1

    }

    }

