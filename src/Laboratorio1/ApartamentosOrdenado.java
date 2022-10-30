package Laboratorio1;

import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaInt;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaTexto;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaTexto01;
import javax.swing.JOptionPane;

public class ApartamentosOrdenado {

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

    public static int Insertar(String ubicaciones[], Integer extensiones[], Integer precios[], int n, int tam) {

        if (n == -1) 
        {
            n++;
        
            if (!ValidarJOption_ParaTexto(ubicaciones,n,"Ingrese la ubicacion del departamento") || !ValidarJOption_ParaInt(extensiones, n, "Ingrese la extensión en metros cuadrados")
                || !ValidarJOption_ParaInt(precios, n, "Ingrese el precio"))
            {
                n--;
                for (int i = 0; i <= n; i++) {
                    ubicaciones[i] = ubicaciones[i + 1];
                    extensiones[i] = extensiones[i + 1];
                    precios[i] = precios[i + 1];
                }
            }   
        } 
        else if (n < (tam - 1)) 
        {

            String nomB = ValidarJOption_ParaTexto01("Ingrese la ubicacion del departamento");

            if (nomB != null)
            {
                int pos = Busca(ubicaciones, nomB, n);

                if ((pos >= 0) && ((pos == 0) && (nomB.equalsIgnoreCase(ubicaciones[0])))) 
                {
                    JOptionPane.showMessageDialog(null, nomB + " el departamento ya esta registrado");
                } 
                else 
                {
                    n = n + 1;

                    pos = pos * (-1);

                    for (int i = n; i >= (pos + 1); i--) 
                    {
                        ubicaciones[i] = ubicaciones[i - 1];
                        extensiones[i] = extensiones[i - 1];
                        precios[i] = precios[i - 1];
                    }

                    ubicaciones[pos] = nomB;

                    if (!ValidarJOption_ParaInt(extensiones, pos, "Ingrese la extensión en metros cuadrados") ||
                        !ValidarJOption_ParaInt(precios, pos, "Ingrese el precio") )
                    {
                        n--;
                        for (int i = n; i <= pos/-1; i++) {
                            ubicaciones[i] = ubicaciones[i + 1];
                            extensiones[i] = extensiones[i + 1];
                            precios[i] = precios[i + 1];
                        }
                    }

                }
            }  
        } 
        else
        {
            JOptionPane.showMessageDialog(null, "No hay espacio disponible");
        }
        
        return n;
    }
    
    public static int Eliminar(String ubicaciones[], Integer extensiones[], Integer precios[], int n) {
        
        if (n > -1) {
            
            String nomB = ValidarJOption_ParaTexto01("Ingrese la ubicacion del departamentoa eliminar");
            
            if (nomB != null)
            {
                int pos = Busca(ubicaciones, nomB, n);

                if ((pos < 0) || (!nomB.equalsIgnoreCase(ubicaciones[pos])) )
                {
                    JOptionPane.showMessageDialog(null, nomB + " no existe");
                } 
                else
                {
                    n = n - 1;
                    for (int i = pos; i <= n; i++) {
                        ubicaciones[i] = ubicaciones[i + 1];
                        extensiones[i] = extensiones[i + 1];
                        precios[i] = precios[i + 1];
                    }
                    JOptionPane.showMessageDialog(null, "Eliminacion realizada");
                }
                
            } 
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Array vacio");
        }
        return n;
    }

    public static void ModifPrecio(String ubicaciones[], Integer extensiones[], Integer precios[], int n) {
       
        if (n > -1) {
            
            String nomB = ValidarJOption_ParaTexto01("Ingrese el departamento con el precio a modificar"); 
               
            if (nomB != null)
            {
                int pos = Busca(ubicaciones, nomB, n);
            
                if ((pos < 0) || (!nomB.equalsIgnoreCase(ubicaciones[pos]))) {
                    JOptionPane.showMessageDialog(null, nomB + " no existe");
                } else {
                    precios[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio"));
                    JOptionPane.showMessageDialog(null, "Modificacion realizada");
                }
   
            }
            
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Array vacio");
        }
    }

    public static void ImprimirDepartamento(String ubicaciones[], Integer extensiones[], Integer precios[], int n) {
        
        if (n > -1) 
        {
            String nomB = ValidarJOption_ParaTexto01("Ingrese la ubicacion del departamento");
            
            if (nomB != null)
            {
                int pos = Busca(ubicaciones, nomB, n);
            
                if ((pos < 0) && (!nomB.equalsIgnoreCase(ubicaciones[0])) )
                {
                    JOptionPane.showMessageDialog(null, nomB + " no existe");
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Ubicacion del departamento: " + ubicaciones[pos] + 
                            "\nExtension del departamento: " + extensiones[pos] + "\nPrecio del departamento: " + 
                            precios[pos]);
                }
            }
            
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Array vacio");
        }
    }
 
}
