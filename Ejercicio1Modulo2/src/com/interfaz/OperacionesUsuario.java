/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaz;

import com.utilidades.constantes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author FDL
 * @version 1.0.0
 */
public class OperacionesUsuario {
    
    /**
     * Permite leer datos desde el teclado
     * @param mensaje Texto para mostrar al usuario sobre lo que se solicita que ingrese
     * @return Devuelve el resultado de la lectura y su contenido
     */
    public static  ResultadoLectura leerTeclado (String mensaje){
        try{
            System.out.println(mensaje);
            InputStreamReader stremReader = new InputStreamReader(System.in);//abre el flujo
            BufferedReader buffer = new BufferedReader(stremReader);//buffer de lectura
            String valorLeido=buffer.readLine();//leer lo tecleado
            ResultadoLectura resultadoLectura = new ResultadoLectura(valorLeido, true);
            return resultadoLectura;
        } 
        catch(IOException ex){
//            ex.printStackTrace();
            System.out.println("Error al leer teclado: " + ex.getLocalizedMessage());
            ResultadoLectura resultadoLectura = new ResultadoLectura(constantes.ERROR_INGRESO_DATOS, false);
            return resultadoLectura;
        }
        catch(Exception ex){
//            ex.printStackTrace();
            System.out.println("Error al leer teclado ex: " + ex.getLocalizedMessage());
            ResultadoLectura resultadoLectura = new ResultadoLectura(constantes.ERROR_INGRESO_DATOS, false);
            return resultadoLectura;
        }
    }
}
