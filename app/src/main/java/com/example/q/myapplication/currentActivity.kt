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
import kotlinx.android.synthetic.main.activity_current.*
import org.json.JSONException
import org.json.JSONObject

//class current Teacher sigin in
class currentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current)

    }

    fun sign_current(view: View)

    {
        var id_i=current_code.text.toString()
        var Code_i=current_id.text.toString()

        // from connection database in class json
        var mehode ="register"
        val Json:json=json(this)
        Json.execute(mehode,id_i,Code_i)
        finish()
        //end connection database in class json


         //The result is received from a file php
         val lis= Response.Listener<String> {  response ->
            try{
                 val j= JSONObject(response)
                 //check up  the  result correct or no
                 val succ:Boolean=j.getBoolean("success")
                 if(succ){
                    Toast.makeText(this, "successfully Sigin in ", Toast.LENGTH_LONG).show()
                    var Current= Intent(this,MainActivity::class.java)
                    startActivity(Current)
                } else{
                    Toast.makeText(this, "ID or Code is Wrong", Toast.LENGTH_LONG).show()
                }
            }catch (e: JSONException) {
                Toast.makeText(this, "Catch", Toast.LENGTH_LONG).show()
            }
        }
        // move to constructor
        val Send:send=send(id_i,Code_i.toString(),lis)
        val request: RequestQueue = Volley.newRequestQueue(this)
        request.add(Send)
    }

    // class database send data to php file Because check login
    class send: StringRequest {
        //Url is static
        companion object {
            private val Url = "http://localhost/Lab/application2.php" }

        //store data in list
        private var lis: MutableMap<String, String> = HashMap()

        constructor(ID: String, Code: String, listener: Response.Listener<String>)
                : super(Request.Method.POST, Url, listener, null){

            lis.put("id",ID)
            lis.put("code",Code) }
        //send to php file
        override fun getParams(): MutableMap<String,String>{
            return lis
        }

    }

         }


