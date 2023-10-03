package com.example.thepiggame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.thepiggame.gameFun.RollDices;

public class MainActivity extends AppCompatActivity {

    //Game
    private final RollDices game = new RollDices();

    private Button hold;

    //TextViews
    private TextView winnerTextView1, winnerTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //TextViews
        winnerTextView1 = findViewById(R.id.winner1);
        winnerTextView2 = findViewById(R.id.winner2);

        //Set the text views invisible.
        winnerTextView1.setVisibility(View.INVISIBLE);
        winnerTextView2.setVisibility(View.INVISIBLE);


        //Buttons
        Button restartGame = findViewById(R.id.newGameButton);
        //Buttons
        Button rollDice = findViewById(R.id.rollDiceButton);
        hold = findViewById(R.id.holdButton);

        //Set the roll dice button.
        setRollDice(rollDice);

        //Set the restart button.
        setRestartGame(restartGame);

        //Set the hold button.
        setHoldGame();


    }

    /**
     * This method is used to set the hold button.
     */
    private void setHoldGame() {
        hold.setOnClickListener(view -> {

            //If the player is not hold, the player 1 is playing, else the player 2 is playing.
            if (game.invertedHold()) {

                //Update the current value of the player 1.
                game.sumDice("player1", RollDices.getRoundScore());
                RollDices.setRoundScore(0);

                //Update the current value of the player 1.
                TextView player1View = findViewById(R.id.player1Contador);
                player1View.setText(String.valueOf(game.getPuntuacion("player1")));


            } else {
                //Update the current value of the player 2.
                game.sumDice("player2", RollDices.getRoundScore());
                RollDices.setRoundScore(0);

                //Update the current value of the player 2.
                TextView player2View = findViewById(R.id.player2Contador);
                player2View.setText(String.valueOf(game.getPuntuacion("player2")));
            }

            //Check if the player has won.
            checkWinner();


            //Change the player.
            game.setHold(game.invertedHold());


            //Update the current value of the player 2.
            TextView currentValuePlayer1 = findViewById(R.id.currentValuePlayer1);
            currentValuePlayer1.setText(getResources().getString(R.string.numberZero));

            //Update the current value of the player 2.
            TextView currentValuePlayer2 = findViewById(R.id.currentValuePlayer2);
            currentValuePlayer2.setText(getResources().getString(R.string.numberZero));
        });
    }

    /**
     * This method is used to set the restart button.
     *
     * @param restartGame is the restart button.
     */
    private void setRestartGame(Button restartGame) {
        restartGame.setOnClickListener(view -> {
            game.deletePoints();

            //Update the current value of the player 2.
            TextView player2View = findViewById(R.id.player2Contador);
            player2View.setText(getResources().getString(R.string.numberZero));

            //Update the current value of the player 1.
            TextView currentValuePlayer2 = findViewById(R.id.currentValuePlayer2);
            currentValuePlayer2.setText(getResources().getString(R.string.numberZero));

            //Update the current value of the player 1.
            TextView player1View = findViewById(R.id.player1Contador);
            player1View.setText(getResources().getString(R.string.numberZero));

            //Update the current value of the player 1.
            TextView currentValuePlayer1 = findViewById(R.id.currentValuePlayer1);
            currentValuePlayer1.setText(getResources().getString(R.string.numberZero));


            //Set the text views invisible.
            winnerTextView1.setVisibility(View.INVISIBLE);
            winnerTextView2.setVisibility(View.INVISIBLE);
        });
    }

    /**
     * This method is used to set the roll dice button.
     *
     * @param rollDice is the roll dice button.
     */
    private void setRollDice(Button rollDice) {
        rollDice.setOnClickListener(view -> {

            //If the player is not hold, the player 1 is playing, else the player 2 is playing.
            if (game.invertedHold()) {
                game.play();

                //Update the current value of the player 1.
                TextView player1View = findViewById(R.id.currentValuePlayer1);
                player1View.setText(String.valueOf(RollDices.getRoundScore()));
            } else {
                game.play();

                //Update the current value of the player 2.
                TextView player2View = findViewById(R.id.currentValuePlayer2);
                player2View.setText(String.valueOf(RollDices.getRoundScore()));
            }

            //Check if the player has won.
            checkWinner();
        });
    }

    private void checkWinner() {
        //Check if the player has won.
        String winner = game.winner();
        if (!winner.equalsIgnoreCase("")) {
            updateWinner(winner);
        }
    }

    private void updateWinner(String winner) {

        if (winner.equalsIgnoreCase("player1")) {
            winnerTextView1.setVisibility(View.VISIBLE);
        } else {
            winnerTextView2.setVisibility(View.VISIBLE);
        }
    }
}