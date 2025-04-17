package com.example.miravereda;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miravereda.model.Pelicula;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Actividad principal que muestra un RecyclerView con una lista de películas.
 * Implementa View.OnClickListener para gestionar los clics en los ítems del RecyclerView.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener { //necesario para el override de abajo

    // Lista de objetos Pelicula que se mostrarán en el RecyclerView
    private List<Pelicula> peliculas;

    // Referencia al RecyclerView en el layout
    private RecyclerView recyclerView;

    /**
     * Méto-do que se ejecuta al crear la actividad.
     * Configura el diseño, inicializa los datos y configura el RecyclerView.
     * @param savedInstanceState Estado guardado de la actividad (si lo hubiera)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Habilita que la interfaz use toda la pantalla (borde a borde)
        setContentView(R.layout.activity_main);

        // Configura los márgenes para que el contenido no quede debajo de la barra de estado o navegación
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Context context = this;

        //Creamos lista con las 12 peliculas
        peliculas = new ArrayList<>(List.of(
                new Pelicula("American Psycho", "6,6","85%","68%","https://pics.filmaffinity.com/american_psycho-503776720-large.jpg"),
                new Pelicula("Atrápame si puedes", "7,3","89%","96%","https://graffica.info/wp-content/uploads/2017/03/atrapamesipuedes0201-724x1024.jpg"),
                new Pelicula("El lobo de Wall Street", "7,6","83%","79%","https://pics.filmaffinity.com/the_wolf_of_wall_street-675195906-large.jpg"),
                new Pelicula("Heat", "7,5","94%","81%","https://pics.filmaffinity.com/heat-911641527-large.jpg"),
                new Pelicula("Toy Story", "7,7","92%","100%","https://pics.filmaffinity.com/toy_story-626273371-large.jpg"),
                new Pelicula("Cars", "6,2","80%","74%","https://pics.filmaffinity.com/cars-746710621-large.jpg"),
                new Pelicula("Monstruos SA", "7,6","90%","92%","https://pics.filmaffinity.com/monsters_inc-336355219-large.jpg"),
                new Pelicula("Buscando a Nemo", "7,5","86%","99%","https://pics.filmaffinity.com/finding_nemo-284341931-large.jpg"),
                new Pelicula("The Terminator", "7,1","89%","100%","https://pics.filmaffinity.com/the_terminator-778052251-large.jpg"),
                new Pelicula("Fast & Furious", "5,6","74%","64%","https://pics.filmaffinity.com/the_fast_and_the_furious-493327751-large.jpg"),
                new Pelicula("Interestellar", "7,9","87%","73%","https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                new Pelicula("Star Wars: The Force Awakens", "6,7","84%","93%","https://pics.filmaffinity.com/star_wars_episode_vii_the_force_awakens-625343391-large.jpg")
        ));

        recyclerView = findViewById(R.id.recycled); //Asignamos a la vista del RecyclerView (recycled) la variable recyclerView

        AdaptadorRV adaptador = new AdaptadorRV(this, peliculas, this);
        //Creamos un adaptador, le pasamos el contexto, la informacion (peliculas)
        // y el onclickListener que llevara al Override de abajo todos los ViewHolders

        recyclerView.setAdapter(adaptador); //Asignamos el adaptador al RecyclerView

        //Importantisimo para que se vea de forma lineal los viewholders, si no, no aparecera
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /**
     * Méto-do que se ejecuta cuando se hace clic en un ViewHolder del RecyclerView.
     * Recupera la posición del ítem clicado y obtiene la película correspondiente de la lista.
     * @param view Vista que fue clicada
     */

    @Override
    public void onClick(View view){
        int posicion = recyclerView.getChildAdapterPosition(view);
        Pelicula pelicula = peliculas.get(posicion);
        //A este override vienen todos los viewholder, se selecciona
        // la posicion del viewholder y se busca la misma posicion en la lista peliculas

        // Aquí puedes lanzar una nueva actividad, mostrar detalles, etc.
        // Por ejemplo:
        // Toast.makeText(this, "Has seleccionado: " + pelicula.getNombre(), Toast.LENGTH_SHORT).show();
    }
}
