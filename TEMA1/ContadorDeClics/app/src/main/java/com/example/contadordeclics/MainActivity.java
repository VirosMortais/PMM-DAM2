package com.example.contadordeclics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int contador;
    TextView contadorDeClics;
    Button augmentarElContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contadorDeClics = findViewById(R.id.contadorDeClics);
        augmentarElContador = findViewById(R.id.augmentarElContador);

        augmentarElContador.setOnClickListener(view -> {
            contador++;
            contadorDeClics.setText("Has clicado " + contador + " veces");
        });
    }
}
