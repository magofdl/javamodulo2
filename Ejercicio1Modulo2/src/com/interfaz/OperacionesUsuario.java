/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author CEC
 */
public class OperacionesUsuario {
    
    public  static ResultadoLectura leerTeclado(String mensaje) {
        ResultadoLectura resultadoLetura= new ResultadoLectura();
            try {
                System.out.println(mensaje);
                InputStreamReader streamReader = new InputStreamReader(System.in);
                BufferedReader buffer = new BufferedReader(streamReader);
                resultadoLetura.setContenido(buffer.readLine());
                resultadoLetura.setLecturaCorrecta(true);
            } catch (Exception e) {
                e.printStackTrace();
                resultadoLetura.setContenido("ERROR");
                resultadoLetura.setLecturaCorrecta(false);
            }
            return resultadoLetura;
    }
}
