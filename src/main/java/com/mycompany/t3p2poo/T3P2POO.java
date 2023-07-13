/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.t3p2poo;

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
        System.out.println("Hello World!");//
    }
}
