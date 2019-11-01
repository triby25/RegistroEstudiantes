package com.itla.registroestudieantes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.registroestudieantes.models.Materia;
import com.itla.registroestudieantes.repositories.MateriaRepository;

public class CreateMateriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_materia);

        Button button = findViewById(R.id.btnsavemateria);
        final EditText etnamemateria = findViewById(R.id.etnamemateria);
        final EditText etcantcredito = findViewById(R.id.etcreditosmateria);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MateriaRepository materiaRepository = new MateriaRepository(v.getContext());
                Materia materia = new Materia();
                materia.setNombre(etnamemateria.getText().toString());
                materia.setCreditos(Integer.parseInt(etcantcredito.getText().toString()));
                materiaRepository.insert(materia);

                etnamemateria.setText("");
                etcantcredito.setText("");

                Toast.makeText(getApplicationContext(),"Materia Guardada",Toast.LENGTH_SHORT).show();
                setResult(1, null);
                finish();
            }
        });
    }
}
