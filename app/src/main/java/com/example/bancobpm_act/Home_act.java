package com.example.bancobpm_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;

import dalvik.system.InMemoryDexClassLoader;

public class Home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int [] images = {R.drawable.a, R.drawable.b, R.drawable.c,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = ( ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i < images.length; i++)
        {
            Seleccion(images[i]);
        }
    }
    public void Seleccion(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);
        vf.addView(view);
        vf.setAutoStart(true);
        vf.setFlipInterval(2800);


        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void Seguridad(View v)
    {
        Intent i = new Intent(this, Seguridad_act.class);
        startActivity(i);
    }
    public void Info(View v)
    {
      Intent i = new Intent(this,Info_act.class);
      startActivity(i);
    }
    public  void Clientes(View v)
    {
        Intent i = new Intent(this,Clientes_act.class);
        startActivity(i);
    }
    public void Prestamos(View v)
    {
        ArrayList<String> Clientes = new ArrayList<>();
        ArrayList<String> Credito = new ArrayList<>();

        Clientes.add("Axel");
        Clientes.add("Roxana");
        Clientes.add("Betzabe");
        Clientes.add("Matias");

        Credito.add("Credito Hipotecario");
        Credito.add("Credito Automotriz");


        Intent i = new Intent(this,Prestamos_act.class);
        i.putExtra("listaClientes",Clientes);
        i.putExtra("listaCredito",Credito);
        startActivity(i);
    }
}