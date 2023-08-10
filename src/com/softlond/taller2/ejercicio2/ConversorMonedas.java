package com.softlond.taller2.ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversorMonedas {
    private Map<String, Double> tasasDeCambio;

    public ConversorMonedas() {
        tasasDeCambio = new HashMap<>();
    }

    public void agregarTasaDeCambio(String monedaOrigen, String monedaDestino, double tasa) {
        String clave = generarClaveTasa(monedaOrigen, monedaDestino);
        tasasDeCambio.put(clave, tasa);
    }

    public String[] obtenerMonedasDisponibles() {
        List<String> monedas = new ArrayList<>();
        for (String clave : tasasDeCambio.keySet()) {
            String[] partes = clave.split("-");
            monedas.add(partes[0]);
            monedas.add(partes[1]);
        }
        return monedas.toArray(new String[0]);
    }

    public double convertir(double cantidad, String monedaOrigen, String monedaDestino) {
        String clave = generarClaveTasa(monedaOrigen, monedaDestino);
        if (tasasDeCambio.containsKey(clave)) {
            double tasa = tasasDeCambio.get(clave);
            return cantidad * tasa;
        } else {
            throw new IllegalArgumentException("No se encontró una tasa de cambio para la conversión especificada.");
        }
    }

    private String generarClaveTasa(String monedaOrigen, String monedaDestino) {
        return monedaOrigen + "-" + monedaDestino;
    }
}
