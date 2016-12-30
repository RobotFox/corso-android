package com.its.pretto.samuele.facebookexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.ShareApi;
import com.facebook.share.Sharer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    LoginButton mButton;
    CallbackManager mCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        mCallbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);
        mButton = (LoginButton) findViewById(R.id.loginButton);
       // mButton.setReadPermissions("email");
        mButton.setPublishPermissions("publish_actions");
        mButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(
                        AccessToken.getCurrentAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback(){

                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        Log.d("aaa",object.toString());
                                    }
                                });
                        Bundle parameters =  new Bundle();
                parameters.putString("fields","id,name,link");
                request.setParameters(parameters);
                request.executeAsync();

                Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.download);

                SharePhoto photo = new SharePhoto.Builder()
                        .setBitmap(bitmap)
                        .build();
                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto(photo)
                        .build();

                ShareApi.share(content, new FacebookCallback<Sharer.Result>() {
                    @Override
                    public void onSuccess(Sharer.Result result) {
                        Log.d("aaa",result.getPostId());
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });
            }

            @Override
            public void onCancel() {
                    Log.d("aaa", "Login Facebook cancellato");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("aaa", "Login Facebook ERRORE!");
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
