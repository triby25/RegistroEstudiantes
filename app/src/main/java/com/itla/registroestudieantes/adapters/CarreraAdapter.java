package com.itla.registroestudieantes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.registroestudieantes.R;
import com.itla.registroestudieantes.models.Carrera;

import java.util.List;

public class CarreraAdapter extends  RecyclerView.Adapter <RecyclerView.ViewHolder> {
    private static TextView etnombrecarrera,etcanmateria,etcancredito;
    private List<Carrera> carreras;

    public static class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            etnombrecarrera = itemView.findViewById(R.id.etnombrecarrera);
            etcanmateria = itemView.findViewById(R.id.tvcantmateria);
            etcancredito = itemView.findViewById(R.id.tvcancredito);
        }
    }
    public CarreraAdapter(List<Carrera> carreras)
    {
        this.carreras=carreras;
    }


    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrera,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Carrera carreras= this.carreras.get(position);

        etnombrecarrera.setText(carreras.getNombre());
        etcancredito.setText("Cant.Creditos ###");
        etcanmateria.setText("Cant. Materias ###");

    }

    @Override
    public int getItemCount() {
        return this.carreras.size();
    }
}
