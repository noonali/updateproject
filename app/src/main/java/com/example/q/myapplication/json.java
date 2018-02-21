package com.example.q.myapplication;

import android.content.Context;
import android.os.AsyncTask;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Q on 21/02/18.
 */

public class json extends AsyncTask<String,Void,Void> {
    Context ctx;
    json (Context ctx){
        this.ctx=ctx;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... params) {
        String url_lo="http://localhost/Lab/application1.php";
        String url1="http://localhost/Lab/application1.php";

        String method= params[0];
        if (method.equals("register")){
            String id_i=params[1];
            String pass_i=params[2];
            try {
                URL url =new URL(url_lo);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
