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

    private EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        et1 = (EditText) findViewById(R.id.et_Codigo);
        et2 = (EditText) findViewById(R.id.et_Nombre);
        et3 = (EditText) findViewById(R.id.et_Salario);
    }

    public void Añadir(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1) {
        };
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if (!et1.getText().toString().isEmpty()) {
            ContentValues prestamos = new ContentValues();
            prestamos.put("Codigo", et1.getText().toString());
            prestamos.put("Nombre", et2.getText().toString());
            prestamos.put("Salario", et3.getText().toString());

            BaseDeDatos.insert("Componentes", null, prestamos);
            BaseDeDatos.close();

            Toast.makeText(this, "Se Ha Guardado El Componente", Toast.LENGTH_LONG).show();


        } else {
            Toast.makeText(this, "Debe Rellenar Los Campos Solicitados", Toast.LENGTH_LONG).show();
        }

    }

    public void Mostrar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = et1.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor fila = db.rawQuery( "SELECT nombre,precio ,stock FROM componente WHERE codigo="+ codigo,null);

            if(fila.moveToFirst())
            {
                et2.setText(fila.getString(0));
                et3.setText(fila.getString(1));

            }
            else
            {
                Toast.makeText(this, "No Hay Ningun Campo En Componentes", Toast.LENGTH_LONG).show();
            }

        }
        else
        {
            Toast.makeText(this, "No Hay Ningun Campo En Componentes", Toast.LENGTH_SHORT).show();

        }
    }
    public void Eliminar(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = et1.getText().toString();

        db.delete("Componente", "Codigo="+codigo, null);
        db.close();

        Toast.makeText(this, "Eliminaste Un Componente", Toast.LENGTH_SHORT).show();

    }
    public void Actualizar(View v)
    {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = et1.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", et1.getText().toString());
        cont.put("nombre", et2.getText().toString());
        cont.put("Salario", et3.getText().toString());



        if(!codigo.isEmpty())
        {

            db.update("Componente", cont, "Codigo="+codigo, null);
            db.close();

            Toast.makeText(this, "Se Ha Actualizado Con Exito!", Toast.LENGTH_LONG).show();

        }





    }
}
