package com.softlond.taller2.ejercicio4;

import java.util.ArrayList;

public class Hotel {
    private String nombre;
    private ArrayList<Habitacion> habitaciones;

    public Hotel(String nombre, int numHabitaciones) {
        this.nombre = nombre;
        habitaciones = new ArrayList<>();

        for (int i = 1; i <= numHabitaciones; i++) {
            habitaciones.add(new Habitacion(i));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Habitacion> getHabitacionesDisponibles() {
        ArrayList<Habitacion> disponibles = new ArrayList<>();

        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isDisponible()) {
                disponibles.add(habitacion);
            }
        }

        return disponibles;
    }
}
