package com.example.thepiggame.gameFun;

public class Dice {
    public static int throwDices(){
        return (int) (Math.random() *6) + 1;
    }
}
