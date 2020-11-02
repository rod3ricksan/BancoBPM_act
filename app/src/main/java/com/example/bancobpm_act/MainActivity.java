package com.example.bancobpm_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edit1, edit2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.et1);
        edit2 = (EditText) findViewById(R.id.et2);

    }
    public void Ingresar(View v) {

        String usuario = edit1.getText().toString();
        String contra = edit2.getText().toString();

        switch (v.getId()) {
            case R.id.button:
                if (usuario.equalsIgnoreCase("android") && contra.equals("123")) {
                    Toast.makeText(this, "Sesión Iniciada Correctamente", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, Home_act.class);
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Usuario e/o Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                }

                break;

            default:
                break;
        }


    }
}