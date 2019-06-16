/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author jorgearanda
 */
public interface OyenteVista {

    public enum Evento {
        LOGIN, PANTALLA_LOGIN, REGISTRO, NUEVO_REGISTRO_USUARIO, CERRAR_SESION, REGISTRAR_TRAMITE, VER_TRAMITES, VER_EXPEDIENTES, EXIT
    }
    
    public void notificacion(Evento evento, Object obj);

}
