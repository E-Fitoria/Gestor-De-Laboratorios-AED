package Laboratorio4;

public class Cola {

    NodoCola inicio, fin;
    int tam;

    public Cola() {
        inicio = fin = null;
        tam = 0;
    }
    
    public boolean Vacia(){
        return inicio == null;
    }
    
    public void Insertar(String ele){
        NodoCola nuevo = new NodoCola(ele);
        if (Vacia()) {
            inicio = nuevo;
        }else{
            fin.siguiente = nuevo;
        }
        
        fin = nuevo;
        tam++; //Inserta elemento de la cola
    }
    
    public String Quitar(){
        String aux = inicio.dato;
        inicio = inicio.siguiente;
        tam--; //quita un elemento de la cola
        return aux;
    }
    
    public String mostrarCola() {
        NodoCola aux = inicio;
        String cadena = "";

        while (aux != null) {
            cadena += aux.dato + "-";
            aux = aux.siguiente;
        }

      return cadena;
    } 
}
