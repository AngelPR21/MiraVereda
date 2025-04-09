package com.example.miravereda.model;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String nombre;
    private String filmAffinity;
    private String popcornmeter;
    private String tomatometer;
    private String portada;

    public Pelicula(String nombre, String filmAffinity, String popcornmeter, String tomatometer, String portada) {
        this.nombre = nombre;
        this.filmAffinity = filmAffinity;
        this.popcornmeter = popcornmeter;
        this.tomatometer = tomatometer;
        this.portada = portada;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFilmAffinity() {
        return filmAffinity;
    }

    public String getPopcornmeter() {
        return popcornmeter;
    }

    public String getTomatometer() {
        return tomatometer;
    }

    public String getPortada() {
        return portada;
    }
}
