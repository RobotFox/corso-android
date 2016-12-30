package com.its.provapost;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    EditText mEdtName, mEdtSurname, mEdtId;
    TextView mtxtStatus;
    MainActivity activity;

    String mName, mSurname, mId, risposta;

    Button mButton;
    MyAsyncTask myAsyncTask;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtId = (EditText) findViewById(R.id.editTextId);
        mEdtName = (EditText) findViewById(R.id.editTextName);
        mEdtSurname = (EditText) findViewById(R.id.editTextSurname);

        mButton = (Button) findViewById(R.id.buttonRequest);
        mtxtStatus = (TextView) findViewById(R.id.textViewStatus);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mName = mEdtName.getText().toString();
                mId = mEdtId.getText().toString();
                mSurname = mEdtSurname.getText().toString();
                myAsyncTask = new MyAsyncTask();
                myAsyncTask.setmListener(MainActivity.this);
                myAsyncTask.execute();
            }
        });
    }

    class MyAsyncTask extends AsyncTask{
        public void setmListener(MainActivity mListener){
            this.mListener = new WeakReference<MainActivity>(mListener);
        }
        WeakReference<MainActivity> mListener;

        @Override
        protected Object doInBackground(Object[] params) {
            OkHttpClient client = new OkHttpClient();

            RequestBody formBody1 = new FormBody.Builder()
                    .add("id",mId)
                    .add("name",mName)
                    .add("surname",mSurname)
                    .build();
            Request request1 = new Request.Builder()
                    .url("http://tommo.altervista.org/ITS/post.php")
                    .post(formBody1)
                    .build();

            try {
                Response response1 = client.newCall(request1).execute();
                risposta = response1.body().string();
                JSONArray jsonArray = new JSONArray(risposta);
                for (int i=0; i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    jsonObject.getBoolean("success");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mListener.get().makeToast(risposta);
            return null;
        }
    }



    public void makeToast(final String x){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONObject jsonObject = new JSONObject(x);
                    int status = jsonObject.getInt("status");
                    if (status==0){
                        Toast.makeText(MainActivity.this,"Status: 0 "+x, Toast.LENGTH_SHORT).show();
                        mtxtStatus.setBackgroundColor(Color.parseColor("#FF0000"));
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Status: 1 "+x, Toast.LENGTH_SHORT).show();
                        mtxtStatus.setBackgroundColor(Color.parseColor("#22F52B"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
