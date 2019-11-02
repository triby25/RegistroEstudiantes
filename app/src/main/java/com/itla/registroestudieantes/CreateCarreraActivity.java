package com.itla.registroestudieantes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.itla.registroestudieantes.adapters.MateriaAdapter;
import com.itla.registroestudieantes.models.Carrera;
import com.itla.registroestudieantes.models.CarreraMateria;
import com.itla.registroestudieantes.models.Materia;
import com.itla.registroestudieantes.repositories.CarreraMateriaRepository;
import com.itla.registroestudieantes.repositories.CarreraRepository;
import com.itla.registroestudieantes.repositories.MateriaRepository;

import java.util.ArrayList;
import java.util.List;

public class CreateCarreraActivity extends AppCompatActivity {
    CarreraRepository carreraRepository;
    MateriaRepository materiaRepository;
    private EditText etnamecarrera;
    private Spinner spinner;
    List<Materia> materias;
    ArrayList<Materia> rcmaterias;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_carrera);

        Button btnsavecarrera = findViewById(R.id.btnsavecarrera);
        Button btnaddmaterialiat = findViewById(R.id.btnaddmateriatolist);
        Button btnnewmateria = findViewById(R.id.btnnewmateria);
        etnamecarrera = findViewById(R.id.etnamecarreramain);
        spinner = findViewById(R.id.spmaterias);
        rcmaterias= new ArrayList<>();

        loadMaterias();

        recyclerView=findViewById(R.id.rvlistmateriacarrera);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MateriaAdapter(rcmaterias);
        recyclerView.setAdapter(adapter);

        btnsavecarrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carreraRepository= new CarreraRepository(v.getContext());

                Carrera carrera = new Carrera();
                carrera.setNombre(etnamecarrera.getText().toString());
                carreraRepository.insert(carrera);

                CarreraMateriaRepository carrera_materiaRepositorioDb = new CarreraMateriaRepository(getApplicationContext());
                carrera_materiaRepositorioDb.deleteAll(carrera.getId());

                for (Materia materia:rcmaterias) {
                    CarreraMateria carreraMateria = new CarreraMateria();
                    carreraMateria.setIdcarrera(carrera.getId());
                    carreraMateria.setIdmateria(materia.getId());
                    carrera_materiaRepositorioDb.insert(carreraMateria);
                }

                etnamecarrera.setText("");

                Toast.makeText(getApplicationContext(),"Carrera Guardada",Toast.LENGTH_SHORT).show();
                setResult(1, null);
                finish();
            }
        });

        btnaddmaterialiat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Materia materia = (Materia) spinner.getSelectedItem();
                Materia materiaSearch = rcmaterias.stream().filter(m ->m.getId()==materia.getId() ).findAny().orElse(null);
                if(materiaSearch!=null){
                    Toast.makeText(getApplicationContext(),"La materia seleccionada ya existe en el listado",Toast.LENGTH_LONG).show();
                    return;
                }
                rcmaterias.add(materia);
                adapter.notifyDataSetChanged();
            }
        });

        btnnewmateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CreateMateriaActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        loadMaterias();
    }

    private void loadMaterias(){
        materiaRepository = new MateriaRepository(getApplicationContext());
        materias = materiaRepository.getAll();
        final ArrayAdapter<Materia> materiaArrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,materias);
        materiaArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(materiaArrayAdapter);
    }
}
