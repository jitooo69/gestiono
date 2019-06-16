/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.TimeLimitExceededException;

/**
 *
 * @author jorgearanda
 */
public class Conexion {
    
    private Socket clienteSocket, socket;
    private PrintWriter out;
    private String hostname;
    private int puerto;
    private boolean conectado;
    private BufferedReader in;
    InputStreamReader isr;
    
    
    public Conexion() {
        conectado = false;
        hostname = "192.168.1.107";
        puerto = 4444;
        socket = new Socket();
            
        /*try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/
        System.out.println("Conectando... "+hostname+":"+puerto);
        try {
            
            socket.connect(new InetSocketAddress(hostname, puerto), 1000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            
            conectado = true;
            System.out.println("Conectado");
        } catch (IOException e) {
            System.out.println("No conectado");
            //e.printStackTrace();
        }
    }
    
    public boolean enviar(String gson) {
        out.println(gson);
        return true;
    }
    
    public String respuesta(){
        try {
            return in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean estado() {
        return conectado;
    }
}
