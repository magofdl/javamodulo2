/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author FDL
 */
public class UtilidadesValidacion {

    /**
     *
     * @param correo representa el valor ingresado por el usuario
     * @return true si la validacion es exitosa, caso contrario falso
     */
    public static boolean validarCorreoElectronico(String correo) {

        boolean esCorreoValido = false;

        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.(?:[A-Z]{2}|com|org|net|edu|gov|mil|\n"
                + "biz|info|mobi|name|aero|asia|jobs|museum)$");
        Matcher matcher = pattern.matcher(correo);

        if (matcher.find() == true) {
            return esCorreoValido = true;
        }

//        Pattern pattern = Pattern.compile("^\\.|^@");
//        Matcher matcher = pattern.matcher(correo);
//
//        if (matcher.find() == true) {
//            return esCorreoValido = false;
//        }
//
//        pattern = Pattern.compile("www\\.|WWW\\.");
//        matcher = pattern.matcher(correo);
//
//        if (matcher.find() == true) {
//            return esCorreoValido = false;
//        }
//        
//        pattern = Pattern.compile("@");
//        matcher = pattern.matcher(correo);
//
//        if (matcher.find() == false) {
//            return esCorreoValido = false;
//        }
//        
//        pattern = Pattern.compile("\\.");
//        matcher = pattern.matcher(correo);
//
//        if (matcher.find() == false) {
//            return esCorreoValido = false;
//        }
        return esCorreoValido;
    }

    public static String eliminarCaracteresProhibidos(String cadena) {
        String cadenaAuxiliar = "";
        String regex = "[^A-Za-z0-9\\.\\-\\,\\s]+";
        cadenaAuxiliar = cadena.replaceAll(regex, "");
        return cadenaAuxiliar;
    }

    public static boolean validarSoloNumeros(String texto) {
        boolean cadenaSoloNumeros = false;

        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(texto);

        if (matcher.find() == true) {
            cadenaSoloNumeros = true;
        }
        return cadenaSoloNumeros;
    }
    
     public static boolean validarSoloLetras(String texto) {
        boolean cadenaSoloLetras = false;

        Pattern pattern = Pattern.compile("^[A-Z][a-z]\\s*$");
        Matcher matcher = pattern.matcher(texto);

        if (matcher.find() == true) {
            cadenaSoloLetras = true;
        }
        return cadenaSoloLetras;
    }
}
