/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio;

/**
 *
 * @author CEC
 */
public class EjemploThread extends Thread{
    
    String nombre;

    public EjemploThread(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            
        }
        System.out.println("Termina thread "+this.nombre);
    }
    
    
}
