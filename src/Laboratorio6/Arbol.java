
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
         
        APNODO.dato = JOptionPane.showInputDialog("Ingrese el valor");
        
        opc = JOptionPane.showInputDialog("Existe nodo por la izquierda (si o no)");
        
        if (opc.equalsIgnoreCase("si"))
        {
            Nodo temporal = new Nodo(APNODO.dato,null,null);
            APNODO.izquierda = temporal;
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
