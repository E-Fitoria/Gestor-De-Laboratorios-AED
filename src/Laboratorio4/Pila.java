
package Laboratorio4;

public class Pila {
   
   private NodoPila inicio;
   int tamanio;
   
   public Pila(){
   inicio = null;
   tamanio = 0;
  
}
   
 public boolean esVacia(){
    return inicio == null;
 }

  public int getTamanio(){
    return tamanio;
 }  
   
  //me permite agregar un objeto a la pila
   public void apilar(String nombre){
     NodoPila nuevo = new NodoPila();
     nuevo.setNombre(nombre);
       
     if (esVacia()) {
            inicio = nuevo;
        }else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        
        tamanio++;
    }  
  
   public void desapilar(){
        
       if (!esVacia()) { //verifica que la pila no este vacia
             inicio = inicio.getSiguiente();
             tamanio--;
         }
   }  
   //me permite mostrar todos los datos de la pila
   public String mostrarPila() {
        NodoPila aux = inicio;
        String cadena = "";

        while (aux != null) {
            cadena +=  aux.getNombre() + "-";
            //cadena += "{" + "\"Centro Comercial: \": " + aux.getNombre() + " }\n";
            aux = aux.getSiguiente();
        }

        //JOptionPane.showMessageDialog(null, cadena);
        return cadena;
    }  
  
}