/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jorgearanda
 */
public class Tupla<A, B, C, D, E, F, G> {
  public final A a;
  public final B b;
  public final C c;
  public final D d;
  public final E e;
  public final F f;
  public final G g;

  /**
   *  Construye una tupla
   *  
   */   
  public Tupla(A a, B b) { 
      this.a = a; 
      this.b = b; 
      this.c = null;
      this.d = null;
      this.e = null;
      this.f = null;
      this.g = null;
  }
  
    public Tupla(A a, B b, C c, D d) { 
      this.a = a; 
      this.b = b; 
      this.c = c;
      this.d = d;
      this.e = null;
      this.f = null;
      this.g = null;
  }
  
    public Tupla(A a, B b, C c, D d, E e) { 
      this.a = a; 
      this.b = b; 
      this.c = c;
      this.d = d;
      this.e = e;
      this.f = null;
      this.g = null;
  }
}  
