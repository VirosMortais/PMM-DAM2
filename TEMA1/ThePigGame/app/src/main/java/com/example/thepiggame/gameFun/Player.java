package com.example.thepiggame.gameFun;

public class Player {
    private String player;
    private int puntuacion;

    public Player(String player){
        this.player = player;
        this.puntuacion = 0;
    }

    public void sumDice(int roll){
        this.puntuacion += roll;
    }

    public int getPuntuacion(){
        return puntuacion;
    }

    public void deletePoints(){
        this.puntuacion = 0;
    }

}
