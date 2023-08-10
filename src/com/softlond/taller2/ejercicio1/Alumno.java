package com.softlond.taller2.ejercicio1;

import java.util.ArrayList;

public class Alumno {
    private final String nombre;
    private final int edad;
    private final ArrayList<Double> calificaciones;

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void asignarCalificacion(double calificacion) {
        calificaciones.add(calificacion);
    }

    public double calcularPromedio() {
        if (calificaciones.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double calificacion : calificaciones) {
            sum += calificacion;
        }
        return sum / calificaciones.size();
    }

    public String obtenerInformacion() {
        return "Nombre: " + nombre +
                "\nEdad: " + edad +
                "\nCalificaciones: " + calificaciones +
                "\nPromedio: " + calcularPromedio();
    }
}
