package com.example.miravereda.model;

import java.io.Serializable;

/**
 * Clase que representa una película con diferentes valoraciones y una imagen de portada.
 * Implementa Serializable para poder enviar objetos de esta clase entre actividades.
 */
public class Pelicula implements Serializable {

    // Nombre de la película
    private String nombre;

    // Puntuación en FilmAffinity
    private String filmAffinity;

    // Puntuación del público (palomitas)
    private String popcornmeter;

    // Puntuación de los críticos (tomate)
    private String tomatometer;

    // URL de la imagen de portada
    private String portada;

    /**
     * Constructor que inicializa una película con sus datos.
     *
     * @param nombre Nombre de la película.
     * @param filmAffinity Puntuación en FilmAffinity.
     * @param popcornmeter Valoración del público.
     * @param tomatometer Valoración de la crítica.
     * @param portada URL de la imagen de la portada.
     */
    public Pelicula(String nombre, String filmAffinity, String popcornmeter, String tomatometer, String portada) {
        this.nombre = nombre;
        this.filmAffinity = filmAffinity;
        this.popcornmeter = popcornmeter;
        this.tomatometer = tomatometer;
        this.portada = portada;
    }

    /**
     * @return El nombre de la película.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return La puntuación en FilmAffinity.
     */
    public String getFilmAffinity() {
        return filmAffinity;
    }

    /**
     * @return La puntuación del público (popcornmeter).
     */
    public String getPopcornmeter() {
        return popcornmeter;
    }

    /**
     * @return La puntuación de los críticos (tomatometer).
     */
    public String getTomatometer() {
        return tomatometer;
    }

    /**
     * @return La URL de la imagen de portada.
     */
    public String getPortada() {
        return portada;
    }
}
