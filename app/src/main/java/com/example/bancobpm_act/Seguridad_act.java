package com.example.bancobpm_act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.PrivateKey;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad_act extends AppCompatActivity {

    public TextView text;
    public EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);

        text=(TextView)findViewById(R.id.tv5);
        edit=(EditText)findViewById(R.id.etContra);
    }

    //con este metodo creamos una key

    private SecretKeySpec generateKey(String password)throws Exception{
        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        byte[] key = password.getBytes("UTF-8");
        key = sh.digest(key);

        SecretKeySpec secretKey = new SecretKeySpec(key,"AES");

        return  secretKey;
    }

    //Aqui Creamos un algoritmo de cifrado
    public String Encriptar (String datos, String password) throws Exception {
       if (!edit.getText().toString().isEmpty())
       {
         //Aqui realizamos el encriptado
           SecretKeySpec secretKey = generateKey(password);
           Cipher cipher= Cipher.getInstance("AES");
           cipher.init(Cipher.ENCRYPT_MODE, secretKey);

           byte[] datosEncriptadosBytes = cipher.doFinal(datos.getBytes());
           String datosEncriptadosString = Base64.encodeToString
                   (datosEncriptadosBytes, Base64.DEFAULT);

           return datosEncriptadosString;
       }
       else
       {
           //mostramos una notificacion
           Toast.makeText(this,"Debe Ingresar Contraseña",
                   Toast.LENGTH_LONG).show();
           return null;
       }
    }
    public void Encriptar2 (View v)
    {
        try {
            String mensaje = Encriptar(edit.getText().toString(), text.getText().toString());
            text.setText(mensaje);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        }
    }
