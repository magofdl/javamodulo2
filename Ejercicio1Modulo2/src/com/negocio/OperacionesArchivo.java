/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FDL
 */
public class OperacionesArchivo {

    /**
     * Permite obtener los atributos de un archivo dado su ruta. Los atributos
     * se devuelven en una lista
     *
     * @param path Ruta del archivo
     * @return Lista de atributos del archivo, si no existe el archivo se
     * retorna null
     */
    public static List<String> calcularAtributosArchivo(String path) {
        File file1 = new File(path);

        if (file1.exists()) {
            long tamanioArchivoEnBytes = file1.length();
            long tamanioArchivoEnKB = tamanioArchivoEnBytes / 1024;
            long tamanioArchivoEnMB = tamanioArchivoEnKB / 1024;
            long fechaUltimaModificacion = file1.lastModified();
            Date fecha = new Date(fechaUltimaModificacion);
            SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = dateformat1.format(fecha);
            boolean permisoEscritura = file1.canWrite();
            boolean permisoLectura = file1.canRead();

            List<String> listaAtributos = new ArrayList<>();

            listaAtributos.add("Tamaño en KB: " + String.valueOf(tamanioArchivoEnKB));
            listaAtributos.add("Tamaño en MB: " + String.valueOf(tamanioArchivoEnMB));
            listaAtributos.add("Última modificación: " + String.valueOf(fechaFormateada));
            listaAtributos.add("Tiene permiso escritura: " + String.valueOf(permisoEscritura));
            listaAtributos.add("Tiene permiso lectura: " + String.valueOf(permisoLectura));

            return listaAtributos;
        }
        return null;
    }

    /**
     * Permite obtener el contendio de un directorio dado su ruta. El contenido
     * se devuelve en una lista
     *
     * @param path Ruta del directorio
     * @return Lista de contenidos del direcotrio, si no existe el directorio se
     * retorna null
     */
    public static List<String> listarContenidoDirectorio(String path, String tabs) {
        File file1 = new File(path);

        List<String> listaContenido = new ArrayList<>();

        if (file1.exists()) {

            if (file1.isDirectory()) {

                listaContenido.add("\n" + tabs + file1.getName() + " (directorio)");

                File[] listaFicheros = file1.listFiles();

                for (File fichero : listaFicheros) {

                    if (fichero.isDirectory()) {
                        String tabAux = "\t" + tabs;
                        List<String> listaContenidoAux = listarContenidoDirectorio(fichero.getPath(), tabAux);
                        List<String> listaContenidoAux2 = new ArrayList<>();
                        for (String valorAux : listaContenidoAux) {
                            listaContenidoAux2.add(tabAux + valorAux);
                        }
                        listaContenido.addAll(listaContenidoAux2);
                    } else {
                        String tabAux = "\t" + tabs;
                        listaContenido.add("\n" + tabAux + fichero.getName() + " (archivo)");
                    }
                }
            }
//             else{
//                 listaContenido.add("\n"+file1.getName()+" (archivo)");
//             }
        }
        return listaContenido;
    }

    /**
     * Permite obtener el contendio de un archivo.
     *
     * @param path Ruta del archivo
     * @return Contenido del archivo. Si no se ecuentra el archivo se retorna
     * null
     * @throws FileNotFoundException, IOException
     */
    public static String leerArchivo(String path) throws FileNotFoundException, IOException {
        File file = new File(path);
        String contenidoArchivo = "";
        FileReader fileReader = null;
        try {
            if (file.exists()) {
                if (file.isDirectory() == false) {

                    fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    //lectura del archivo
                    String linea;
                    while ((linea = bufferedReader.readLine()) != null) {
                        contenidoArchivo = contenidoArchivo + linea + "\n";
                    }
                    fileReader.close();
                }
            } else {
                return null;
            }

        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
        return contenidoArchivo;
    }

    /**
     * Permite escribir al final de un archivo.
     *
     * @param path Ruta del archivo
     * @param contenido Texto que se desea escribir
     * @throws IOException
     */
    public static void escribirArchivo(String path, String contenido) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = null;

        try {
            if (file.exists()) {
                if (file.isDirectory() == false) {
                    fileWriter = new FileWriter(file, true);
                    PrintWriter printWiter = new PrintWriter(fileWriter);
                    printWiter.println(contenido);
                    fileWriter.close();
                }
            }
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
