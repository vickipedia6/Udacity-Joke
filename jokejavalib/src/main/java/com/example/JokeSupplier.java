package com.example;

import java.util.Random;

public class JokeSupplier {

    public JokeSupplier() {

    }

    public static String JokeShow()
{
    String jokes[]={
            "A lot of people cry when they cut onions. The trick is not to form an emotional bond\n",
            "What do you call a fish without eyes? Fsh\n",
            "Why shouldn't you write with a broken pencil? Because it's pointless"};



    Random random=new Random();
    return jokes[random.nextInt(jokes.length)];
}



}
