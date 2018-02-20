package com.example.q.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_admin.*
import org.json.JSONException
import org.json.JSONObject


class adminActivity : AppCompatActivity() {

    //var g:RequestQueue?=null
    //val url="http://192.168.1.61/Lab/application1.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
    }
    fun login_admin(view: View)
    {
        var id_i=admin_id.text.toString()
        var pass_i=admin_password.text.toString()
        // The result is received from a file php
         val lis= Response.Listener<String> {  response ->
             try{
                   val j= JSONObject(response)
                    //check up  the  result correct or no
                    val succ:Boolean=j.getBoolean("success")
                 if(succ){
                     Toast.makeText(this, "successfully login", Toast.LENGTH_LONG).show()
                     var admin= Intent(this,MainActivity::class.java)
                     startActivity(admin)
                 }else{
                    Toast.makeText(this, "ID or Password is Wrong", Toast.LENGTH_LONG).show()
                      }
             }catch (e: JSONException) {
            Toast.makeText(this, "Catch", Toast.LENGTH_LONG).show()
             }
         }
        // move to constructor
        val Send:send=send(id_i,pass_i,lis)
        val request:RequestQueue=Volley.newRequestQueue(this)
        request.add(Send)
    }

 

    }



