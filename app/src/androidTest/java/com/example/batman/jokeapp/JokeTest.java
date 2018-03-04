package com.example.batman.jokeapp;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.batman.jokeapp.CloudAsyncTask.EndPointAsyncTask;
import com.example.batman.jokeapp.CloudAsyncTask.OnJokeReceiver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class JokeTest extends ApplicationTestCase<Application> implements OnJokeReceiver {
    CountDownLatch signal;
    String mJoke;
    public JokeTest(){
        super(Application.class);
    }
    public void testJoke(){
        try{
            signal = new CountDownLatch(1);
            new EndPointAsyncTask(this).execute();
            signal.await(10, TimeUnit.SECONDS);
            assertNotNull("NULL", mJoke);
            assertFalse("Joke is Empty", mJoke.isEmpty());

        }catch(Exception e){
            fail();
        }
    }


    @Override
    public void Joke(String joke) {
        mJoke = joke;
        signal.countDown();

    }
}
