/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaz;

import com.utilidades.UtilidadesValidacion;

/**
 *
 * @author CEC
 */
public class PrincipalConsola {

    public static void main(String[] args) {
//        boolean esCorreoValido=UtilidadesValidacion.validarCorreoElectronico("magofdl@.com");
//        System.out.println("correo valido: "+esCorreoValido);

        String cadena = UtilidadesValidacion.eliminarCaracteresProhibidos("rojo,amarillo,verde,azul,morado,marrón");
        System.out.println("cadena: " + cadena);
        int inicio = cadena.indexOf(",");
        int fin = cadena.indexOf(",", inicio + 1);
        System.out.println("cadena inicio: " + inicio);
        System.out.println("cadena fin: " + fin);
        
        System.out.println("cadena sub: " + cadena.substring(inicio+1, fin));
        System.out.println("cadena sub: " + cadena.substring(inicio));
       

    }

}
