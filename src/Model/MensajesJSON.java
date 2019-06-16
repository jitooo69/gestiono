/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacion;

/**
 * Clase para la comunicación entre la app Cliente y la app Servidor.
 * 
 * @author Equipo Gestiono
 * 
 * @since 20/05/2019
 * @version 1 - Definición de los identificadores de mensajes que hacen que cliente
 * y servidor sepan qué se están enviando mutuamente.
 */
public interface MensajesJSON {
    
    /*
    * Declaración del tipo de mensajes que se van a construir.
    */
    public static final String REGISTRO = "REGISTRO";
    public static final String LOGIN = "LOGIN";
    public static final String RECUPERAR_CLAVE_ACCESO = "RECUPERAR_CLAVE_ACCESO";
    public static final String INICIAR_TRAMITE = "INICIAR_TRAMITE";
    public static final String REGISTRAR_EXPEDIENTE = "REGISTRAR_EXPEDIENTE";
    public static final String LISTAR_TRAMITES = "LISTAR_TRAMITES";
    public static final String LISTAR_EXPEDIENTES = "LISTAR_EXPEDIENTES";
}
