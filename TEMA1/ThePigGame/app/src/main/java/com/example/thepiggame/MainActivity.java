package com.example.thepiggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thepiggame.gameFun.Player;
import com.example.thepiggame.gameFun.RollDices;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button restartGame = findViewById(R.id.newGameButton);
        Button rollDice = findViewById(R.id.rollDiceButton);
        RollDices game = new RollDices(new Player("Player1"), new Player("Player2"));
        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.play();

                TextView player2View = findViewById(R.id.player2Contador);
                player2View.setText(String.valueOf(game.getPlayer2().getPuntuacion()));

                TextView player1View = findViewById(R.id.player1Contador);
                player1View.setText(String.valueOf(game.getPlayer1().getPuntuacion()));
            }
        });

        restartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.getPlayer1().deletePoints();
                game.getPlayer2().deletePoints();


                TextView player2View = findViewById(R.id.player2Contador);
                player2View.setText(String.valueOf(game.getPlayer2().getPuntuacion()));

                TextView player1View = findViewById(R.id.player1Contador);
                player1View.setText(String.valueOf(game.getPlayer1().getPuntuacion()));
            }
        });

    }
}