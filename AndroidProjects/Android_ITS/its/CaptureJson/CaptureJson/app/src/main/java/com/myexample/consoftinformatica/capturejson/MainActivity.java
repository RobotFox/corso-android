package com.myexample.consoftinformatica.capturejson;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String URL_JSON = "http://jonlab.altervista.org/generated.json";

    TextView mTesto;
    Button mBt_Scarica, mBt_Separa;
    String full_json;
    int count = 0;
    ProgressDialog mProgressDialog;

    JSONArray mArrJson;
    JSONObject mObjJson;

    String nome, nomeAmico;
    int lat, lon;
    boolean active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTesto = (TextView) findViewById(R.id.textView);
        mBt_Scarica = (Button) findViewById(R.id.button_scarica);
        mBt_Separa = (Button) findViewById(R.id.button_separa);

        mBt_Scarica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkConnessione()) {
                    DownloadWebpageTask dJ = new DownloadWebpageTask();
                    dJ.setmListener(MainActivity.this);
                    dJ.execute(URL_JSON);
                }
            }
        });

        mBt_Separa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (full_json != null) {

                    try {
                        mArrJson = new JSONArray(full_json);
                        if (count < mArrJson.length()) {

                            mObjJson = mArrJson.getJSONObject(count);
                            nome = mObjJson.getString("name");
                            lat = mObjJson.getInt("latitude");
                            lon = mObjJson.getInt("longitude");
                            active = mObjJson.getBoolean("isActive");

                            mArrJson = mObjJson.getJSONArray("friends");
                            mObjJson = mArrJson.getJSONObject(0);             // in questo esempio prendo solo il primo amico
                            nomeAmico = mObjJson.getString("name");

                            String txtTextView = "Nome: " + nome + "\nLatitudine: " + lat + "\nlongitudine: " + lon + "\nE' attivo? " + active + "\nNome amico: " + nomeAmico;
                            mTesto.setText(txtTextView);

                            count++;
                        } else {
                            count = 0;

                            mObjJson = mArrJson.getJSONObject(count);
                            nome = mObjJson.getString("name");
                            lat = mObjJson.getInt("latitude");
                            lon = mObjJson.getInt("longitude");
                            active = mObjJson.getBoolean("isActive");

                            mArrJson = mObjJson.getJSONArray("friends");
                            mObjJson = mArrJson.getJSONObject(0);             // in questo esempio prendo solo il primo amico
                            nomeAmico = mObjJson.getString("name");

                            String txtTextView = "Nome: " + nome + "\nLatitudine: " + lat + "\nlongitudine: " + lon + "\nE' attivo? " + active + "\nNome amico: " + nomeAmico;
                            mTesto.setText(txtTextView);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Prima scarica il Json", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private boolean checkConnessione() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netw = connMgr.getActiveNetworkInfo();
        if (netw != null && netw.isConnected()) {
            return true;
        } else {
            Toast.makeText(MainActivity.this, "Errore di connessione ad internet", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {

        WeakReference<MainActivity> mListener;

        public void setmListener(MainActivity activity) {
            this.mListener = new WeakReference<>(activity);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setMessage("Caricamento");
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.show();
        }

        @Override
        protected String doInBackground(String... urls) {

            StringBuilder total = null;
            InputStream is;
            URL url;

            try {
                url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                // Starts the query
                conn.connect();
                int response = conn.getResponseCode();
                Log.d("The response is: ", response + "");
                // ricevo il Content della pagina web come stream
                is = conn.getInputStream();

                BufferedReader r = new BufferedReader(new InputStreamReader(is));
                total = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null) {
                    total.append(line);
                }
            } catch (IOException e) {
                Log.d("DownloadWebpageTask", "Problema di connessione: "+ e.getMessage());
                e.printStackTrace();
            }

            return total.toString();
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            mListener.get().mTesto.setText(result);
            mListener.get().full_json = result;
            mListener.get().count = 0;

            mProgressDialog.dismiss();

        }
    }

}
