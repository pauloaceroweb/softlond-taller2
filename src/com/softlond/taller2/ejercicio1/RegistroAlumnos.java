package com.softlond.taller2.ejercicio1;

import javax.swing.*;
import java.util.List;

public class RegistroAlumnos {

    public static void realizarRegistroAlumnos(SistemaAlumnos sistema) {
        int numAlumnos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de alumnos a registrar:"));
        int numCalificaciones = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de calificaciones a registrar:"));

        for (int i = 0; i < numAlumnos; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno " + (i + 1) + ":");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del alumno " + (i + 1) + ":"));

            sistema.agregarAlumno(nombre, edad);


            for (int j = 0; j < numCalificaciones; j++) {
                double calificacion = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la calificación " + (j + 1) + " para " + nombre + ":"));
                sistema.asignarCalificacion(nombre, calificacion);
            }
        }
    }

    public static void mostrarInformacionAlumnos(SistemaAlumnos sistema) {
        StringBuilder informacionAlumnos = new StringBuilder();
        List<Alumno> alumnos = sistema.getAlumnos();

        for (Alumno alumno : alumnos) {
            informacionAlumnos.append(alumno.obtenerInformacion()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, informacionAlumnos.toString(), "Información de Alumnos", JOptionPane.INFORMATION_MESSAGE);
    }

}
