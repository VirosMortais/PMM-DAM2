package com.example.thepiggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thepiggame.gameFun.RollDices;

public class MainActivity extends AppCompatActivity {
    private  int roll = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String player1 = "player1", player2 = "player2";



        Button restartGame = findViewById(R.id.newGameButton);
        Button rollDice = findViewById(R.id.rollDiceButton);
        Button hold = findViewById(R.id.holdButton);

        RollDices game = new RollDices();
        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!game.isHold()){
                    game.play();


                    TextView player1View = findViewById(R.id.currentValuePlayer1);
                    player1View.setText(String.valueOf(game.getRoundScore()));
                }else{
                   game.play();

                    TextView player2View = findViewById(R.id.currentValuePlayer2);
                    player2View.setText(String.valueOf(game.getRoundScore()));
                }
            }
        });

        restartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.deletePoints();

                TextView player2View = findViewById(R.id.player2Contador);
                player2View.setText(getResources().getString(R.string.numberZero));

                TextView currentValuePlayer2 = findViewById(R.id.currentValuePlayer2);
                currentValuePlayer2.setText(getResources().getString(R.string.currentValue));

                TextView player1View = findViewById(R.id.player1Contador);
                player1View.setText(getResources().getString(R.string.numberZero));

                TextView currentValuePlayer1 = findViewById(R.id.currentValuePlayer1);
                currentValuePlayer1.setText(getResources().getString(R.string.currentValue));
            }
        });

        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!game.isHold()){
                    game.sumDice(player1, game.getRoundScore());
                    roll = 0;
                    game.setRoundScore(0);

                    TextView player1View = findViewById(R.id.player1Contador);
                    player1View.setText(String.valueOf(game.getPuntuacion(player1)));


                }else{
                    game.sumDice(player2, game.getRoundScore());
                    roll = 0;
                    game.setRoundScore(0);
                    TextView player2View = findViewById(R.id.player2Contador);
                    player2View.setText(String.valueOf(game.getPuntuacion(player2)));


                }

                game.setHold(!game.isHold());



                TextView currentValuePlayer1 = findViewById(R.id.currentValuePlayer1);
                currentValuePlayer1.setText(getResources().getString(R.string.currentValue));

                TextView currentValuePlayer2 = findViewById(R.id.currentValuePlayer2);
                currentValuePlayer2.setText(getResources().getString(R.string.currentValue));
            }
        });
    }
}