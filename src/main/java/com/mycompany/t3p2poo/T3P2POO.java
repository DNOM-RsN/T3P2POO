/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.t3p2poo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
abstract class Persona{
    private String nombre;
    private String id;
    private String generarID() {
        Random random = new Random();
        int numero = random.nextInt(90000) + 10000;
        return String.format("%05d", numero);
    }
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;
    private String genero;

    public Persona (String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.id = generarID();
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getNombre() {
        return nombre;
    }
    public String getId() {
        return id;
    }
   public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public abstract void  baseInfo();
    
} 
class Doctor extends Persona {

    public Doctor(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void baseInfo() {
  
    }
}


class Deportista extends Persona{

    public Deportista(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void baseInfo() {
        
        System.out.println("Hello");
    
    }
}
public class T3P2POO {
    
    public static void main(String[] args) {     
        ArrayList<Persona> registro = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- MENÚ -----");
            System.out.println("1. Registrar un Doctor");
            System.out.println("2. Registrar un Deportista");
            System.out.println("3. Mostrar todas las personas registradas");
            System.out.println("4. Eliminar una persona por su ID");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    break;
                case 2: 
                    break;
                case 3:
                    datosDeRegistros(scanner,registro);
                    break;
                case 4:
                    eliPersonxId(scanner,registro);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 5);
    }
    
    private static void datosDeRegistros(Scanner scanner, ArrayList<Persona> registro) {
        System.out.println("----- MENÚ DE REGISTROS -----");
        System.out.println("1. Mostrar Doctores");
        System.out.println("2. Mostrar Deportistas");
        System.out.println("3. Mostrar todas las personas registradas");
        System.out.print("Ingrese una opción: ");
        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                mostrarDoctores(registro);
                break;
            case 2:
                mostrarDeportistas(registro);
                break;
            case 3:
                mostrarTodasLasPersonas(registro);
                break;
            default:
                System.out.println("Opción inválida. Regresando al menú principal.");
        }
    }

    private static void mostrarDoctores(ArrayList<Persona> registro) {
        System.out.println("----- DOCTORES REGISTRADOS -----");
        boolean encontrados = false;

        for (Persona persona : registro) {
            if (persona instanceof Doctor) {
                persona.baseInfo();
                encontrados = true;
            }
        }

        if (!encontrados) {
            System.out.println("No hay doctores registrados.");
        }

        System.out.println("---------------------------------");
    }

    private static void mostrarDeportistas(ArrayList<Persona> registro) {
        System.out.println("----- DEPORTISTAS REGISTRADOS -----");
        boolean encontrados = false;

        for (Persona persona : registro) {
            if (persona instanceof Deportista) {
                persona.baseInfo();
                encontrados = true;
            }
        }

        if (!encontrados) {
            System.out.println("No hay deportistas registrados.");
        }

        System.out.println("-----------------------------------");
    }

    private static void mostrarTodasLasPersonas(ArrayList<Persona> registro) {
        System.out.println("----- TODAS LAS PERSONAS REGISTRADAS -----");
        if (registro.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            for (Persona persona : registro) {
                persona.baseInfo();
            }
        }
        System.out.println("-----------------------------------------");
    
    }
    
    private static void eliPersonxId(Scanner scanner, ArrayList<Persona> registro) {
        System.out.print("Ingrese el ID de la persona a eliminar: ");
        String id = scanner.nextLine();

        Persona Bencontrada = null;

        for (Persona persona : registro) {
            if (persona.getId().equals(id)) {
                Bencontrada = persona;
                break;
            }
        }

        System.out.println("----- INFORMACIÓN DE LA PERSONA -----");
        if (Bencontrada != null) {
            Bencontrada.baseInfo();
            System.out.println("-------------------------------------");
            System.out.print("¿Desea eliminar esta persona? (S/N): ");
            String opcion = scanner.nextLine();
            if (opcion.equalsIgnoreCase("S")) {
                registro.remove(Bencontrada);
                System.out.println("Persona eliminada exitosamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("No se encontró ninguna persona con el ID proporcionado.");
        }
        System.out.println("-------------------------------------");
    }
}

