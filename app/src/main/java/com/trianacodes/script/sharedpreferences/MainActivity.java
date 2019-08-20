package com.trianacodes.script.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txt_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_email = findViewById(R.id.et_mail);

        // Recupero los datos almacenados en el archivo SharedPreferences
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        txt_email.setText(preferencias.getString("mail", ""));

    }

    public void guardar(View view){

        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("mail",txt_email.getText().toString());
        editor.commit();
        finish();

    }

}
