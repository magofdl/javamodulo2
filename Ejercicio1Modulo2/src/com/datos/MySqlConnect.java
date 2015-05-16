/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos;

import com.negocio.OperacionesArchivo;
import com.utilidades.constantes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FDL
 */
public class MySqlConnect {

    private Connection conexion;

    public MySqlConnect() {
    }

    public void ejecturarConexionDB() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String usuarioBase=OperacionesArchivo.leerPropiedad(constantes.USUARIO_BASE_MYSQL_KEY);
        String claveBase=OperacionesArchivo.leerPropiedad(constantes.CLAVE_BASE_MYSQL_KEY);
        String urlBase=OperacionesArchivo.leerPropiedad(constantes.URL_BASE_MYSQL_KEY);
        String nombreBase=OperacionesArchivo.leerPropiedad(constantes.NOMBRE_BASE_MYSQL_KEY);
        String driverBase=OperacionesArchivo.leerPropiedad(constantes.DRIVER_BASE_MYSQL_KEY);
        
        Class.forName(driverBase).newInstance();
        
        this.conexion=(Connection) DriverManager.getConnection(urlBase+nombreBase, usuarioBase, claveBase);
    }
    
    

}
