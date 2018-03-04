package com.example.jokeandroidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {
TextView jokeDisplay;
public static String joke="c";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
    String text=getIntent().getStringExtra(joke);
        jokeDisplay=(TextView)findViewById(R.id.jokeDisplay);
        jokeDisplay.setText(text);
    }
}
