package com.example.bancobpm_act;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edit1, edit2;
    ProgressDialog progressDialog;
    Button btIniciar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btIniciar = findViewById(R.id.btnIniciar);
        edit1 = (EditText) findViewById(R.id.et1);
        edit2 = (EditText) findViewById(R.id.et2);
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = edit1.getText().toString();
                String contra = edit2.getText().toString();

                if (usuario.equalsIgnoreCase("android") && contra.equals("123"))
                {
                    Toast.makeText(getBaseContext(), "Sesión Iniciada Correctamente", Toast.LENGTH_SHORT).show();

                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.show();
                    progressDialog.setContentView(R.layout.progress_dialog);
                     progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    Intent i = new Intent(getBaseContext(), Home_act.class);
                    startActivity(i);
                }
                else
                    {
                    Toast.makeText(getBaseContext(), "Usuario e/o Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                    }
             }
        });

    }
    @Override
    public void onBackPressed()
    {
        progressDialog.dismiss();
    }
}
