package com.softlond.taller2.ejercicio2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GestorConversorMonedas {

    public static void agregarTasasDeCambio(ConversorMonedas conversor) {
        conversor.agregarTasaDeCambio("USD", "EUR", 0.85);
        conversor.agregarTasaDeCambio("EUR", "USD", 1.18);
        conversor.agregarTasaDeCambio("MXN", "USD", 0.049);
        conversor.agregarTasaDeCambio("USD", "MXN", 20.42);
        conversor.agregarTasaDeCambio("USD", "COP", 3500.0);
        conversor.agregarTasaDeCambio("COP", "USD", 0.00029);
        conversor.agregarTasaDeCambio("USD", "ARS", 96.0);
        conversor.agregarTasaDeCambio("ARS", "USD", 0.0104);
        conversor.agregarTasaDeCambio("USD", "BRL", 5.23);
    }

    public static void realizarConversion(ConversorMonedas conversor) {
        String[] monedasDisponibles = conversor.obtenerMonedasDisponibles();

        String mensajeMonedaOrigen = "Seleccione la moneda de origen:";
        String monedaOrigen = (String) JOptionPane.showInputDialog(null, mensajeMonedaOrigen,
                "Conversor de Monedas", JOptionPane.QUESTION_MESSAGE,
                null, monedasDisponibles, monedasDisponibles[0]);

        List<String> monedasDestinoList = new ArrayList<>();
        for (String moneda : monedasDisponibles) {
            if (!moneda.equals(monedaOrigen)) {
                monedasDestinoList.add(moneda);
            }
        }
        String[] monedasDestino = monedasDestinoList.toArray(new String[0]);
        String mensajeMonedaDestino = "Seleccione la moneda de destino:";
        String monedaDestino = (String) JOptionPane.showInputDialog(null,
                mensajeMonedaDestino, "Conversor de Monedas",
                JOptionPane.QUESTION_MESSAGE, null, monedasDestino, monedasDestino[0]);

        double cantidadAConvertir = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a convertir:"));

        double cantidadConvertida = conversor.convertir(cantidadAConvertir, monedaOrigen, monedaDestino);
        String mensajeResultado = cantidadAConvertir + " " + monedaOrigen + " son equivalentes a "
                + cantidadConvertida + " " + monedaDestino;
        JOptionPane.showMessageDialog(null, mensajeResultado,
                "Resultado de Conversión", JOptionPane.INFORMATION_MESSAGE);
    }
}

