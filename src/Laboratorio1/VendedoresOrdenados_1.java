
package Laboratorio1;

import javax.swing.JOptionPane;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaInt;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaTexto;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaTexto01;


/**
 *
 * @author Usuario
 */

public class VendedoresOrdenados_1 {
   
    public static int Busca(String nomA[], String nomB, int n) {
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

    public static int InsertarVendedor(String nombres[], Integer totales[], int n, int tam) {
        
        if (n == -1) {
            
            n++;
            
            if (!ValidarJOption_ParaTexto(nombres,n,"Ingrese el nombre del vendedor") 
                || !ValidarJOption_ParaInt(totales, n, "Ingrese las ventas"))
            {
                n--;
                for (int i = 0; i <= n; i++) {
                    nombres[i] = nombres[i + 1];
                    totales[i] = totales[i + 1];
                }
            }   
          
            
        } else if (n < (tam - 1)) {
            
            String nomB = ValidarJOption_ParaTexto01("Ingrese el nombre del vendedor");
            
            if (nomB != null)
            {
                int pos = Busca(nombres, nomB, n);
                
                if ((pos >= 0) && ((pos == 0) && (nomB.equalsIgnoreCase(nombres[0])))) {
                    JOptionPane.showMessageDialog(null, nomB + "Vendedor ya registrado");
                } else {
                    
                    n = n + 1;
                    pos = pos * (-1);
                    for (int i = n; i >= (pos + 1); i--) {
                        nombres[i] = nombres[i - 1];
                        totales[i] = totales[i - 1];
                    }

                    nombres[pos] = nomB;

                    if (!ValidarJOption_ParaInt(totales, pos, "Ingrese las ventas"))   
                    {
                        n--;
                        for (int i = n; i <= pos/-1; i++) {
                            nombres[i] = nombres[i + 1];
                            totales[i] = totales[i + 1];                          
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay espacio disponible");
            }
            
            }
 
        return n;
    }

    public static void ModifTotalVendedor(String nombres[], Integer totales[], int n) {
        if (n > -1) {
            String nomB = JOptionPane.showInputDialog("Ingrese el nombre del vendedor");
            
            if (nomB != null)
            {
                int pos = Busca(nombres, nomB, n);
                if ((pos < 0) || (!nomB.equalsIgnoreCase(nombres[pos]))) {
                    JOptionPane.showMessageDialog(null, nomB + " no existe");
                } else {
                    totales[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el total de ventas"));
                    JOptionPane.showMessageDialog(null, "Modificacion realizada");
                }
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Array vacio");
        }
    }

    public static void ImprimirVendedor(String nombres[], Integer totales[], int n) {
        if (n > -1) {
            String nomB = JOptionPane.showInputDialog("Ingrese el nombre del vendedor");
            int pos = Busca(nombres, nomB, n);
            if ((pos < 0) && (!nomB.equalsIgnoreCase(nombres[0]))) {
                JOptionPane.showMessageDialog(null, nomB + " no existe");
            } else
                JOptionPane.showMessageDialog(null, "Nombre del vendedor: " + nombres[pos] + "\nTotal de ventas: " + totales[pos]);
        }
        else
            JOptionPane.showMessageDialog(null, "Array vacio");
    }
    
     public static void OrdenarPorNombreVendedor(String nombres[], Integer totales[])
    {
        //Metodo  burbuja
        for (int k = 0; k < ((nombres.length) -1) ; k++){

            for (int j = 0; j <nombres.length - 1; j++){

                if (nombres[j].charAt(j) > nombres[j+1].charAt(j)){

                    String nomb = nombres[j];
                    Integer total = totales[j];

                    nombres[j] = nombres[j+1];
                    nombres[j+1] = nomb;

                    totales[j] = totales[j+1];
                    totales[j+1] = total;
                }

            }
        }//fin burbuja

    }
    
}
