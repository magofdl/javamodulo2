/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaz;

/**
 *
 * @author CEC
 */
public class ResultadoLectura {
    private String contenido;
    private boolean lecturaCorrecta;

    public ResultadoLectura() {
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * @return the lecturaCorrecta
     */
    public boolean isLecturaCorrecta() {
        return lecturaCorrecta;
    }

    /**
     * @param lecturaCorrecta the lecturaCorrecta to set
     */
    public void setLecturaCorrecta(boolean lecturaCorrecta) {
        this.lecturaCorrecta = lecturaCorrecta;
    }
    
    
}
