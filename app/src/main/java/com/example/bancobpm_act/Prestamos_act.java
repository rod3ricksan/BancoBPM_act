package com.example.bancobpm_act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import clases.Cliente;
import clases.Credito;

public class Prestamos_act extends AppCompatActivity {

        private Spinner spin1,spin2;
        private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);


        spin1 = (Spinner)findViewById(R.id.spnNombre);
        spin2 = (Spinner)findViewById(R.id.spnCredito);
        text = (TextView)findViewById(R.id.tv5);

        ArrayList<String> listaClientes = (ArrayList<String>)
                getIntent().getSerializableExtra("listaClientes");

        ArrayList<String>listaCredito=(ArrayList<String>)
                getIntent().getSerializableExtra("listaCredito");

        ArrayAdapter<String> adapt = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1,listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1,listaCredito);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);
    }
    public void Prestamo(View v)
    {
        String Clientes = spin1.getSelectedItem().toString();
        String Creditos = spin2.getSelectedItem().toString();

        Credito credito = new Credito();
        Cliente clientes = new Cliente();

        int montoAxel = clientes.getAxel();
        int montoRoxana = clientes.getRoxana();


        int montoHipo = credito.getHipotecario();
        int montoAuto = credito.getAutomotriz();



        if(Clientes.equals("Axel"))
        {
            if(Creditos.equals("Credito Hipotecario"))
            {
                int montoPrestamo = montoAxel+montoHipo;
                text.setText("Tu Monto Es= "+ montoPrestamo);
            }
            else
            {
                int montoPrestamo = montoAxel+montoAuto;
                text.setText("Tu Monto Es ="+montoPrestamo);
            }
        }

        else if (Clientes.equals("Roxana"))
        {
           if (Creditos.equals("Credito Hipotecario"))
           {
             int montoPrestamos = montoRoxana+montoHipo;
             text.setText("Tu Monto Es ="+montoPrestamos);
           }
           else
           {
               int montoPrestamo = montoRoxana+montoAuto;
               text.setText("Tu Monto Es ="+montoPrestamo);
           }
        }
    }
    public void Deudas (View v)
    {
        String Clientes = spin1.getSelectedItem().toString();
        String Creditos = spin2.getSelectedItem().toString();

        Credito credito = new Credito();
        Cliente clientes = new Cliente();

        int montoAxel = clientes.getAxel();
        int montoRoxana = clientes.getRoxana();


        int montoHipo = credito.getHipotecario();
        int montoAuto = credito.getAutomotriz();


        if (Clientes.equals("Axel"))
        {
           if (Creditos.equals("Credito Hipotecario"))
           {
               int montoPrestamo = montoAxel+montoHipo;
               int montoFinal= montoPrestamo/12;
               text.setText("Las Cuotas Que Debe Pagar Son = "+montoFinal+" Por 12 Meses");
           }
           else
           {
               int montoPrestamo = montoAxel+montoAuto;
               int montoFinal = montoPrestamo/8;
               text.setText("Ls Cuotas Que Debe Pagar Son = "+montoFinal+" Por 8 Meses");
           }
        }
        else if (Clientes.equals("Roxana"))
        {
            if (Creditos.equals("Credito Hipotecario"))
            {
                int montoPrestamo = montoRoxana+montoHipo;
                int montoFinal = montoPrestamo/12;
                text.setText("Las Cuotas Que Debe Pagar Son = "+montoFinal+ " Por 12 Meses");
            }
            else
            {
                int montoPrestamo = montoRoxana+montoAuto;
                int montoFinal = montoPrestamo/8;
                text.setText("Ls Cuotas Que Debe Pagar Son = "+montoFinal+ " Por 8 Meses");
            }

        }




    }
}