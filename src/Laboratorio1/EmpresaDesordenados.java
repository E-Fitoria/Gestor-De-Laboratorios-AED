package Laboratorio1;

import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaDouble;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaInt;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaOpc;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaTexto;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaTexto01;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class EmpresaDesordenados {

    public static int Busca(String nomA[], String nomB, int n){
        int i = 0;
        while((i < n) && (nomA[i].compareTo(nomB) < 0))
            i++;
        
        if ((i > n)  && (nomA[i].compareTo(nomB) < 0)) {
            return (-1);
        }else{
            return (i);
                
        }
    }
    
    public  static int InsertarClientes(String nombres[], Integer telefonos[], Double saldos[], Integer morosos[], int n, int tam){
        if (n == -1) 
        {
            
            n++;
            
            if (!ValidarJOption_ParaTexto(nombres,n,"Ingrese el nombre del Cliente") 
                || !ValidarJOption_ParaInt(telefonos, n, "Ingrese el numero de telefono\nSolo número")
                || !ValidarJOption_ParaDouble(saldos, n, "Ingrese el saldo del cliente")
                || !ValidarJOption_ParaOpc(morosos, n, "Debe?"))
            {
                n--;
                for (int i = 0; i <= n; i++) {
                    nombres[i] = nombres[i + 1];
                    telefonos[i] = telefonos[i + 1];
                    saldos[i] = saldos[i + 1];
                    morosos[i] = morosos[i + 1];
                }
            }  
            
        }
        else if(n < (tam - 1))
        {
            String nombreBus = ValidarJOption_ParaTexto01("Ingrese el nombre completo del nuevo"); // se buscara el nombre del cliente en el arreglo para comprobar si ya existe en el 
            
            if (nombreBus != null)
            {
                int pos = Busca(nombres, nombreBus, n); // busca si el cliente ya existe en el arreglo mediante nombreBus

                if (pos == 0 && (nombreBus.equalsIgnoreCase(nombres[0]))) {
                    JOptionPane.showMessageDialog(null, nombreBus + " ya existe");
                } 
                else 
                {
                    n = n + 1;
                    pos = pos * (-1);
                    
                    for (int i = n; i >= (pos + 1); i--) {
                        nombres[i] = nombres[i - 1];
                        telefonos[i] = telefonos[i - 1];
                        saldos[i] = saldos[i - 1];
                        morosos[i] = morosos[i - 1];
                    }

                    nombres[pos] = nombreBus;
                    
                    if (!ValidarJOption_ParaInt(telefonos, pos, "Ingrese el numeor de telefono\nSolo números") ||
                        !ValidarJOption_ParaDouble(saldos, pos, "Ingrese el saldo") ||
                        !ValidarJOption_ParaOpc(morosos, n, "Debe?"))
                    {
                        n--;
                        for (int i = n; i <= pos/-1; i++) {
                            nombres[i] = nombres[i + 1];
                            saldos[i] = saldos[i + 1];
                            telefonos[i] = telefonos[i + 1];
                            morosos[i] = morosos[i + 1];
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Insercion realizada");
                }
            }   
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No hay espacio disponible");
        }
        
        return n;
    }
    
    public static int EliminarCliente(String nombres[],Integer telefonos[], Double saldos[], Integer morosos[], int n, int tam){
       
        if(n > -1)
        {
            String nombreBus = ValidarJOption_ParaTexto01("Ingrese el nombre del cliente que desea eliminar");
            
            if (nombreBus != null)
            {
                int pos = Busca(nombres, nombreBus, n);

                if ((pos < 0) || (!nombreBus.equalsIgnoreCase(nombres[pos])))
                    JOptionPane.showMessageDialog(null, nombreBus + " no existe");
                else 
                {
                    n = n - 1;
                    
                    for (int i = pos; i <= n; i++) {
                        nombres[i] = nombres[i + 1];
                        telefonos[i] = telefonos[i + 1];
                        saldos[i] = saldos[i + 1];
                        morosos[i] = morosos[i + 1];
                    }
                    JOptionPane.showMessageDialog(null, "Eliminacion realizada");
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Arreglo vacio");
        
        return n;
    }
    
    public static void ModificarCliente(String nombres[], Integer telefonos[], Double saldos[], Integer morosos[], int n, int tam){
        
        if(n > -1)
        {
            String nombreBus = ValidarJOption_ParaTexto01("Ingrese el nombre del cliente cuyo estado moroso desea modificar");
            
            if (nombreBus != null)
            {
                int pos = Busca(nombres, nombreBus, n);

                if ((pos < 0) || (!nombreBus.equalsIgnoreCase(nombres[pos])))
                    JOptionPane.showMessageDialog(null, nombreBus + " no existe");
                else {
                    ValidarJOption_ParaOpc(morosos,n,"Debe?");
                    JOptionPane.showMessageDialog(null, "Modificacion realizada");
                }
            }
        }
        else
        {
        JOptionPane.showMessageDialog(null, "Arreglo vacio");
        }
    }
    
    public static void ListarCliente(String nombres[],Integer telefonos[], Double saldos[], Integer morosos[], int n, int tam){
        
        if(n > -1)
        {
            String nombreBus= ValidarJOption_ParaTexto01("Ingrese el nombre del cliente del que desea mostras sus datos");
            
            if (nombreBus != null)
            {
                int pos = Busca(nombres, nombreBus, n);
                if ((!nombreBus.equalsIgnoreCase(nombres[0])) || (pos < 0))
                    JOptionPane.showMessageDialog(null, nombreBus + " no existe");
                else 
                {
                    JOptionPane.showMessageDialog(null, "Nombre del cliente: " + nombres[pos] + "\nTelefono: " + telefonos[pos] + "\nSaldo: " + saldos[pos] + "\nEstado moroso: " + morosos[pos]);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Arreglo vacio");
        }
    }
    
}
