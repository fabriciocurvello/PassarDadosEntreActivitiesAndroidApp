package com.example.fabricio.passardadosentreactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView nomeTextView;
    private TextView idadeTextView;
    private TextView emailTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        nomeTextView = findViewById(R.id.nome_edittext_segunda_activity);
        idadeTextView = findViewById(R.id.idade_edittext_segunda_activity);
        emailTextView = findViewById(R.id.email_edittext_segunda_activity);

        //Recuperar os dados enviados da MainActivity
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString(MainActivity.NOME_KEY);
        int idade = dados.getInt(MainActivity.IDADE_KEY);
        String email = dados.getString(MainActivity.EMAIL_KEY);

        nomeTextView.setText(nome);
        idadeTextView.setText(idade + " anos");
        emailTextView.setText(email);

    }
}
