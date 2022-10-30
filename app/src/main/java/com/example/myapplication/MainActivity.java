package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements

        AdapterView.OnItemSelectedListener {
    String[] pais = {"Chile", "Peru", "Bolivia", "Venezuela", "Argentina","Narnia","Colo Colo", "Otro", "PaoloWill AkA WiLL recortado"};
    private EditText edNombre;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, pais);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edNombre = (EditText) findViewById(R.id.edNombre);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        spinner.setAdapter(aa);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edNombre.getText().toString().isEmpty()){
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("nombre", edNombre.getText().toString());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Debes indicar un nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void Mostrar(View view) {
        Intent mostrar = new Intent(this, MainActivity2.class);
        startActivity(mostrar);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}