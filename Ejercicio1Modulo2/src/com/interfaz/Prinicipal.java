/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaz;

import com.negocio.OperacionesArchivo;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FDL
 */
public class Prinicipal {

    public static void main(String[] args) {

//        ResultadoLectura resultadoLectura = OperacionesUsuario.leerTeclado("Ingrese el path del archivo:");
//        if (resultadoLectura.isLecturaCorrecta()) {
//            List<String> listaAtributos = OperacionesArchivo.calcularAtributosArchivo(resultadoLectura.getContenido());
//            if (listaAtributos!=null) {
//                System.out.println(listaAtributos);
//            }
//            else{
//                System.err.println("No se encontró el archivo");
//            }       
//        }
//        else{
//            System.err.println("Ocurrio un error");
//        }
//        ResultadoLectura resultadoLectura = OperacionesUsuario.leerTeclado("Ingrese el path del directorio:");
//        
//        if (resultadoLectura.isLecturaCorrecta()) {
//            List<String> listaContenido = OperacionesArchivo.listarContenidoDirectorio(resultadoLectura.getContenido(),"\t");
//            if (listaContenido!=null) {
////                System.out.println(listaContenido);
//                
//                for (String aux : listaContenido) {
//                    System.out.print(aux);
//                }
//                System.out.print("\n");
//            }
//            else{
//                System.err.println("No se encontró el archivo");
//            }       
//        }
//        try {
//            ResultadoLectura resultadoLectura = OperacionesUsuario.leerTeclado("Ingrese el path del archivo a leer:");
//            if (resultadoLectura.isLecturaCorrecta()) {
//
//                String contenidoArchivo = OperacionesArchivo.leerArchivo(resultadoLectura.getContenido());
//                if (contenidoArchivo!=null) {
//                    System.out.println(contenidoArchivo);
//                }
//                else{
//                System.err.println("No se encontró el archivo");
//            } 
//
//            } else {
//                System.err.println("Ocurrio un error al leer el teclado");
//            }
//
//        } catch (IOException ex) {
//            Logger.getLogger(Prinicipal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            ResultadoLectura resultadoLecturaPath = OperacionesUsuario.leerTeclado("Ingrese el path del archivo a escribir:");
//            if (resultadoLecturaPath.isLecturaCorrecta()) {
//                ResultadoLectura resultadoLecturaContenido = OperacionesUsuario.leerTeclado("Ingrese texto a escribir:");
//                if (resultadoLecturaContenido.isLecturaCorrecta()) {
//                    OperacionesArchivo.escribirArchivo(resultadoLecturaPath.getContenido(), resultadoLecturaContenido.getContenido());
//                }
//            }
//        } catch (Exception ex) {
//             Logger.getLogger(Prinicipal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        ResultadoLectura resultadoLecturaPath = OperacionesUsuario.leerTeclado("Ingrese el path del archivo a eliminar:");
//        if (resultadoLecturaPath.isLecturaCorrecta()) {
//            boolean archivoEliminado=OperacionesArchivo.eliminarArchivo(resultadoLecturaPath.getContenido());
//            if (archivoEliminado) {
//                System.out.println("Archivo eliminado");
//            }
//            else{
//                System.err.println("No se pudo eliminar el archivo");
//            }
//        }
        ResultadoLectura resultadoLecturaPath = OperacionesUsuario.leerTeclado("Ingrese el path del archivo a renombrar:");
        if (resultadoLecturaPath.isLecturaCorrecta()) {

            ResultadoLectura resultadoLecturaNombre = OperacionesUsuario.leerTeclado("Ingrese el nuevo nombre de archivo:");

            if (resultadoLecturaNombre.isLecturaCorrecta()) {
                boolean archivoRenombrado = OperacionesArchivo.renombrarArchivo(resultadoLecturaPath.getContenido(),resultadoLecturaNombre.getContenido());
                if (archivoRenombrado) {
                    System.out.println("Archivo renombrado");
                } else {
                    System.err.println("No se pudo renombrar el archivo");
                }
            }

        }
    }
}
