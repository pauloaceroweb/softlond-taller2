package com.softlond.taller2.ejercicio4;

public class Cliente {
    private String nombre;
    private String cedula;
    private String empresa; // Agregamos este campo

    public Cliente(String nombre, String cedula, String empresa) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEmpresa() {
        return empresa;
    }
}
