package com.example.thepiggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thepiggame.gameFun.RollDices;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Players
        final String player1 = "player1", player2 = "player2";


        //Buttons
        Button restartGame = findViewById(R.id.newGameButton);
        Button rollDice = findViewById(R.id.rollDiceButton);
        Button hold = findViewById(R.id.holdButton);

        //Game
        RollDices game = new RollDices();

        rollDice.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is called when the roll dice button is clicked.
             * @param view
             */
            @Override
            public void onClick(View view) {

                //If the player is not hold, the player 1 is playing, else the player 2 is playing.
                if(game.invertedHold()){
                    game.play();

                    //Update the current value of the player 1.
                    TextView player1View = findViewById(R.id.currentValuePlayer1);
                    player1View.setText(String.valueOf(RollDices.getRoundScore()));
                }else{
                   game.play();

                   //Update the current value of the player 2.
                    TextView player2View = findViewById(R.id.currentValuePlayer2);
                    player2View.setText(String.valueOf(RollDices.getRoundScore()));
                }
            }
        });

        restartGame.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is called when the restart button is clicked.
             * @param view
             */
            @Override
            public void onClick(View view) {
                game.deletePoints();

                //Update the current value of the player 2.
                TextView player2View = findViewById(R.id.player2Contador);
                player2View.setText(getResources().getString(R.string.numberZero));

                //Update the current value of the player 1.
                TextView currentValuePlayer2 = findViewById(R.id.currentValuePlayer2);
                currentValuePlayer2.setText(getResources().getString(R.string.currentValue));

                //Update the current value of the player 1.
                TextView player1View = findViewById(R.id.player1Contador);
                player1View.setText(getResources().getString(R.string.numberZero));

                //Update the current value of the player 1.
                TextView currentValuePlayer1 = findViewById(R.id.currentValuePlayer1);
                currentValuePlayer1.setText(getResources().getString(R.string.currentValue));
            }
        });

        hold.setOnClickListener(new View.OnClickListener() {
            /**
             * This method is called when the hold button is clicked.
             * @param view
             */
            @Override
            public void onClick(View view) {

                //If the player is not hold, the player 1 is playing, else the player 2 is playing.
                if(game.invertedHold()){

                    //Update the current value of the player 1.
                    game.sumDice(player1, RollDices.getRoundScore());
                    RollDices.setRoundScore(0);

                    //Update the current value of the player 1.
                    TextView player1View = findViewById(R.id.player1Contador);
                    player1View.setText(String.valueOf(game.getPuntuacion(player1)));


                }else{
                    //Update the current value of the player 2.
                    game.sumDice(player2, RollDices.getRoundScore());
                    RollDices.setRoundScore(0);

                    //Update the current value of the player 2.
                    TextView player2View = findViewById(R.id.player2Contador);
                    player2View.setText(String.valueOf(game.getPuntuacion(player2)));
                }

                //Change the player.
                game.setHold(game.invertedHold());


                //Update the current value of the player 2.
                TextView currentValuePlayer1 = findViewById(R.id.currentValuePlayer1);
                currentValuePlayer1.setText(getResources().getString(R.string.currentValue));

                //Update the current value of the player 2.
                TextView currentValuePlayer2 = findViewById(R.id.currentValuePlayer2);
                currentValuePlayer2.setText(getResources().getString(R.string.currentValue));
            }
        });
    }
}