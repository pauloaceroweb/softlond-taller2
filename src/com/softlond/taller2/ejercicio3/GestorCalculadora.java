package com.softlond.taller2.ejercicio3;

import javax.swing.*;

public class GestorCalculadora {
    private Calculadora calculadora;

    public GestorCalculadora() {
        calculadora = new Calculadora();
    }

    public void realizarOperacion() {
        String operacionSeleccionada;

        do {
            String[] opciones = {"Suma", "Resta", "Multiplicación", "División", "Salir"};
            operacionSeleccionada = obtenerOpcion(opciones);

            if (operacionSeleccionada.equals("Salir")) {
                mostrarMensaje("Gracias por utilizar la calculadora. ¡Hasta pronto!");
                break;
            }

            double numero1 = ingresarNumero("Ingrese el primer número:");
            double numero2 = ingresarNumero("Ingrese el segundo número:");

            double resultado = gestionaOperaciones(operacionSeleccionada, numero1, numero2);
            mostrarResultado(resultado, operacionSeleccionada);

        } while (!operacionSeleccionada.equals("Salir"));
    }

    private String obtenerOpcion(String[] opciones) {
        return (String) JOptionPane.showInputDialog(
                null, "Seleccione una operación:", "Calculadora",
                JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
    }

    private double ingresarNumero(String mensaje) {
        return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
    }

    private double gestionaOperaciones(String operacion, double num1, double num2) {
        switch (operacion) {
            case "Suma":
                return calculadora.suma(num1, num2);
            case "Resta":
                return calculadora.resta(num1, num2);
            case "Multiplicación":
                return calculadora.multiplicacion(num1, num2);
            case "División":
                try {
                    return calculadora.division(num1, num2);
                } catch (ArithmeticException e) {
                    mostrarMensaje("Error: " + e.getMessage());
                    return 0;
                }
            default:
                return 0;
        }
    }

    private void mostrarResultado(double resultado, String operacionSeleccionada) {
        mostrarMensaje("El resultado de la "+ operacionSeleccionada + " es: " + resultado);
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}

