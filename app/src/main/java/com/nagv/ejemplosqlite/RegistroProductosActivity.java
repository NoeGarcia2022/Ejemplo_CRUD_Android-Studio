package com.nagv.ejemplosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nagv.ejemplosqlite.utilidades.Utilidades;

public class RegistroProductosActivity extends AppCompatActivity {

    EditText txtCodigo, txtDescripcion, txtPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_productos);

        txtCodigo=(EditText) findViewById(R.id.txtCodigo);
        txtDescripcion=(EditText) findViewById(R.id.txtDescripcion);
        txtPrecio=(EditText) findViewById(R.id.txtPrecio);
    }

    public void onClick (View view){
        registrarProductos();
        //registrarProductosSql();
    }

    private void registrarProductosSql() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_productos", null, 1);

        SQLiteDatabase db=conn.getWritableDatabase();

        //insert into productos (codigo, descripcion, precio) values (123,'Telefono',50.00);

        String insert="INSERT INTO "+Utilidades.TABLA_PRODUCTO
                +" ( "
                +Utilidades.CAMPO_CODIGO+","+Utilidades.CAMPO_DESCRIPCION+","+Utilidades.CAMPO_PRECIO+ ")"+
                "VALUES ("+txtCodigo.getText().toString()+",'"+txtDescripcion.getText().toString()+"','"
                +txtPrecio.getText().toString()+"')";
        db.execSQL(insert);

        db.close();
    }

    private void registrarProductos() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_productos", null, 1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_CODIGO,txtCodigo.getText().toString());
        values.put(Utilidades.CAMPO_DESCRIPCION,txtDescripcion.getText().toString());
        values.put(Utilidades.CAMPO_PRECIO,txtPrecio.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_PRODUCTO,Utilidades.CAMPO_CODIGO,values);

        Toast.makeText(getApplicationContext(), "Id_Registro:"+idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}