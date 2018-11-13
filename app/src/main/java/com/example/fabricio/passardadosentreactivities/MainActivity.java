package com.example.fabricio.passardadosentreactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String NOME_KEY = "nome";
    public static final String IDADE_KEY = "idade";
    public static final String EMAIL_KEY = "email";

    private EditText nomeEditText;
    private EditText idadeEditText;
    private EditText emailEditText;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEditText = findViewById(R.id.nome_edittext_activity_main);
        idadeEditText = findViewById(R.id.idade_edittext_activity_main);
        emailEditText = findViewById(R.id.email_edittext_activity_main);

        okButton = findViewById(R.id.ok_button_activity_main);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validaDados()) {

                    String nome = nomeEditText.getText().toString();;
                    int idade = Integer.parseInt(idadeEditText.getText().toString());
                    String email = emailEditText.getText().toString();

                    Intent intent = new Intent(MainActivity.this,SegundaActivity.class);
                    intent.putExtra(NOME_KEY, nome);
                    intent.putExtra(IDADE_KEY, idade);
                    intent.putExtra(EMAIL_KEY, email);
                    setResult(RESULT_OK, intent);
                    startActivity(intent);
                    //finish();
                }

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        nomeEditText.setText("");
        idadeEditText.setText("");
        emailEditText.setText("");
    }

    private boolean validaDados (){

        int totalValidacoes = 0;
        String dadoInserido;

        //nomeEditText não pode ficar vazio
        dadoInserido = nomeEditText.getText().toString();
        if((dadoInserido != null) && (!dadoInserido.equals(""))) {
            totalValidacoes ++;
        } else {
            nomeEditText.setError("Necessário inserir o seu nome");
        }

        //idadeEditText não pode ficar vazio
        dadoInserido = idadeEditText.getText().toString();
        if((dadoInserido != null) && (!dadoInserido.equals(""))) {
            totalValidacoes ++;
        } else {
            idadeEditText.setError("Necessário inserir sua idade");
        }

        //emailEditText não pode ficar vazio, tem que ter "@" e tem que ter "."
        dadoInserido = emailEditText.getText().toString();
        if( (dadoInserido != null) &&
                (!dadoInserido.equals("")) &&
                (dadoInserido.contains("@")) &&
                (dadoInserido.contains(".")) ) {
            totalValidacoes ++;
        } else {
            emailEditText.setError("Necessário inserir e-mail válido");

        }

        //totalValidacoes = 3 significa que as 3 validações acima foram true
        if (totalValidacoes == 3) {
//                    Toast.makeText(
//                            MainActivity.this,
//                            String.format("NOME: %s \nIDADE: %d anos\nE-MAIL: %s ", nome, idade, email),
//                            Toast.LENGTH_LONG).show();
            return true;
        }

        return false;
    }

}
