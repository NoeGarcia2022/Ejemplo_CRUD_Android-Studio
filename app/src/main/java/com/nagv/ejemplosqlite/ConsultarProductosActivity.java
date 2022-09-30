package com.nagv.ejemplosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nagv.ejemplosqlite.utilidades.Utilidades;

public class ConsultarProductosActivity extends AppCompatActivity {

    EditText txtCodigoC, txtDescripcionC, txtPrecioC;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_productos);

        conn=new ConexionSQLiteHelper(getApplicationContext(), "bd_productos", null,1);

        txtCodigoC=(EditText) findViewById(R.id.txtCodigoC);
        txtDescripcionC=(EditText) findViewById(R.id.txtDescripcion);
        txtPrecioC=(EditText) findViewById(R.id.txtPrecioC);
    }

    public void OnClick(View view){
        switch (view.getId()){
            case R.id.btnBuscarP:
                consultar();
                break;
                case R.id.btnActualizarP:
                    break;
                    case R.id.btnEliminarP:
                        break;
        }
    }

    private void consultar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[]parametros={txtCodigoC.getText().toString()};
        String[]campos={Utilidades.CAMPO_DESCRIPCION, Utilidades.CAMPO_PRECIO};

        try {
            Cursor cursor = db.query(Utilidades.TABLA_PRODUCTO,
                    campos,Utilidades.CAMPO_CODIGO+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            txtDescripcionC.setText(cursor.getString(0));
            txtPrecioC.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "El codigo no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }

    }

    private void limpiar() {
        txtDescripcionC.setText("");
        txtPrecioC.setText("");
    }
}