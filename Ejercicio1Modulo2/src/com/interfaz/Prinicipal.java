/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaz;

import com.negocio.OperacionesArchivo;
import java.util.List;

/**
 *
 * @author FDL
 */
public class Prinicipal {

    public static void main(String[] args) {

        ResultadoLectura resultadoLectura = OperacionesUsuario.leerTeclado("Ingrese el path del archivo:");
        if (resultadoLectura.isLecturaCorrecta()) {
            List<String> listaAtributos = OperacionesArchivo.calcularAtributosArchivo(resultadoLectura.getContenido());
            System.out.println(listaAtributos);
        }
        else{
            System.err.println("Ocurrio un error");
        }

    }
}
