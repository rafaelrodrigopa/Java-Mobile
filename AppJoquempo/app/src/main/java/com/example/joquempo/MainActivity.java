package com.example.joquempo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView appEscolha;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
    }
    public void inicializarComponentes(){
        appEscolha = findViewById(R.id.appEscolhaImg);
        textoResultado = findViewById(R.id.txtResultado);
    }
    public void selecionadoPedra(View view){
        opcaoSelecionada("pedra");
    }
    public void selecionadoPapel(View view){
        opcaoSelecionada("papel");
    }
    public void selecionadoTesoura(View view){
        opcaoSelecionada("tesoura");
    }
    public void opcaoSelecionada(String escolhaUsuario){
        int numero = new Random().nextInt(3); //Gera um número aleatório no intervalo de 0 a 2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "pedra":
                appEscolha.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                appEscolha.setImageResource(R.drawable.papel);
            case "tesoura":
                appEscolha.setImageResource(R.drawable.tesoura);
            break;
        }

        if(
                (escolhaUsuario == "papel" && opcaoApp == "tesoura") ||
                (escolhaUsuario == "pedra" && opcaoApp == "papel") ||
                (escolhaUsuario == "tesoura" && opcaoApp == "pedra")
        ){
            //App ganhador
            textoResultado.setText("Você perdeu :(");
        }else if (
                (opcaoApp == "papel" && escolhaUsuario == "tesoura") ||
                (opcaoApp == "pedra" && escolhaUsuario == "papel") ||
                (opcaoApp == "tesoura" && escolhaUsuario == "pedra")
        ){
            //Usuario ganhador
            textoResultado.setText("Você ganhou :)");
        }else{
            //Empate
            textoResultado.setText("Empatamos :|");
        }
    }
}
