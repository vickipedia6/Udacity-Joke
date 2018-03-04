package com.example.batman.jokeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.batman.jokeapp.CloudAsyncTask.EndPointAsyncTask;
import com.example.batman.jokeapp.CloudAsyncTask.OnJokeReceiver;
import com.example.jokeandroidlibrary.JokeDisplayActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements OnJokeReceiver{
Button jokebButton;
    String mJoke;
ProgressBar mProgress;
    AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    jokebButton=(Button)findViewById(R.id.tell);
        mProgress=(ProgressBar)findViewById(R.id.progressBar3);
        adView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);
        jokebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });


    }
    public void show()
    {
        mProgress.setVisibility(View.VISIBLE);
        new EndPointAsyncTask(this).execute();

    }


    @Override
    public void Joke(String joke) {
        mProgress.setVisibility(View.GONE);
        Intent jokeintent=new Intent(getApplicationContext(), JokeDisplayActivity.class);
        jokeintent.putExtra(JokeDisplayActivity.joke,joke);
        startActivity(jokeintent);

    }
}
