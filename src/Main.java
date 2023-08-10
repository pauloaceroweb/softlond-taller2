import com.softlond.taller2.ejercicio1.RegistroAlumnos;
import com.softlond.taller2.ejercicio1.SistemaAlumnos;
import com.softlond.taller2.ejercicio2.ConversorMonedas;
import com.softlond.taller2.ejercicio2.GestorConversorMonedas;
import com.softlond.taller2.ejercicio3.GestorCalculadora;
import com.softlond.taller2.ejercicio4.SistemaReservasHotel;

import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    MENU PRINCIPAL
                    Ingrese el número del Ejercicio a ver:
                    1. Registro de Alumnos
                    2. Conversor de Monedas
                    3. Calculadora Simple
                    4. Sistema de Reservas de Hotel  
                    5. Salir del Sistema
                    """));

            switch (opcion) {
                case 1 -> {
                    JOptionPane.showMessageDialog(null, "Registro de Alumnos");
                    SistemaAlumnos sistema = new SistemaAlumnos();
                    RegistroAlumnos.realizarRegistroAlumnos(sistema);
                    RegistroAlumnos.mostrarInformacionAlumnos(sistema);
                }
                case 2 -> {
                    JOptionPane.showMessageDialog(null, "Conversor de Monedas");
                    ConversorMonedas conversor = new ConversorMonedas();
                    GestorConversorMonedas.agregarTasasDeCambio(conversor);
                    GestorConversorMonedas.realizarConversion(conversor);
                }
                case 3 -> {
                    JOptionPane.showMessageDialog(null, "Calculadora Simple");
                    GestorCalculadora gestorCalculadora = new GestorCalculadora();
                    gestorCalculadora.realizarOperacion();
                }
                case 4 -> {
                    JOptionPane.showMessageDialog(null, "Sistema de Reserva de Hotel");
                    SistemaReservasHotel sistema = new SistemaReservasHotel();
                    sistema.ejecutar();
                }
                case 5 -> JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa. ¡Hasta luego!");
            }

        } while (opcion != 5);


    }
}

