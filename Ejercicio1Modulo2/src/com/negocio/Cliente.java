/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio;

/**
 *
 * @author FDL
 */
public class Cliente {
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String ciudadNacimiento;
    private String sexo;
    private String numeroCuenta;
    private String saldo;
    private String estadoCivil;

    public Cliente() {
    }

    
    
    public Cliente(String identificacion, String nombres, String apellidos, String ciudadNacimiento, String sexo, String numeroCuenta, String saldo, String estadoCivil) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ciudadNacimiento = ciudadNacimiento;
        this.sexo = sexo;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the ciudadNacimiento
     */
    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    /**
     * @param ciudadNacimiento the ciudadNacimiento to set
     */
    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * @return the saldo
     */
    public String getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    
//       private String identificacion;
//    private String nombres;
//    private String apellidos;
//    private String ciudadNacimiento;
//    private String sexo;
//    private String numeroCuenta;
//    private String saldo;
//    private String estadoCivil;
    @Override
    public String toString() {
        return "Identificacion: "+this.getIdentificacion()+"; Nombres:"+this.getNombres()+"; Apellidos: "+this.getApellidos()+"; Ciudad: "+this.getCiudadNacimiento()+"; Sexo: "+this.getSexo()+"; Cuenta: "+this.getNumeroCuenta()+"; Saldo: "+this.getSaldo()+"; Estado civil: "+this.getEstadoCivil(); 
   
    }
    
}
