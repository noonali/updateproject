package com.example.q.myapplication

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

/**
 * Created by Q on 13/02/18.
 */
// class  database and send data to php file
class send: StringRequest {
    //Url is static
    companion object {
        private val Url = "http://localhost/Lab/application1.php" }

    //store data in list
    private var list: MutableMap<String, String> = HashMap()

    constructor(ID: String, password: String, listener: Response.Listener<String>)
            : super(Request.Method.POST, Url, listener, null){

        list.put("id",ID)
        list.put("pass",password) }
    //send to php file
    override fun getParams(): MutableMap<String,String>{
        return list
    }

}