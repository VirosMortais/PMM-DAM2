package com.example.thepiggame.gameFun;

import java.util.HashMap;

public class RollDices {
    public HashMap<String, Integer> getPlayers() {
        return players;
    }

    private HashMap<String,Integer> players = new HashMap<>();
    private boolean hold = false;

    private static int roundScore = 0;

    public RollDices(){
            players.put("player1", 0);
            players.put("player2", 0);
    }
    public void play(){
        int n = 0;
        if(!((n = Dice.throwDices())==1)){
            roundScore += n;
        }else{
            this.setHold(!this.isHold());
            roundScore=0;
        }

    }


    public void sumDice(String player, int roll){
        Integer currentScore = players.get(player);
        if (currentScore == null) {
            players.put(player, roll);
        } else {
            players.put(player, currentScore + roll);
        }
    }

    public void deletePoints(){
       this.players.replace("player1", 0);
        this.players.replace("player2", 0);
    }

    public void setHold(Boolean hold){
        this.hold = hold;
    }

    public boolean isHold(){
        return this.hold;
    }

    public static void setRoundScore(int roundScore) {
        RollDices.roundScore = roundScore;
    }

    public static int getRoundScore() {
        return roundScore;
    }

    public int getPuntuacion(String player){
        Integer score = players.get(player);
        if (score == null) {
            return 0;
        } else {
            return score;
        }
    }
}
