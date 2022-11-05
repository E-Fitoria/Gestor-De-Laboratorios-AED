package Laboratorio1;

import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaInt;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaTexto;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaTexto01;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
*/
public class EmpleadosOrdenado {
    
     public static int BuscaEmpleado(String nomA[], String nomB, int n) {
        int i = 0;
        while ((i <= n) && (nomA[i].compareTo(nomB) < 0)) {
            i++;
        }
        if ((i > n) || (nomA[i].compareTo(nomB) > 0)) {
            return (-i);
        } else {   
            return (i);
        }
    }

    public static int InsertarEmpleado(String nombres[], String direcciones[], Integer edades[], String sexos[], Integer antLaboral[], int n, int tam) {
        
        if (n == -1) {
            
            n++;
            
            if (!ValidarJOption_ParaTexto(nombres,n,"Ingrese el nombre del empleado") 
                || !ValidarJOption_ParaTexto(direcciones,n, "Ingrese la dirección del empleado")
                || !ValidarJOption_ParaInt(edades,n, "Ingrese la edad del empleado")
                || !ValidarJOption_ParaTexto(sexos,n,"Ingrese el sexo del empleado")
                || !ValidarJOption_ParaInt(antLaboral, n, "Ingrese los años de antigüedad"))
            {
                n--;
                for (int i = 0; i <= n; i++) {
                    nombres[i] = nombres[i + 1];
                    direcciones[i] = direcciones[i + 1];
                    edades[i] = edades[i + 1];
                    sexos[i] = sexos[i + 1];
                    antLaboral[i] = antLaboral [i + 1];
                }
            }   
            
        } else if (n < (tam - 1)) {
            
            String nomB = ValidarJOption_ParaTexto01("Ingrese el nombre del empleado");
        
            int pos = BuscaEmpleado(nombres, nomB, n);
            
            if ((pos >= 0) && ((pos == 0) && (nomB.equalsIgnoreCase(nombres[0])))) {
                JOptionPane.showMessageDialog(null,"El empleado " + nomB + " ya existe");
            } else {
                        n = n + 1;
                        pos = pos * (-1);
                        for (int i = n; i >= (pos + 1); i--) {
                            nombres[i] = nombres[i - 1];
                            direcciones[i] = direcciones[i - 1];
                            edades[i] = edades[i - 1];
                            sexos[i] = sexos[i - 1];
                            antLaboral[i] = antLaboral[i - 1];
                        }
                        
                        nombres[pos] = nomB;
                        
                        if (!ValidarJOption_ParaTexto(direcciones, pos, "Ingrese la dirección del empleado")
                            || !ValidarJOption_ParaInt(edades, pos, "Ingrese la edad del empleado")
                            || !ValidarJOption_ParaTexto(sexos, pos, "Ingrese el sexo del empleado")
                            || !ValidarJOption_ParaInt(antLaboral, pos, "Ingrese los años de antigüedad")) 
                        {
                            n--;
                            
                            for (int i = n; i <= pos/-1; i++) 
                            {
                                nombres[i] = nombres[i + 1];
                                direcciones[i] = direcciones[i + 1];
                                edades[i] = edades[i + 1];
                                sexos[i] = sexos[i + 1];
                                antLaboral[i] = antLaboral[i + 1];
                            }
                        }
                        else 
                        {
                            JOptionPane.showMessageDialog(null, "Información agregada");
                        }
           
                }
            } else {
            JOptionPane.showMessageDialog(null, "No hay espacio disponible");  
            }
 
        return n;
    }

    public static int EliminarEmpleado(String nombres[], String direcciones[], Integer edades[], String sexos[], Integer antLaboral[], int n) {
        
        if (n > -1) 
        {
            String nomB = ValidarJOption_ParaTexto01("Ingrese el nombre del empleado a eliminar");
            
            if (nomB != null)
            {
                int pos = BuscaEmpleado(nombres, nomB, n);
            
                if ((pos < 0) || (!nomB.equalsIgnoreCase(nombres[pos]))) {
                    JOptionPane.showMessageDialog(null, nomB + " no existe");
                } else
                        {
                            n = n - 1;
                            for (int i = pos; i <= n; i++) {
                                nombres[i] = nombres[i + 1];
                                direcciones[i] = direcciones[i + 1];
                                edades[i] = edades[i + 1];
                                sexos[i] = sexos[i + 1];
                                antLaboral[i] = antLaboral[i + 1];
                            }
                            JOptionPane.showMessageDialog(null, "Eliminacion realizada");
                    }
                }
  
        } else {
            JOptionPane.showMessageDialog(null, "Array vacio");
        }
        return n;
    }

    public static void ModifAntiguedad(String nombres[], String direcciones[], Integer edades[], String sexos[], Integer antLaboral[], int n) {
        
        if (n > -1) 
        {
            String nomB = ValidarJOption_ParaTexto01("Ingrese el nombre del empleado para modificar\n"
                                                     + "sus años de antigüedad");
            if (nomB != null)
            {
                int pos = BuscaEmpleado(nombres, nomB, n);
                if ((pos < 0) && (!nomB.equalsIgnoreCase(nombres[pos]))) 
                {
                    JOptionPane.showMessageDialog(null, nomB + " no existe");  
                }
                else
                {
                    antLaboral[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la antiguadad laboral"));
                    JOptionPane.showMessageDialog(null, "Modificacion realizada");
                }
            }   
        
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Array vacio");
        }
    }

    public static void ImprimirEmpleado(String nombres[], String direcciones[], Integer edades[], String sexos[], Integer antLaboral[], int n) {
        
        if (n > -1) 
        {
            String nomB = ValidarJOption_ParaTexto01("Ingrese el nombre del empleado para ver su información");
            
            if (nomB != null)
            {
                int pos = BuscaEmpleado(nombres, nomB, n);
                if ((pos < 0) && (!nomB.equalsIgnoreCase(nombres[0]))) 
                {
                    JOptionPane.showMessageDialog(null, nomB + " no existe");
                } 
                else
                {
                    JOptionPane.showMessageDialog(null, "Nombre del empleado: " + nombres[pos] + 
                            "\nDireccion del empleado: " + direcciones[pos] + 
                            "\nEdad del empleado: " + edades[pos] + 
                            "\nSexo del empleado: " + sexos[pos] + 
                            "\nAntiguedad laboral: " + antLaboral[pos]);
                }
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Array vacio");
        }
    }
    
    public static void OrdenarPorNombre(String nombres[], String direcciones[], Integer edades[], String sexos[], Integer antLaboral[])
    {
        //Metodo  burbuja
        for (int k = 0; k < ((nombres.length) -1) ; k++){
            for (int j = 0; j <nombres.length - 1; j++){

                if (nombres[j].charAt(j) > nombres[j+1].charAt(j)){
                    String nomb = nombres[j];
                    String direc = direcciones[j];
                    Integer edad = edades[j];
                    String sex = sexos[j];
                    Integer ant_lab = antLaboral[j];

                    nombres[j] = nombres[j+1];
                    nombres[j+1] = nomb;

                    direcciones[j] = direcciones[j+1];
                    direcciones[j+1] = direc;

                    edades[j] = edades[j+1];
                    edades[j+1] = edad;

                    sexos[j] = sexos[j+1];
                    sexos[j+1] = sex;

                    antLaboral[j] = antLaboral[j+1];
                    antLaboral[j+1] = ant_lab;
                }

            }
        }//fin burbuja
    }
}
