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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;

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
     * Permite procesar el contendio de un archivo.
     *
     * @param path Ruta del archivo
     * @return Lista de clientes. Si no se ecuentra el archivo se retorna
     * null
     * @throws FileNotFoundException, IOException
     */
    public static ArrayList<Cliente> procesarArchivoClientes(String path) throws FileNotFoundException, IOException {
        File file = new File(path);
        String contenidoArchivo = "";
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        FileReader fileReader = null;
        try {
            if (file.exists()) {
                if (file.isDirectory() == false) {

                    fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    Scanner scanner = new Scanner("");
                    //lectura del archivo
                    String linea;
                    Cliente cliente = new Cliente();

                    while ((linea = bufferedReader.readLine()) != null) {
                        scanner = new Scanner(linea);
                        scanner.useDelimiter("\\s*,\\s*");
                        String[] myStringArray = new String[8];
                        int contador = 0;
                        
//                        StringTokenizer stringTokenizer = new StringTokenizer(linea, ",");
//                        while (stringTokenizer.hasMoreElements()) {
//                         myStringArray[contador] = stringTokenizer.nextElement().toString();
//                            contador++;
//                        }
 
//                        while (scanner.hasNext()) {
//                            myStringArray[contador] = scanner.next();
//                            contador++;
//                        }

                        myStringArray=linea.split(",");//mas rapido que el scanner y el StringTokenizer ya que no tiene loop
                        cliente.setIdentificacion(myStringArray[0]);
                        cliente.setNombres(myStringArray[1]);
                        cliente.setApellidos(myStringArray[2]);
                        cliente.setCiudadNacimiento(myStringArray[3]);
                        cliente.setSexo(myStringArray[4]);
                        cliente.setNumeroCuenta(myStringArray[5]);
                        cliente.setSaldo(myStringArray[6]);
                        cliente.setEstadoCivil(myStringArray[7]);

                        listaClientes.add(cliente);

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
        return listaClientes;
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

    /**
     * Permite eliminar un archivo.
     *
     * @param path Ruta del archivo
     * @return El estado de intentar eliminar el archivo
     */
    public static boolean eliminarArchivo(String path) {
        File originalfile = new File(path);
        if (originalfile.exists()) {
            if (originalfile.isDirectory() == false) {
                return originalfile.delete();
            }
        }
        return false;
    }

    /**
     * Permite renombrar un archivo.
     *
     * @param path Ruta del archivo
     * @param nuevoNombre Nuevo nombre del archivo
     * @return El estado de intentar renombrar el archivo
     */
    public static boolean renombrarArchivo(String path, String nuevoNombre) {
        File originalfile = new File(path);
        if (originalfile.exists()) {
            if (originalfile.isDirectory() == false) {
                String newFilePath = originalfile.getAbsolutePath().replace(originalfile.getName(), "") + nuevoNombre;
                File newfile = new File(newFilePath);
                return originalfile.renameTo(newfile);
            }
        }
        return false;
    }
    
    public static String leerPropiedad(String key){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Propiedades"); // Propiedades.properties
        if (resourceBundle.containsKey(key)) {
            return resourceBundle.getString(key);
        }
        return null;
    }
}
