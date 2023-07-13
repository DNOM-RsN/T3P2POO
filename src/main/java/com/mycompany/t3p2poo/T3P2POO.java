/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.t3p2poo;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
abstract class Persona{
    private String nombre;
    private int edad;

    public Persona (String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public abstract void  baseInfo();
} 

class Doctor extends Persona{

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
                    break;
                case 4:
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
}
