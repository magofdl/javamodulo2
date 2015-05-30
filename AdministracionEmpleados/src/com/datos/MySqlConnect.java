/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos;

import com.negocio.OperacionesArchivo;
import com.utilidades.Constantes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

        String usuarioBase = OperacionesArchivo.leerPropiedad(Constantes.USUARIO_BASE_MYSQL_KEY);
        String claveBase = OperacionesArchivo.leerPropiedad(Constantes.CLAVE_BASE_MYSQL_KEY);
        String urlBase = OperacionesArchivo.leerPropiedad(Constantes.URL_BASE_MYSQL_KEY);
        String nombreBase = OperacionesArchivo.leerPropiedad(Constantes.NOMBRE_BASE_MYSQL_KEY);
        String driverBase = OperacionesArchivo.leerPropiedad(Constantes.DRIVER_BASE_MYSQL_KEY);

        Class.forName(driverBase).newInstance();

        this.setConexion((Connection) DriverManager.getConnection(urlBase + nombreBase, usuarioBase, claveBase));
    }

    public void ejecutarSP(String[] args, String storeName) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String call;
        if (args == null) {
            call = "{ call " + storeName + " }";
        } else {
            call = "{ call " + storeName + "(";
            int tamanio = args.length;
            for (int i = 0; i < tamanio; i++) {
                if (i == tamanio - 1) {
                    call = call.concat("?)}");
                } else {
                    call = call.concat("?,");
                }
            }
        }

        CallableStatement stmt = this.getConexion().prepareCall(call);

        if (args != null) {
            int tamanio = args.length;
            for (int i = 0; i < tamanio; i++) {
                stmt.setString(i + 1, args[i]);
            }
        }

        stmt.execute();
        stmt.close();
    }

    public ResultSet ejecutarSpConsulta(String[] args, String store_name) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String call;
        if (args == null) {
            call = "{ call " + store_name + " }";
        } else {
            call = "{ call " + store_name + "(";
            int tamanio = args.length;
            for (int i = 0; i < tamanio; i++) {
                if (i == tamanio - 1) {
                    call = call.concat("?)}");
                } else {
                    call = call.concat("?,");
                }
            }
        }
        CallableStatement cs = conexion.prepareCall(call);
        if (args != null) {
            int tamanio = args.length;
            for (int i = 0; i < tamanio; i++) {
                cs.setString(i + 1, args[i]);
            }
        }

        ResultSet resultado = cs.executeQuery();
        return resultado;
    }

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

}
