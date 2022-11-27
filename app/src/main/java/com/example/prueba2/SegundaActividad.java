package com.example.prueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class SegundaActividad extends AppCompatActivity {
    private ListView ltvTareas;
    private Button btnFiltrar;
    private TextInputLayout tilBuscar;


    private ArrayAdapter<Tareas> adaptadorTareasLista;

    private ArrayList<Tareas> lasTareasLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        referencias();
        obtenerDatos();
        //eventos();

        adaptadorTareasLista = new ArrayAdapter<Tareas>(this, android.R.layout.simple_list_item_1, lasTareasLista);
        ltvTareas.setAdapter(adaptadorTareasLista);
    }
    private void mostrarNombreEnOtraActividad() {

        Intent segundaPantalla = new Intent(this,SegundaActividad.class);
        startActivity(segundaPantalla);
    }
    private void obtenerDatos() {
        Tareas tareas = (Tareas) getIntent().getExtras().getSerializable("datosTareas");

        for(int x = 0; x <= 1000; ++x){
            Tareas c = new Tareas();
            c.setTitulo("Titulo de tarea " + x);
            c.setDescripcion("descripción de tarea  " + x);
            lasTareasLista.add(c);
        }
    }

    private void referencias() {
        btnFiltrar = findViewById(R.id.btnFiltrar);
        ltvTareas = findViewById(R.id.ltvTareas);

        lasTareasLista = new ArrayList<Tareas>();
    }




}