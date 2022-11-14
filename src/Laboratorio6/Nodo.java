package Laboratorio6;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Nodo {
    
    Object dato;
    Nodo izquierda, derecha;
    
    public Nodo(Object dato, Nodo izquierda, Nodo derecha)
    {
        this.dato = dato;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public Object getDato() {
        return dato;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

}
