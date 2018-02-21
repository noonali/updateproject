package com.example.q.myapplication

import android.content.Context
import android.os.AsyncTask

import java.io.BufferedWriter
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.ProtocolException
import java.net.URL
import java.net.URLEncoder
import android.widget.Toast


/**
 * Created by Q on 21/02/18.
 */
// class database
class json internal constructor(internal var ctx: Context) : AsyncTask<String, Void, String>() {
    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: String): String? {
        val url_lo = "http://localhost/Lab/application1.php" // file php login
        val url2 = "http://localhost/Lab/application1.php"   //file php sigin in
        val url3= "http://localhost/Lab/application3.php"    //file php send code

        val method = params[0]
        if (method == "register") {
            val id_i = params[1]
            val pass_i = params[2]
            try {
                val url = URL(url_lo)
                val httpURLConnection = url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod = "POST"
                httpURLConnection.doInput = true
                val os = httpURLConnection.outputStream
                val bufferedWriter = BufferedWriter(OutputStreamWriter(os, "UTF-8"))
                val data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id_i, "UTF-8") + "&" +
                        URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass_i, "UTF-8")
                bufferedWriter.write(data)
                bufferedWriter.flush()
                bufferedWriter.close()
                os.close()
                val IS = httpURLConnection.inputStream
                IS.close()
                return "register success...."
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: ProtocolException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }


        }
        return null
    }

    override fun onProgressUpdate(vararg values: Void) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: String) {
        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show()
    }
}
