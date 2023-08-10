package com.softlond.taller2.ejercicio4;

import javax.swing.*;
import java.util.ArrayList;

public class SistemaReservasHotel {
    private ArrayList<Hotel> hoteles;
    private ArrayList<Reserva> reservas;
    private Cliente clienteActual;

    public SistemaReservasHotel() {
        hoteles = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void agregarHotel(Hotel hotel) {
        hoteles.add(hotel);
    }

    private Habitacion seleccionarHabitacion(Hotel hotel) {
        ArrayList<Habitacion> habitacionesDisponibles = hotel.getHabitacionesDisponibles();

        if (habitacionesDisponibles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles en este hotel.");
            return null;
        }

        StringBuilder opcionesHabitaciones = new StringBuilder("Seleccione una habitación:\n");

        for (Habitacion habitacion : habitacionesDisponibles) {
            opcionesHabitaciones.append("Habitación número: ").append(habitacion.getNumero()).append("\n");
        }

        int opcionSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(opcionesHabitaciones.toString())) - 1;
        return habitacionesDisponibles.get(opcionSeleccionada);
    }

    public void realizarReserva() {
        String nombreEmpresa = JOptionPane.showInputDialog("Ingrese el nombre de la empresa:");
        Cliente cliente = crearCliente(nombreEmpresa);

        StringBuilder infoReserva = new StringBuilder("Reserva realizada:\n");
        infoReserva.append("Nombre de la empresa: ").append(nombreEmpresa).append("\n");

        Hotel hotelSeleccionado = seleccionarHotel();
        if (hotelSeleccionado != null) {
            Habitacion habitacionSeleccionada = seleccionarHabitacion(hotelSeleccionado);
            if (habitacionSeleccionada != null) {
                Reserva reserva = new Reserva(cliente, hotelSeleccionado, habitacionSeleccionada);
                reservas.add(reserva);

                infoReserva.append("Hotel: ").append(hotelSeleccionado.getNombre()).append("\n");
                infoReserva.append("Habitación: ").append(habitacionSeleccionada.getNumero()).append("\n");
                infoReserva.append("Nombre del cliente: ").append(cliente.getNombre()).append("\n");
                infoReserva.append("Cédula del cliente: ").append(cliente.getCedula()).append("\n");
            } else {
                infoReserva.append("No se pudo realizar la reserva debido a la falta de habitaciones disponibles.");
            }
        } else {
            infoReserva.append("No se pudo realizar la reserva debido a la falta de hoteles disponibles.");
        }

        JOptionPane.showMessageDialog(null, infoReserva.toString());
    }

    private Hotel seleccionarHotel() {
        StringBuilder opcionesHoteles = new StringBuilder("Seleccione un hotel:\n");

        for (int i = 0; i < hoteles.size(); i++) {
            opcionesHoteles.append(i + 1).append(". ").append(hoteles.get(i).getNombre()).append("\n");
        }

        int opcionSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(opcionesHoteles.toString())) - 1;
        return hoteles.get(opcionSeleccionada);
    }

    public void cancelarReserva() {
        String cedulaCliente = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
        Reserva reservaEncontrada = null;

        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getCedula().equals(cedulaCliente)) {
                reservaEncontrada = reserva;
                break;
            }
        }

        if (reservaEncontrada != null) {
            reservaEncontrada.cancelar();
            reservas.remove(reservaEncontrada);
            JOptionPane.showMessageDialog(null, "Reserva cancelada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna reserva con la cédula proporcionada.");
        }
    }

    public void mostrarInfoReservas() {
        StringBuilder infoReservas = new StringBuilder("Información de las reservas:\n");

        for (Reserva reserva : reservas) {
            Cliente clienteReserva = reserva.getCliente(); // Obtenemos el cliente de la reserva
            infoReservas.append("Empresa: ").append(clienteReserva.getEmpresa()).append("\n");
            infoReservas.append("Hotel: ").append(reserva.getHotel().getNombre()).append("\n");
            infoReservas.append("Habitación: ").append(reserva.getHabitacion().getNumero()).append("\n");
            infoReservas.append("Nombre del cliente: ").append(clienteReserva.getNombre()).append("\n");
            infoReservas.append("Cédula del cliente: ").append(clienteReserva.getCedula()).append("\n");
            infoReservas.append("\n");
        }

        JOptionPane.showMessageDialog(null, infoReservas.toString());
    }

    public void mostrarHabitacionesDisponiblesPorHotel() {
        StringBuilder infoHabitaciones = new StringBuilder("Habitaciones disponibles por Hotel:\n");

        for (Hotel hotel : hoteles) {
            infoHabitaciones.append("Hotel: ").append(hotel.getNombre()).append("\n");
            ArrayList<Habitacion> habitacionesDisponibles = hotel.getHabitacionesDisponibles();

            if (habitacionesDisponibles.isEmpty()) {
                infoHabitaciones.append("No hay habitaciones disponibles en este hotel.\n");
            } else {
                infoHabitaciones.append("Habitaciones disponibles número: ");
                for (Habitacion habitacion : habitacionesDisponibles) {
                    infoHabitaciones.append(habitacion.getNumero()).append(" ");
                }
                infoHabitaciones.append("\n");
            }

            infoHabitaciones.append("\n");
        }

        JOptionPane.showMessageDialog(null, infoHabitaciones.toString());
    }

    private Cliente crearCliente(String nombreEmpresa) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
        return new Cliente(nombre, cedula, nombreEmpresa);
    }

    private void menuPrincipal() {
        int opcionSeleccionada;
        while (true) {
            String[] opcionesMenu = {
                    "1. Realizar Reserva",
                    "2. Cancelar Reserva",
                    "3. Mostrar información de Reservas",
                    "4. Mostrar habitaciones disponibles por Hotel",
                    "5. Salir"
            };

            opcionSeleccionada = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Sistema de Reservas de Hotel",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcionesMenu,
                    opcionesMenu[0]
            );

            switch (opcionSeleccionada) {
                case 0 -> realizarReserva();
                case 1 -> cancelarReserva();
                case 2 -> mostrarInfoReservas();
                case 3 -> mostrarHabitacionesDisponiblesPorHotel();
                case 4 -> {
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    System.exit(0);
                }
                default ->
                        JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public void ejecutar() {
        agregarHotel(new Hotel("Hotel A", 10));
        agregarHotel(new Hotel("Hotel B", 8));
        agregarHotel(new Hotel("Hotel C", 5));

        menuPrincipal();
    }
}
