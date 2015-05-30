/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio;

import com.datos.MySqlConnect;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FDL
 */
public class GestionEmpleados {

    public static ResultSet invocarProcedimientoBusqueda(String parametro, String[] argumentos) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String nombreSP = "";

        if (parametro.equalsIgnoreCase("c")) {
            nombreSP = OperacionesArchivo.leerPropiedad("empleado.sp1");
        } else if (parametro.equalsIgnoreCase("n")) {
            nombreSP = OperacionesArchivo.leerPropiedad("empleado.sp2");
        } else if (parametro.equalsIgnoreCase("a")) {
            nombreSP = OperacionesArchivo.leerPropiedad("empleado.sp3");
        }
        else if (parametro.equalsIgnoreCase("t")) {
            nombreSP = OperacionesArchivo.leerPropiedad("empleado.sp5");
        }

        MySqlConnect mySqlConnect = null;
        ResultSet resultado;
        mySqlConnect = new MySqlConnect();
        mySqlConnect.ejecturarConexionDB();
        resultado = mySqlConnect.ejecutarSpConsulta(argumentos, nombreSP);

        return resultado;
    }

    public static void ingresarEmpleado(String[] argumentos) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String nombreSPIngreso = "";
        nombreSPIngreso = OperacionesArchivo.leerPropiedad("empleado.sp0");
        MySqlConnect mySqlConnect = null;
        ResultSet resultado;
        mySqlConnect = new MySqlConnect();
        mySqlConnect.ejecturarConexionDB();
        mySqlConnect.ejecutarSP(argumentos, nombreSPIngreso);
    }
    
        public static void actualizarEmpleado(String[] argumentos) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String nombreSPIngreso = "";
        nombreSPIngreso = OperacionesArchivo.leerPropiedad("empleado.sp4");
        MySqlConnect mySqlConnect = null;
        ResultSet resultado;
        mySqlConnect = new MySqlConnect();
        mySqlConnect.ejecturarConexionDB();
        mySqlConnect.ejecutarSP(argumentos, nombreSPIngreso);
    }
}
