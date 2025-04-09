package com.example.miravereda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miravereda.model.Pelicula;
import com.squareup.picasso.Picasso;


import java.util.List;

public class AdaptadorRV extends RecyclerView.Adapter<AdaptadorRV.ViewHolder>{
    private LayoutInflater inflater;
    private List<Pelicula> peliculas;
    private View.OnClickListener onClickListener;

    public AdaptadorRV(Context context, List<Pelicula> peliculas, View.OnClickListener onClickListener){
        this.peliculas = peliculas;
        this.onClickListener = onClickListener;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = inflater.inflate(R.layout.view_holder_layout,parent,false);

        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    //asociaa vista con los datos de la posicion
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.textNombre.setText(pelicula.getNombre());
        holder.textTomato.setText(pelicula.getTomatometer());
        holder.textPopcorn.setText(pelicula.getPopcornmeter());
        holder.textFilm.setText(pelicula.getFilmAffinity());
        Picasso.get().load(pelicula.getPortada()).into(holder.portada);

    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView portada;
        private TextView textNombre,textTomato, textPopcorn, textFilm;
        public ViewHolder(@NonNull View itemView) { //el itemView es el layout del viewholder pasado de xml a Vista
            super(itemView);
            portada = itemView.findViewById(R.id.portada);
            textNombre = itemView.findViewById(R.id.textNombre);
            textTomato = itemView.findViewById(R.id.textTomato);
            textPopcorn = itemView.findViewById(R.id.textPopcorn);
            textFilm = itemView.findViewById(R.id.textFilm);

        }
    }
}
