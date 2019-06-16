package Model;

import java.io.Serializable;

public class Contenedor implements Serializable{
  private Object elementos[];
  private int numElementos = 0;
  private int recorrido;
  
  public Contenedor(int capacidad) {
    elementos = new Object[capacidad];
  }
  
  public int numElementos() {
    return numElementos; 
  }
  
  public boolean introducir(Object elemento) {  
	int i = 0;
	
	// busca hueco libre
	while((i < elementos.length) && (elementos[i] != null))
	  i++;  
	  
    if (i < elementos.length) {
    	//Lo introduce
      elementos[i] = elemento;
      numElementos++;

      return true;
    } else
      return false;  
  }
            
  public void iniciarRecorrido() {
    recorrido = 0;
  }
  
  public boolean haySiguiente() {
	// salta los huecos libres
	while((recorrido < elementos.length) && 
	      (elementos[recorrido] == null))
	  recorrido++;  

    return (recorrido < elementos.length);
  }  
  
  public Object siguiente() {
	if (recorrido < elementos.length) {
      return elementos[recorrido++];  
    } else 
      return null;
  }
  
  public void eliminar() {
    elementos[recorrido - 1] = null;
    numElementos--;
  }
  public int getNumElementos(){
      return numElementos;
  }
}