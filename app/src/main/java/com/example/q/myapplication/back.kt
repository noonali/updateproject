package com.example.q.myapplication

import android.app.AlertDialog
import android.content.Context
import android.os.AsyncTask

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
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
// class database  login , sigin in and newteacher
class back internal constructor(internal var ctx: Context) : AsyncTask<String, Void, String>() {
    internal lateinit var alertDialog: AlertDialog
    internal lateinit var alertDialog1: AlertDialog

    override fun onPreExecute() {
        alertDialog=AlertDialog.Builder(ctx).create()

        alertDialog.setTitle("successfully login")
        alertDialog1=AlertDialog.Builder(ctx).create()
        alertDialog1.setTitle("successfully Sigin in")
    }

    override fun doInBackground(vararg params: String): String? {
        val url_login="http://10.0.2.2/Lab/application1.php"
        val url_current="http://10.0.2.2/Lab/application1.php"
        val url_new="http://10.0.2.2/Lab/application1.php"


        val method=params[0]
        if (method == "register") {
            val id_i=params[1]
            val email=params[2]
            try {
                val url=URL(url_new)
                val httpURLConnection=url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod="POST"
                httpURLConnection.doInput=true
                val os=httpURLConnection.outputStream
                val bufferedWriter=BufferedWriter(OutputStreamWriter(os, "UTF-8"))
                val data=URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id_i, "UTF-8") + "&" +
                        URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8")
                bufferedWriter.write(data)
                bufferedWriter.flush()
                bufferedWriter.close()
                os.close()
                val IS=httpURLConnection.inputStream
                IS.close()
                return "register success...."
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: ProtocolException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }


        } else if (method == "login") {
            val id_i=params[1]
            val password=params[2]
            try {
                val url=URL(url_login)
                val httpURLConnection=url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod="POST"
                httpURLConnection.doInput=true
                val os=httpURLConnection.outputStream
                val bufferedWriter=BufferedWriter(OutputStreamWriter(os, "UTF-8"))
                val data=URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id_i, "UTF-8") + "&" +
                        URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")
                bufferedWriter.write(data)
                bufferedWriter.flush()
                bufferedWriter.close()
                val inputStream=httpURLConnection.inputStream
                val bufferedReader=BufferedReader(InputStreamReader(inputStream, "iso-8859-1"))
                var respons=""
                var line=""
                while ((line = bufferedReader.readLine())!= null) {
                    respons+=line
                }
                bufferedReader.close()
                inputStream.close()
                httpURLConnection.disconnect()
                return respons

            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        } else if (method == "sigin in ") {
            val id_i=params[1]
            val code=params[2]
            try {
                val url=URL(url_current)
                val httpURLConnection=url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod="POST"
                httpURLConnection.doInput=true
                val os=httpURLConnection.outputStream
                val bufferedWriter=BufferedWriter(OutputStreamWriter(os, "UTF-8"))
                val data=URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id_i, "UTF-8") + "&" +
                        URLEncoder.encode("code", "UTF-8") + "=" + URLEncoder.encode(code, "UTF-8")
                bufferedWriter.write(data)
                bufferedWriter.flush()
                bufferedWriter.close()
                val inputStream=httpURLConnection.inputStream
                val bufferedReader=BufferedReader(InputStreamReader(inputStream, "iso-8859-1"))
                var respons=""
                var line=""
                while ((line=bufferedReader.readLine()) != null) {
                    respons+=line
                }
                bufferedReader.close()
                inputStream.close()
                httpURLConnection.disconnect()
                return respons

            } catch (e: MalformedURLException) {
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
        if (result == "register success....") {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show()
        } else if (result == "successfully login") {
            alertDialog.setMessage(result)
            alertDialog.show()
        } else {
            alertDialog1.setMessage(result)
            alertDialog1.show()
        }

    }


}




