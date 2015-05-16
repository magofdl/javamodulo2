/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaz;

import com.datos.MySqlConnect;
import com.negocio.Cliente;
import com.negocio.OperacionesArchivo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
//        ResultadoLectura resultadoLecturaPath = OperacionesUsuario.leerTeclado("Ingrese el path del archivo a renombrar:");
//        if (resultadoLecturaPath.isLecturaCorrecta()) {
//            ResultadoLectura resultadoLecturaNombre = OperacionesUsuario.leerTeclado("Ingrese el nuevo nombre de archivo:");
//            if (resultadoLecturaNombre.isLecturaCorrecta()) {
//                boolean archivoRenombrado = OperacionesArchivo.renombrarArchivo(resultadoLecturaPath.getContenido(),resultadoLecturaNombre.getContenido());
//                if (archivoRenombrado) {
//                    System.out.println("Archivo renombrado");
//                } else {
//                    System.err.println("No se pudo renombrar el archivo");
//                }
//            }
//        }
//        try {
//            ResultadoLectura resultadoLecturaPath = OperacionesUsuario.leerTeclado("Ingrese el path del archivo a procesar:");
//            if (resultadoLecturaPath.isLecturaCorrecta()) {
//                Date date = new Date();
//                System.out.println("Inicio :" + date);
//                ArrayList<Cliente> listaClientes = OperacionesArchivo.procesarArchivoClientes(resultadoLecturaPath.getContenido());
//                date = new Date();
//                System.out.println("Fin :" + date);
//                if (listaClientes.size() > 0) {
//                    System.out.println("Clientes encontrados: \n" + listaClientes.get(listaClientes.size()-1));
//                } else {
//                    System.err.println("No se encontraron clientes");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            ResultadoLectura resultadoLectura = OperacionesUsuario.leerTeclado("Ingrese el key:");
//            if (resultadoLectura.isLecturaCorrecta()) {
//                String valorPropiedad = OperacionesArchivo.leerPropiedad(resultadoLectura.getContenido());
//                if (valorPropiedad!=null) {
//                    System.out.println("Valor propiedad: " + valorPropiedad);
//                }
//                else{
//                      System.err.println("No se encontró la propiedad");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        MySqlConnect mySqlConnect = new MySqlConnect();

        try {
            mySqlConnect.ejecturarConexionDB();
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("InstantiationException");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("IllegalAccessException");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQLException");
            e.printStackTrace();
        }

    }
}
