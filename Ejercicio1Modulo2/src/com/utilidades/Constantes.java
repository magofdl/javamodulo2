/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

/**
 *
 * @author FDL
 * @version
 */
public class Constantes {

    public static final float PORCENTAJE_IESS = (float) 9.45;

    public enum diasSemana {

        LUNES,
        MARTES,
        MIERCOLES,
        JUEVES,
        VIERNES,
        SABADO,
        DOMINGO
    }
    public static final String ERROR_INGRESO_DATOS = "Ocurrio un error al leer el teclado";
    public static final short TAMANIO_NUMERO_CLIENTEs = 100;
    public static final String USUARIO_BASE_MYSQL_KEY = "usuario.basedatos";
    public static final String CLAVE_BASE_MYSQL_KEY = "clave.basedatos";
    public static final String DRIVER_BASE_MYSQL_KEY = "driver.basedatos";
    public static final String NOMBRE_BASE_MYSQL_KEY = "nombre.basedatos";
    public static final String URL_BASE_MYSQL_KEY = "url.basedatos";
    public static final String SP_INSERTAR_CLIENTE = "sp_insertarcliente";
}
