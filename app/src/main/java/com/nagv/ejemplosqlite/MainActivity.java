package com.nagv.ejemplosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_productos", null, 1);
    }

    public void OnClick(View view){
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.btnOpcionRegistros:
                miIntent=new Intent(MainActivity.this,RegistroProductosActivity.class);
                break;
            case R.id.btnOpcionConsultar:
                miIntent=new Intent(MainActivity.this,ConsultarProductosActivity.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }
}