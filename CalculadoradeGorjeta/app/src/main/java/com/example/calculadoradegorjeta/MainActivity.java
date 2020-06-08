package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView txtPorcentagem;
    private TextView txtGorgeta;
    private TextView txtTotal;
    private SeekBar seekBarGorgeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
        inicializarEventos();
    }
    public void inicializarComponentes(){
        editValor = findViewById(R.id.edtValor);
        txtGorgeta = findViewById(R.id.txtGorgeta);
        txtPorcentagem = findViewById(R.id.txtPorcentagem);
        txtTotal = findViewById(R.id.txtTotal);
        seekBarGorgeta = findViewById(R.id.seekBarBorgeta);
    }
    public void inicializarEventos(){
        seekBarGorgeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                txtPorcentagem.setText( Math.round(porcentagem) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void calcular(){

        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(), "Digite um valor primeiro", Toast.LENGTH_LONG).show();
        }else{
            //Converter string para double
            double valorDigitado = Double.parseDouble(valorRecuperado);

            //Calcula a gorjeta total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            //exibe a gorjeta e total
            txtGorgeta.setText("R$ " + Math.round(gorjeta));
            txtTotal.setText("R$ " + Math.round(total));
        }
    }
}
