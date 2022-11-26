package com.example.prueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout tilTitulo, tilDescripcion;
    private Button btnIngresar, btnModificar;
    private ImageButton btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referencias();
        eventos();
    }


    private void mostrarNombreEnOtraActividad(){
        Tareas tareasUno = new Tareas();


        tareasUno.setTitulo("Quinta Normal");
        tareasUno.setDescripcion("pepe cortisona");


        String titulo = tilTitulo.getEditText().getText().toString();

        Intent segundaPantalla = new Intent(this,SegundaActividad.class);
        segundaPantalla.putExtra("datoTitulo", titulo);
        segundaPantalla.putExtra("datosComuna",tareasUno);


        startActivity(segundaPantalla);

    }



    //region Eventos y referencias
    private void eventos(){
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = tilTitulo.getEditText().getText().toString();
                String descripcion = tilDescripcion.getEditText().getText().toString();

                if(titulo.isEmpty())   {
                    tilTitulo.setError("Debe completar este campo");
                }
                else if(descripcion.isEmpty()){
                    tilDescripcion.setError("Debe completar este campo");
                }
                else {
                    tilTitulo.setError(null);
                    mostrarNombreEnOtraActividad();
                }

            }
        });
    }







    private void referencias(){
        tilTitulo = findViewById(R.id.tilTitulo);
        tilDescripcion = findViewById(R.id.tilDescripcion);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnModificar = findViewById(R.id.btnModificar);
        btnBuscar = findViewById(R.id.btnBuscar);
    }
    //endregion
}
