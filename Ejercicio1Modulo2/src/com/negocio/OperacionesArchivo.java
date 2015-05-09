/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FDL
 */
public class OperacionesArchivo {
    
    /*
    * Permite obtener los atributos de un archivo dado su ruta. Los atributos se devuelven en una lista
    * @param path Ruta del archivo
    * @return Lista de atributos del archivo, si no existe se retorna null
    */
    public static List<String> calcularAtributosArchivo(String path){
        File file1 = new File(path);
       
        if (file1.exists()) {
             long tamanioArchivoEnBytes=file1.length();
             long tamanioArchivoEnKB=tamanioArchivoEnBytes/1024;
             long tamanioArchivoEnMB=tamanioArchivoEnKB/1024;
             long fechaUltimaModificacion=file1.lastModified();
             Date fecha= new Date(fechaUltimaModificacion);
             SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
             String fechaFormateada=dateformat1.format(fecha);
             boolean permisoEscritura=file1.canWrite();
             boolean permisoLectura=file1.canRead();
             
             List<String> listaAtributos = new ArrayList<>();
             
             listaAtributos.add(String.valueOf(tamanioArchivoEnKB));
             listaAtributos.add(String.valueOf(tamanioArchivoEnMB));
             listaAtributos.add(String.valueOf(fechaFormateada));
             listaAtributos.add(String.valueOf(permisoEscritura));
             listaAtributos.add(String.valueOf(permisoLectura));
             
             return listaAtributos;
        }
        return null;
    }
            
}
