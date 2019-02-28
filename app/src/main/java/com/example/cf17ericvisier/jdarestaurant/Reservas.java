package com.example.cf17ericvisier.jdarestaurant;

public class Reservas {

    String fecha;
    String personas;

    public Reservas() {
    }

    public Reservas(String fecha, String personas) {
        this.fecha = fecha;
        this.personas = personas;
    }

    public Reservas(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPersonas() {
        return personas;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }
}
