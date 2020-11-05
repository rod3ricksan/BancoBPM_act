package com.example.bancobpm_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import clases.AdminSQLiteOpenHelper;

public class Clientes_act extends AppCompatActivity {

    private EditText codigo2,nombre,salario  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        codigo2 = (EditText) findViewById(R.id.et_Codigo);
        nombre = (EditText) findViewById(R.id.et_Nombre);
        salario = (EditText) findViewById(R.id.et_Salario);
    }

    public void Añadir(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1) {
        };
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if (!codigo2.getText().toString().isEmpty()) {
            ContentValues prestamos = new ContentValues();
            prestamos.put("Codigo", codigo2.getText().toString());
            prestamos.put("Nombre", nombre.getText().toString());
            prestamos.put("Salario", salario.getText().toString());

            BaseDeDatos.insert("Prestamos", null, prestamos);
            BaseDeDatos.close();

            Toast.makeText(this, "Se Ha Guardado El Usuario", Toast.LENGTH_LONG).show();


        } else {
            Toast.makeText(this, "Debe Rellenar Los Campos Solicitados", Toast.LENGTH_LONG).show();
        }

    }

    public void Mostrar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codigo2.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor fila = db.rawQuery( "SELECT Nombre,Salario FROM Prestamos WHERE Codigo="+ codigo,null);

            if(fila.moveToFirst())
            {
                nombre.setText(fila.getString(0));
                salario.setText(fila.getString(1));

            }
            else
            {
                Toast.makeText(this, "No Hay Ningun Campo En Usuarios", Toast.LENGTH_LONG).show();
            }

        }
        else
        {
            Toast.makeText(this, "No Hay Ningun Campo En Usuarios", Toast.LENGTH_SHORT).show();

        }
    }
    public void Eliminar(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codigo2.getText().toString();

        db.delete("Prestamos", "Codigo="+codigo, null);
        db.close();

        Toast.makeText(this, "Eliminaste Un Usuario", Toast.LENGTH_SHORT).show();

    }
    public void Actualizar(View v)
    {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codigo2.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", codigo2.getText().toString());
        cont.put("nombre", nombre.getText().toString());
        cont.put("Salario", salario.getText().toString());



        if(!codigo.isEmpty())
        {

            db.update("Prestamos", cont, "Codigo="+codigo, null);
            db.close();

            Toast.makeText(this, "Se Ha Actualizado Con Exito!", Toast.LENGTH_LONG).show();

        }





    }
}
