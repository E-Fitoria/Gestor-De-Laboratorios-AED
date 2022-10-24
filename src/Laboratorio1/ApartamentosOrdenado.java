package Laboratorio1;

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

        if (n == -1) {
            n++;
            
            if (ValidarJOption(ubicaciones,extensiones,precios,n) == false)
            {
                n--;
            }
            
            /*ubicaciones[n] = JOptionPane.showInputDialog("Ingrese la ubicacion");
            extensiones[n] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la extension mts cuadrados"));
            precios[n] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del apartamento"));
            */
        } else if (n < (tam - 1)) {
            
            String nomB = JOptionPane.showInputDialog("Ingrese la ubicacion del departamento");
            
            if(nomB == null)
            {
               return n--; 
            }

            int pos = Busca(ubicaciones, nomB, n);
            if ((pos >= 0) && ((pos == 0) && (nomB.equalsIgnoreCase(ubicaciones[0])))) {
                JOptionPane.showMessageDialog(null, nomB + "el departamento ya esta registrado");
            } else {
                n = n + 1;
                pos = pos * (-1);
                for (int i = n; i >= (pos + 1); i--) {
                    ubicaciones[i] = ubicaciones[i - 1];
                    extensiones[i] = extensiones[i - 1];
                    precios[i] = precios[i - 1];
                }

                ubicaciones[pos] = nomB;
                boolean opc_metros = true, opc_precio = true;
                
                do {
                    
                    try {

                        String metros = JOptionPane.showInputDialog("Ingrese la extensión en metros cuadrados");

                        if (metros == null) {
                            return n--;
                        }

                        extensiones[pos] = Integer.parseInt(metros);
                        opc_metros = true;

                    }
                    catch (Exception e) 
                    {
                        opc_metros = false;
                    }
                } while (opc_metros != true);
                
                do {
                    try {
                        String precio = JOptionPane.showInputDialog("Ingrese el precio");

                        if (precio == null) {
                            return n--;
                        }
                        
                        precios[pos] = Integer.parseInt(precio);
                        opc_precio = true;
                        
                    } catch (Exception e) {
                        opc_precio = false;
                    }
                } while (opc_precio != true);
                //extensiones[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la extension del departamento"));
                //precios[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del departamento"));

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio disponible");
        }
        return n;
    }

    public static int Eliminar(String ubicaciones[], Integer extensiones[], Integer precios[], int n) {
        if (n > -1) {
            
            String nomB= JOptionPane.showInputDialog("De la ubicacion del departamento a dar de baja");
            
            if (nomB == null)
            {
                return n;
            }
            
            int pos = Busca(ubicaciones, nomB, n);

            if ((pos < 0) || nomB.equalsIgnoreCase(ubicaciones[pos]) == false) {
                JOptionPane.showMessageDialog(null, nomB + " no existe");
            } else {
                n = n - 1;
                for (int i = pos; i <= n; i++) {
                    ubicaciones[i] = ubicaciones[i + 1];
                    extensiones[i] = extensiones[i + 1];
                    precios[i] = precios[i + 1];
                }
                JOptionPane.showMessageDialog(null, "Eliminacion realizada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Array vacio");
        }
        return n;
    }

    public static void ModifPrecio(String ubicaciones[], Integer extensiones[], Integer precios[], int n) {
        if (n > -1) {
            String nomB = JOptionPane.showInputDialog("Ingrese la superficie del departamento con el precio a modificar");
            
            if (nomB == null)
            {
                return;
            }
            
            int pos = Busca(ubicaciones, nomB, n);
            if ((pos < 0) && (!nomB.equalsIgnoreCase(ubicaciones[0]))) {
                JOptionPane.showMessageDialog(null, nomB + " no existe");
            } else {
                precios[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio"));
                JOptionPane.showMessageDialog(null, "Modificacion realizada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Array vacio");
        }
    }

    public static void ImprimirDepartamento(String ubicaciones[], Integer extensiones[], Integer precios[], int n) {
        if (n > -1) {
            String nomB = JOptionPane.showInputDialog("De la ubicacion del departamento a visualizar");
           
            if (nomB == null)
            {
                return;
            }
            
            int pos = Busca(ubicaciones, nomB, n);
            
            if ((pos < 0) || nomB.equalsIgnoreCase(ubicaciones[pos]) == false) {
                JOptionPane.showMessageDialog(null, nomB + " no existe");
            } else {
                JOptionPane.showMessageDialog(null, "Ubicacion del departamento: " + ubicaciones[pos] + "\nExtension del departamento: " + extensiones[pos] + "\nPrecio del departamento: " + precios[pos]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Array vacio");
        }
    }

    public static void ImprimirTodo(String ubicaciones[], Integer extensiones[], Integer precios[], int n) {
        
        if (n > -1) {

            for (int pos = 0; pos <= n; pos++) {
                JOptionPane.showMessageDialog(null, "Ubicacion del departamento: " + ubicaciones[pos] + "\nExtension del departamento: " + extensiones[pos] + "\nPrecio del departamento: " + precios[pos]);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Array vacio");
        }
    }
    
    /*
    Esta funcion nos ayuda a validar mensaje de JOption Pane, las ventanas devuelven null cuando de cancela o presiona x
    */
    public static boolean ValidarJOption(String ubicaciones[], Integer extensiones[], Integer precios[], int n)
    {
        boolean opc_metros = true, opc_precio = true;

        while (true)
        {
            /*Validamos la ventana de ubicacion donde operamos con string la única validación que se hace es para saber
            si el usuario cancela o se sale de la ventana, si hace esto retorna un null, en dado le restamos a n--
            y break para salir del ciclo y terminar la operacion, le restamos a n para no almacenar nada en el array
            */
            ubicaciones[n] = JOptionPane.showInputDialog("Ingrese la ubicacion del terreno");

            if (ubicaciones[n] == null)
            {
                return false;
            }

            /*
            Ahora validamos los metros, usamos la misma logica de las ventanas para saber si retona null, pero con la 
            diferencia de que vamos a convertir a un valor entero, si esto ocasiona un error usamos un try{}catch(){}
            para validar errores y salimos de la ventana hasta que ingrese valores numericos o cancele la operacion
            */
            do 
            {
                try 
                {
                    
                    String metros = JOptionPane.showInputDialog("Ingrese la extensión en metros cuadrados");

                    if (metros == null) 
                    { 
                        return false;
                    }
                    
                    extensiones[n] = Integer.parseInt(metros);
                    opc_metros = true;
                    
                } 
                catch (Exception e) 
                {
                    opc_metros = false;
                }
            }while (opc_metros != true);
            
            do 
            {
                try 
                {        
                    String precio = JOptionPane.showInputDialog("Ingrese el precio");

                    if (precio == null) 
                    {
                        return false;
                    }
                    precios[n] = Integer.parseInt(precio);
                    opc_precio = true;
                } 
                catch (Exception e) 
                {
                    opc_precio = false;
                }
            }while (opc_precio != true);

            if(ubicaciones[n] != null && opc_metros == true && opc_precio == true)
            {
                return true;
            }

        } //Fin while
        
    } //Fin funcion

}
