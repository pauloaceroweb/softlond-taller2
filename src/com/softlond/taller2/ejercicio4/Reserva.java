package com.softlond.taller2.ejercicio4;

public class Reserva {

    private Cliente cliente;
    private Hotel hotel;
    private Habitacion habitacion;

    public Reserva(Cliente cliente, Hotel hotel, Habitacion habitacion) {
        this.cliente = cliente;
        this.hotel = hotel;
        this.habitacion = habitacion;
        habitacion.reservar();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void cancelar() {
        habitacion.cancelarReserva();
    }
}

