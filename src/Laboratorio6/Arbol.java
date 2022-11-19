
package Laboratorio6;

import java.awt.Graphics;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Arbol {
    
    //public Nodo APNODO ;//= new Nodo("",null,null);
    public static String cadena_pre = "", cadena_in = "", cadena_pos = "";
    
    /*
    Para insertar los nodos se piden los valores de estos preguntaod si existe por derecha e izquierda
    y pidiendo sus valores
    */
    public static void insertar(Nodo APNODO){
        
        String opc;
         
        APNODO.dato = JOptionPane.showInputDialog("Ingrese el valor de la raiz");
        
        opc = JOptionPane.showInputDialog("Existe nodo por la izquierda " + APNODO.dato + "si o no");
        
        if (opc.equalsIgnoreCase("si"))
        {
             /*
            usamos un nodo temporal y le pasamos como primer parámetro del constructor el valor que ingresó
            el susuario para el nuevo nodo, luego en el noodo en el que estamos trabajando le damos el valor 
            de temporal para que almacene ese dato en los nodos de izquierda
            */
            Nodo temporal = new Nodo(APNODO.dato,null,null);
            APNODO.izquierda = temporal;
            //usamos recursividad para seguir pidiendo datos hasta que el usuario decida
            insertar(APNODO.izquierda);
        }
        else
        {
            APNODO.derecha = null;
        }
        
        opc = JOptionPane.showInputDialog("Existe nodo por la derecha (si o no)");
        
        if (opc.equalsIgnoreCase("si"))
        {
            Nodo temporal = new Nodo(APNODO.dato,null,null);
            APNODO.derecha = temporal;
            insertar(APNODO.derecha);
        }
        else
        {
            APNODO.izquierda = null;
        } 
    }
    
    /**Esta funcion sirve par contar la cantidad de nodos, la usaremos para la funcion pintar de la clase graficar
     * para poder graficar el árbol
     * 
     * @param APNODO nodo en el que estamos almacenando
     * @return la cantidad de nodos 
     */
    public static int nodosCompletos(Nodo APNODO) {
        if (APNODO == null)
            return 0;
        else {
            if (APNODO.izquierda != null && APNODO.derecha != null)
                return nodosCompletos(APNODO.izquierda) + nodosCompletos(APNODO.derecha) + 1;
            return nodosCompletos(APNODO.izquierda) + nodosCompletos(APNODO.derecha);
        }
    }
    
    public static String PreOrden(Nodo APNODO)
    {
        
        if (APNODO != null)
        {
            cadena_pre += APNODO.dato;
            PreOrden(APNODO.izquierda);
            PreOrden(APNODO.derecha);
        }
        
        return cadena_pre;
    }
    
    public static String InOrden(Nodo APNODO)
    {
        if (APNODO != null)
        {
            InOrden(APNODO.izquierda);
            cadena_in += APNODO.dato;
            InOrden(APNODO.derecha);
        }
        
        return cadena_in;
    }
    
    public static String PosOrden(Nodo APNODO)
    {
        if (APNODO != null)
        {
            PosOrden(APNODO.izquierda);
            PosOrden(APNODO.derecha);
            cadena_pos += APNODO.dato;
        }
        
        return cadena_pos;
    }
    
    
    
}
