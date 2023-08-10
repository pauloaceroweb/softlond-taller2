package com.softlond.taller2.ejercicio1;

import java.util.ArrayList;

public class SistemaAlumnos {
    private ArrayList<Alumno> alumnos;

    public SistemaAlumnos() {
        this.alumnos = new ArrayList<>();
    }

    public void agregarAlumno(String nombre, int edad) {
        Alumno alumno = new Alumno(nombre, edad);
        alumnos.add(alumno);
    }

    public void asignarCalificacion(String nombre, double calificacion) {
        Alumno alumno = buscarAlumno(nombre);
        if (alumno != null) {
            alumno.asignarCalificacion(calificacion);
        }
    }

    public Alumno buscarAlumno(String nombre) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equals(nombre)) {
                return alumno;
            }
        }
        return null;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }
}
