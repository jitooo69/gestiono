/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 * Clase representativa de 'Trámite'
 * 
 * @author Equipo Gestiono
 * 
 * @since 05/06/2019
 * @version 1 - Definición
 */
public class Tramite {
    
    private int id_tramite;
    private String dni_ciudadano;
    private String asunto;
    private String descripcion;
    private String departamento;
    private String fecha;
    private int asignado;
    private String[] adjuntos;
    private int estado;
    
    public Tramite(int id_tramite, String dni_ciudadano, String asunto, String descripcion, String departamento,
            String fecha, int asignado, String[] adjuntos) {
        this.id_tramite = id_tramite;
        this.dni_ciudadano = dni_ciudadano;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.departamento = departamento;
        this.fecha = fecha;
        this.asignado = asignado;
        this.adjuntos = adjuntos;
        estado = 0;
    }

    public Tramite(int id_tramite, String asunto, String departamento,
            String fecha, int asignado) {
        this.id_tramite = id_tramite;
        this.asunto = asunto;
        this.departamento = departamento;
        this.fecha = fecha;
        this.asignado = asignado;
    }
    public int getId_tramite() {
        return id_tramite;
    }
    
    public int getEstado(){
        return estado;
    }
    public String getDniCiudadano() {
        return dni_ciudadano;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getFecha() {
        return fecha;
    }

    public int getAsignado() {
        return asignado;
    }
    
    public String getAdjunto(int i) {
        return adjuntos[i];
    }
}
