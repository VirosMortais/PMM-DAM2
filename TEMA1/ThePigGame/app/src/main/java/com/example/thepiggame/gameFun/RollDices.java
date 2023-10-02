package com.example.thepiggame.gameFun;

public class RollDices {

    private Player player1;
    private Player player2;

    public RollDices(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(){
        int tiro1 = Dice.throwDices();
        int tiro2 = Dice.throwDices();

        player1.sumDice(tiro1);
        player2.sumDice(tiro2);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
