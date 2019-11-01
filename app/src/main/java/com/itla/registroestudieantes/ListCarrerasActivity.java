package com.itla.registroestudieantes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itla.registroestudieantes.adapters.CarreraAdapter;
import com.itla.registroestudieantes.models.Carrera;
import com.itla.registroestudieantes.repositories.CarreraRepository;

import java.util.ArrayList;
import java.util.List;

public class ListCarrerasActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;
    CarreraRepository carreraRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_carreras);

        Button btnnewarrera = findViewById(R.id.btnnewcarrera);
        carreraRepository = new CarreraRepository(this);
        cargarCarrera();
        btnnewarrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CreateCarreraActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    private void cargarCarrera(){
        List<Carrera> carreras = carreraRepository.getAll();

        recyclerView=findViewById(R.id.rvlistcarreras);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new CarreraAdapter(carreras);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        cargarCarrera();
    }
}
