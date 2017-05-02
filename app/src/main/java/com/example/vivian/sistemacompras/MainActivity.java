package com.example.vivian.sistemacompras;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tx_titulo;

    private CheckBox chk_arroz;
    private CheckBox chk_leite;
    private CheckBox chk_carne;
    private CheckBox chk_feijao;
    private CheckBox chk_refrigerante;

    private Button bt_total;

    double resultado = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tx_titulo = (TextView) findViewById(R.id.tx_titulo);
        chk_arroz = (CheckBox) findViewById(R.id.chk_arroz);
        chk_leite = (CheckBox) findViewById(R.id.chk_leite);
        chk_carne = (CheckBox) findViewById(R.id.chk_carne);
        chk_feijao = (CheckBox) findViewById(R.id.chk_feijao);
        chk_refrigerante = (CheckBox) findViewById(R.id.chk_refrigerante);
        bt_total = (Button) findViewById(R.id.bt_total);

        tx_titulo.setText("Escolha seu produto");
        chk_arroz.setText("Arroz 1 kg(R$ 2,69)");
        chk_leite.setText("Leite Longa Vida(R$ 2,70)");
        chk_carne.setText("Carne Friboi(R$ 16,70)");
        chk_feijao.setText("Feijão Carioquinha(R$ 3,38)");
        chk_refrigerante.setText("Refrigerante Coca-Cola 2L(R$ 3,00)");
        bt_total.setText("Total da Compra");

        bt_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (chk_arroz.isChecked()) {
                    resultado += 2.69;
                }
                if (chk_leite.isChecked()) {
                    resultado += 2.70;
                }
                if (chk_carne.isChecked()) {
                    resultado += 16.70;
                }
                if (chk_feijao.isChecked()) {
                    resultado += 3.38;
                }
                if (chk_refrigerante.isChecked()) {
                    resultado += 3.00;
                }

                alerta();

            }
        });
    }

    public void alerta(){

        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setTitle("Total de Compras");
        alerta.setIcon(R.drawable.ic_compras);
        alerta.setMessage("Total a Apagar em R$: " + String.format("%.2f",resultado));
        alerta.setPositiveButton("Ok",null);
        alerta.show();

    }

}
