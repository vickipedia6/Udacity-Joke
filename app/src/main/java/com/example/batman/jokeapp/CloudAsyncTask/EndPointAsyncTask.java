package com.example.batman.jokeapp.CloudAsyncTask;

import android.os.AsyncTask;


import com.example.batman.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;


/**
 * Created by Batman on 1/17/2018.
 */

public class EndPointAsyncTask extends AsyncTask<OnJokeReceiver,Void,String> {
    MyApi myApi=null;
    OnJokeReceiver onJokeReceiver;

    public EndPointAsyncTask(OnJokeReceiver onJokeReceiver) {
        this.onJokeReceiver = onJokeReceiver;
    }

    @Override
    protected String doInBackground(OnJokeReceiver... params) {
        if(myApi==null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://joketelling-192018.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApi = builder.build();
        }

        try {
            return myApi.sayHi("Joke").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }

    }
    @Override
    protected void onPostExecute(String s) {


        onJokeReceiver.Joke(s);
    }

}
