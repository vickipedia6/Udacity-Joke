package com.example.batman.jokeapp;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.batman.jokeapp.CloudAsyncTask.EndPointAsyncTask;
import com.example.batman.jokeapp.CloudAsyncTask.OnJokeReceiver;
import com.example.jokeandroidlibrary.JokeDisplayActivity;


public class MainActivity extends AppCompatActivity implements OnJokeReceiver {
Button b;
    ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    b=(Button)findViewById(R.id.button2);
        mProgress=(ProgressBar)findViewById(R.id.progressBar2);

        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
               mProgress.setVisibility(View.VISIBLE);
                mProgress.setProgress(70,true);
                new EndPointAsyncTask(MainActivity.this).execute();
            }
        });
    }

    @Override
    public void Joke(String joke) {
        mProgress.setVisibility(View.INVISIBLE);
        Intent jokeintent=new Intent(getApplicationContext(), JokeDisplayActivity.class);
        jokeintent.putExtra(JokeDisplayActivity.joke,joke);
        startActivity(jokeintent);
    }
}
