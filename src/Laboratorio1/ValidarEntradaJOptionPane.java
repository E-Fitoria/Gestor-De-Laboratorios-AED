package Laboratorio1;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ValidarEntradaJOptionPane {
    
    /**Esta funcion valida que los valores ingresados por un usuario en un JOptionPane sean
    * de tipo int
    * @param array el array en el que almacenamos el dato
    * @param pos la posicion en la almacenaremos el dato
    * @param cadena el mensaje que mostrará el JOptionPane
    * @return true hasta que el uusario ingrese un valor válido
    * @return false si el usuario cierra la ventana JOptionPane
    */
    public static boolean ValidarJOption_ParaInt(Integer array[],int pos, String cadena){
        
        /*  cuando el usuario cierra la ventana o cierra la operacion se guarda un null en la variable
            en dado caso se retorna un false indicando que se cancela, en caso que no sea así trataremos 
            convertir lo que se guardó en un entero si esto no coincide con un tipo int se ejucutan las 
            excepciones con el try catch, la operacion termina hasta que el usuario cancele la operacion 
            o hasta que ingrese un dato válido para convertir.
        */
        
        boolean opc;
                
        do  
        {  
            try 
            {

                String dato = JOptionPane.showInputDialog(cadena);

                if (dato == null) {
                    return false;
                }
                else
                {
                    array[pos] = Integer.parseInt(dato);
                    opc = true;
                } 
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Ingresa valores válidos");
                opc = false;
            }
            
        }while (opc != true); 
                
        return opc;
    }
    
    public static boolean ValidarJOption_ParaDouble(Double array[],int pos, String cadena){
        
        boolean opc;
                
        do  
        {  
            try 
            {

                String dato = JOptionPane.showInputDialog(cadena);

                if (dato == null) {
                    return false;
                }
                else
                {
                    array[pos] = Double.parseDouble(dato);
                    opc = true;
                } 
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null,"Ingresa valores válidos");
                opc = false;
            }
            
        }while (opc != true); 
                
        return opc;
    }
    
    
    /**Esta funcion valida que los valores ingresados por un usuario en un JOptionPane sean
     * de tipo string sin caracteres especiales ni espacios, solo debe ingresar letras
     * 
     * @param array arreglo en el que guardaremos la información
     * @param pos   la posición del arreglo en la que guardaremos 
     * @param cadena mensaje que mostrará en el JOptionPane
     * @return true cuando la operación termina correctamente
     * @return false cuando el usuario cierra la ventana o cancela la operación
    */
    public static boolean ValidarJOption_ParaTexto(String[] array, int pos, String cadena){
        
       /*   cuando el usuario cierra la ventana o cierra la operacion se guarda un null en la variable
            en dado caso se retorna un false indicando que se cancela, en caso que no sea así usamos
            un ciclo para iterar cada caracter de la cadena y revisar si hay caracteres que no son letreas, 
            si hay aumentamos el contador, si el contador es mayor a 0 o encontramos que el valor guardado 
            en la cadena es vacío(la funcions isEmpty sirve para ello) entonces pedimos al usuario volver
            a ingresar los datos.     
       */
       
        boolean opc = false;       

        do 
        {   

            try 
            {
                int contador = 0;
                String dato = JOptionPane.showInputDialog(cadena);

                if (dato == null ) 
                {
                   return false;
                }
                else
                {
                    for (int i = 0; i < dato.length(); i++)
                    {
                       if (Character.isLetter(dato.charAt(i)) == false)
                       {
                           contador++;
                       } 
                    }
                }
                    
                if (contador > 0 || dato.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null,"Formato inválido, ingrese letras");
                    opc = false;
                }
                else
                {
                    array[pos] = dato;
                    return true;
                }      
            }
            catch (Exception e) 
            {
                opc = false;
            }
            
        }while (opc != true);
                
        return opc; 

    }
    
    /**Esta funcion valida que los valores ingresados por un usuario en un JOptionPane sean
     * de tipo string sin caracteres especiales ni espacios, solo debe ingresar letras
     * 
     * @param cadena el mensaje que se mostrará en la ventana de JOptionPane
     * @return una cadena validada
    */
    
    public static String ValidarJOption_ParaTexto01(String cadena){
        
       /*   cuando el usuario cierra la ventana o cierra la operacion se guarda un null en la variable
            en dado caso se retorna un false indicando que se cancela, en caso que no sea así usamos
            un ciclo para iterar cada caracter de la cadena y revisar si hay caracteres que no son letreas, 
            si hay aumentamos el contador, si el contador es mayor a 0 o encontramos que el valor guardado 
            en la cadena es vacío(la funcions isEmpty sirve para ello) entonces pedimos al usuario volver
            a ingresar los datos.     
       */
       
        String dato = null;
        boolean opc = false;
        int contador = 0;        
        
        do 
        {   
            opc = false;
            contador = 0;
            
            try 
            {
                dato = JOptionPane.showInputDialog(cadena);

                if (dato == null ) 
                {
                   return dato;
                }
                else
                {
                    for (int i = 0; i < dato.length(); i++)
                    {
                       if (Character.isLetter(dato.charAt(i)) == false)
                       {
                           contador++;
                       } 
                    }
                }
                    
                if (contador > 0 || dato.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null,"Formato inválido, ingrese letras");
                    opc = false;
                }
                else
                {
                    opc = true;
                }      
            }
            catch (Exception e) 
            {
                opc = false;
            }
            
        }while (opc != true);
                
        return dato; 
    }


    public static boolean ValidarJOption_ParaOpc(Integer array[], int pos, String cadena) {

        int dato = JOptionPane.showConfirmDialog(null, cadena, "Seleccione", JOptionPane.YES_NO_OPTION, 
                                                 JOptionPane.QUESTION_MESSAGE);

        if (dato == -1) 
        {
            return false;    
        } 
        
        array[pos] = dato; //0 para si, 1 para no
        return true;
    }

}