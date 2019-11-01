package com.itla.registroestudieantes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.itla.registroestudieantes.models.Carrera;
import com.itla.registroestudieantes.models.Estudiante;
import com.itla.registroestudieantes.repositories.CarreraRepository;
import com.itla.registroestudieantes.repositories.EstudianteRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CreateEstudianteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_estudiante);

        Button btnsaveestudent = findViewById(R.id.btnsaveestudent);
        final EditText etnombre = findViewById(R.id.etestudentname);
        final EditText etmatricula = findViewById(R.id.etmatricula);
        Button btnaddcarrera = findViewById(R.id.btnaddcarrera);

        CarreraRepository carreraRepository = new CarreraRepository(this);
        List<Carrera> carreras = carreraRepository.getAll();
        final ArrayAdapter<Carrera> carreraArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,carreras);
        carreraArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner = findViewById(R.id.spcarreras);
        spinner.setAdapter(carreraArrayAdapter);


        btnsaveestudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EstudianteRepository estudianteRepository = new EstudianteRepository(v.getContext());
                Carrera carrera = (Carrera) spinner.getSelectedItem();
                Estudiante estudiante = new Estudiante();
                estudiante.setNombre(etnombre.getText().toString());
                estudiante.setMatricula(etmatricula.getText().toString());
                estudiante.setIdcarrera(carrera.getId());
                estudianteRepository.insert(estudiante);

                etnombre.setText("");
                etmatricula.setText("");

                Toast.makeText(getApplicationContext(),"Estudiante Guardado",Toast.LENGTH_SHORT).show();
                setResult(1, null);
                finish();
            }
        });

        btnaddcarrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListCarrerasActivity.class);
                startActivity(intent);
            }
        });
    }
}
