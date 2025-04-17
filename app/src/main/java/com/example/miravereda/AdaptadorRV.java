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

/**
 * Adaptador personalizado para mostrar una lista de objetos Pelicula en un RecyclerView.
 * Utiliza un ViewHolder personalizado para inflar el diseño de cada ítem y vincular los datos.
 */
public class AdaptadorRV extends RecyclerView.Adapter<AdaptadorRV.ViewHolder> { //Esto implementa los metodos para pasar la informacion a los viewholders

    // Inflador de vistas para convertir XML en objetos View
    private LayoutInflater inflater;

    // Lista de objetos Pelicula que se van a mostrar
    private List<Pelicula> peliculas;

    // Listener para manejar los clics sobre los ítems del RecyclerView
    private View.OnClickListener onClickListener;

    /**
     * Constructor del Adaptador que contiene el contexto, la lista y un onClickListener para el viewHolder
     * @param context Contexto de la actividad
     * @param peliculas Lista de películas a mostrar
     * @param onClickListener Listener para manejar clics en los ítems
     */
    public AdaptadorRV(Context context, List<Pelicula> peliculas, View.OnClickListener onClickListener) {
        this.peliculas = peliculas;
        this.onClickListener = onClickListener;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Méto-do que infla el layout del item y crea una instancia del ViewHolder
     * @param parent ViewGroup al que se añadirá la nueva vista
     * @param viewType Tipo de vista (por si se tienen múltiples tipos de ítems)
     * @return Nuevo ViewHolder inflado
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_holder_layout, parent, false);

        view.setOnClickListener(onClickListener); // Asignamos el listener al item completo
        return new ViewHolder(view);
    }

    /**
     * Asocia vista con los datos de la posición
     * @param holder ViewHolder que contiene las vistas a modificar
     * @param position Posición del ítem dentro del RecyclerView
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { //Asignamos a cada vista del holder la informacion de la pelicula
        Pelicula pelicula = peliculas.get(position);
        holder.textNombre.setText(pelicula.getNombre());
        holder.textTomato.setText(pelicula.getTomatometer());
        holder.textPopcorn.setText(pelicula.getPopcornmeter());
        holder.textFilm.setText(pelicula.getFilmAffinity());
        Picasso.get().load(pelicula.getPortada()).into(holder.portada); // Carga la imagen desde una URL con Picasso
    }

    /**
     * Retorna el número total de ítems en la lista
     * @return Tamaño de la lista de películas
     */
    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    /**
     * Clase ViewHolder interna que representa cada ítem en el RecyclerView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView portada;
        private TextView textNombre, textTomato, textPopcorn, textFilm;

        /**
         * Constructor del ViewHolder
         * @param itemView el itemView es el layout del viewholder pasado de xml a Vista, asocia las vistas con las variables
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            portada = itemView.findViewById(R.id.portada);
            textNombre = itemView.findViewById(R.id.textNombre);
            textTomato = itemView.findViewById(R.id.textTomato);
            textPopcorn = itemView.findViewById(R.id.textPopcorn);
            textFilm = itemView.findViewById(R.id.textFilm);
        }
    }
}
