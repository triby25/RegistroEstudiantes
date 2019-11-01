package com.itla.registroestudieantes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itla.registroestudieantes.adapters.MateriaAdapter;
import com.itla.registroestudieantes.models.Materia;
import com.itla.registroestudieantes.repositories.MateriaRepository;

import java.util.List;

public class ListMateriasActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;
    MateriaRepository materiaRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_materias);

        materiaRepository= new MateriaRepository(this);

        final Button btnnewmateria = findViewById(R.id.btnnewmateria);
        cargarMateria();
        btnnewmateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CreateMateriaActivity.class);
                startActivityForResult(intent,1);
            }
        });

    }

    private void cargarMateria(){
        List<Materia> materias = materiaRepository.getAll();

        recyclerView=findViewById(R.id.rvlistmaterias);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new MateriaAdapter(materias);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        cargarMateria();
    }
}
