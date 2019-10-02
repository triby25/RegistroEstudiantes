package com.itla.registroestudieantes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.itla.registroestudieantes.entidades.Estudiante;
import com.itla.registroestudieantes.repositorio.EstudianteRepositorio;
import com.itla.registroestudieantes.repositorio.EstudianteRepositorioDbImpl;

public class MainActivity extends AppCompatActivity {
    EstudianteRepositorio estudianteRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btguardar);
        final EditText tvnombre = findViewById(R.id.tvnombre);
        final EditText tvmatricula = findViewById(R.id.tvmatricula);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estudianteRepositorio = new EstudianteRepositorioDbImpl(v.getContext());
                Estudiante estudiante = new Estudiante();
                estudiante.setNombre(tvnombre.getText().toString());
                estudiante.setMatricula(tvmatricula.getText().toString());

                estudianteRepositorio.crear(estudiante);

                tvnombre.setText("");
                tvmatricula.setText("");
                tvnombre.requestFocus();
            }
        });
    }
}
