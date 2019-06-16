package Model;

public class Usuario {

    private String DNI, nombre, apellidos, contrasenya, email;
    private int tipo;

//Constructor FUNCIONARIO
    public Usuario(String nombre, String apellidos, String DNI, String contrasenya, String email, int tipo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipo = tipo;
        this.contrasenya = contrasenya;
        this.email = email;
        tipo = 0;
    }

//Constructor CIUDADANO
    public Usuario(String nombre, String apellidos, String DNI, String contrasenya, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenya = contrasenya;
        this.email = email;
        tipo = 1;
    }
    
    public Usuario(String DNI, String contrasenya, int tipo) {
    	this.DNI = DNI;
    	this.contrasenya = contrasenya;
    	this.tipo = tipo;
    }

    public String getDni() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public int getTipo() {
        return tipo;
    }
}
