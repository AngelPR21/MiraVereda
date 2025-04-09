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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {//necesario para el override de abajo

    private List<Pelicula> peliculas;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Context context = this;


        peliculas = new ArrayList<>(List.of(
                new Pelicula("American Psycho", "6,6","85%","68%","https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Flag_of_France.svg/270px-Flag_of_France.svg.png"),
                new Pelicula("Atrápame si puedes", "7,3","89%","96%","https://pics.filmaffinity.com/catch_me_if_you_can-348431648-large.jpg"),
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

        recyclerView = findViewById(R.id.recycled);

        AdaptadorRV adaptador = new AdaptadorRV(this,peliculas,this); //este this envia al onClick de abajo
        recyclerView.setAdapter(adaptador);

        //importantisimo para que se vea de forma lineal los viewholders
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


    }
    @Override //a este override vienen todos los viewholder
    public void onClick(View view){
        int posicion = recyclerView.getChildAdapterPosition(view);
        Pelicula pelicula = peliculas.get(posicion);

    }

}