
package Laboratorio4;


public class NodoPila {
  //atributos
  String nombre;
  NodoPila siguiente;
  
 //constructor 
public NodoPila(){
   nombre="";
   siguiente = null; 
}  
  //metodos get y set
   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public NodoPila getSiguiente() {
      return siguiente;
   }

   public void setSiguiente(NodoPila siguiente) {
      this.siguiente = siguiente;
   }

    
}
