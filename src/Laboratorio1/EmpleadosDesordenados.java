package Laboratorio1;

 //@author HP
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaDouble;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaInt;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaOpc;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaTexto;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaTexto01;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class EmpleadosDesordenados {

    public static int Busca(String nomA[], String nomB, int n) {
        int i = 0;
        while ((i < n) && (nomA[i].compareTo(nomB) < 0)) {
            i++;
        }

        if ((i > n) && (nomA[i].compareTo(nomB) < 0)) {
            return (-1);
        } else {
            return (i);

        }
    }
    
    public  static int InsertarEmpleados (String nombres[], Integer edades[], String sexos[], int n, int tam)
    {
        if (n == -1) 
        {
            
            n++;
            
            if (!ValidarJOption_ParaTexto(nombres,n,"Ingrese el nombre del nuevo empleado") 
                || !ValidarJOption_ParaInt(edades, n, "Ingrese la edad del empleado")
                || !ValidarJOption_ParaTexto(sexos, n, "Ingrese el sexo del empleado"))
            {
                n--;
                for (int i = 0; i <= n; i++) {
                    nombres[i] = nombres[i + 1];
                    edades[i] = edades[i + 1];
                    sexos[i] = sexos[i + 1];
                }
            }  
             
        }
        else if (n < (tam - 1))
        {
            String nombreBus = ValidarJOption_ParaTexto01("Ingrese el nombre completo del  empleado"); // se buscara el nombre del empleado en el arreglo para comprobar si ya existe en el 
            
            if (nombreBus != null)
            {
                int pos = Busca(nombres, nombreBus, n); // busca si el empleado ya existe en el arreglo mediante nombreBus

                if (pos == 0 && (nombreBus.equalsIgnoreCase(nombres[0]))) 
                {
                    JOptionPane.showMessageDialog(null, nombreBus + " ya existe dentro de los registros");
                } 
                else 
                {
                    n = n + 1;
                    pos = pos * (-1);
                    for (int i = n; i >= (pos + 1); i--) {
                        nombres[i] = nombres[i - 1];
                        edades[i] = edades[i - 1];
                        sexos[i] = sexos[i - 1];
                    }
                    
                    nombres[pos] = nombreBus;
                    
                    if (!ValidarJOption_ParaInt(edades, pos, "Ingrese la edad de " + nombreBus) ||
                        !ValidarJOption_ParaTexto(sexos, pos, "Ingrese el sexo"))
                    {
                        n--;
                        for (int i = n; i <= pos/-1; i++) {
                            nombres[i] = nombres[i + 1];
                            edades[i] = edades[i + 1];
                            sexos[i] = sexos[i + 1];
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Insercion realizada");
                    }
 
                }
            }
            
        }
        
        return n;
    }
    
    public static int EliminarEmpleados (String nombres[], Integer edades[], String sexos[], int n, int tam) {

        if (n > -1) 
        {
            String nombreBus = ValidarJOption_ParaTexto01("Ingrese el nombre del empleado que desea eliminar");
            
            if (nombreBus != null)
            {
                int pos = Busca(nombres, nombreBus, n);

                if ((pos < 0) || (!nombreBus.equalsIgnoreCase(nombres[pos]))) 
                {
                    JOptionPane.showMessageDialog(null, nombreBus + " no existe");
                } else {
                    n = n - 1;
                    for (int i = pos; i <= n; i++) {
                        nombres[i] = nombres[i + 1];
                        edades[i] = edades[i + 1];
                        sexos[i] = sexos[i + 1];
                    }
                    JOptionPane.showMessageDialog(null, "Eliminacion realizada");
                }
                
            }
 
        } else {
            JOptionPane.showMessageDialog(null, "Arreglo vacio");
        }

        return n;
    }
    
    public static void ModificarEmpleados (String nombres[], Integer edades[], String sexos[], int n, int tam){
        
        if( n > -1)
        {
            String nombreBus= ValidarJOption_ParaTexto01("Ingrese el nombre del empleadp cuya edad sera actualizada");
            
            if (nombreBus != null)
            {
                int pos = Busca(nombres, nombreBus, n);

                if ((pos < 0) || (!nombreBus.equalsIgnoreCase(nombres[pos])))
                    JOptionPane.showMessageDialog(null, nombreBus + " no existe");
                else {
                    edades[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de " + nombreBus));
                    JOptionPane.showMessageDialog(null, "Actualizacion realizada");
                }
            }            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Arreglo vacio");
        }
    }
    
    public static void ListarMasculinos(String nombres[], Integer edades[], String sexos[], int n, int tam){
        
        if(n > -1){
            
            for (int pos = 0; pos < tam; pos++) {
                if (sexos[pos].compareTo("masculino") >= 0) {
                    JOptionPane.showMessageDialog(null, "\n\nNombre del empleado: " + nombres[pos] + "\nedad: " + edades[pos]+"\nSexo: " + sexos[pos]+"");
                }
            }
        }else{
        JOptionPane.showMessageDialog(null, "Arreglo vacio");
        }
    }
  
    public static void ListarEmpleado (String nombres[], Integer edades[], String sexos[], int n, int tam)
    {   
        if( n > -1)
        {
            String nombreBus= ValidarJOption_ParaTexto01("Ingrese el nombre del empleado para visualizar su registro");
            
            if (nombreBus != null)
            {
                int pos = Busca(nombres, nombreBus, n);
                
                if ((!nombreBus.equalsIgnoreCase(nombres[0])) || (pos < 0))
                    JOptionPane.showMessageDialog(null, nombreBus + " no existe");
                else {
                    JOptionPane.showMessageDialog(null, "Nombre del empleado: " + nombres[pos] + "\nEdad: " + edades[pos] + "\nSexo: " + sexos[pos] + "");
                }
            }    
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Arreglo vacio");
        }
    }//fin ListarEmpleado
    
}
