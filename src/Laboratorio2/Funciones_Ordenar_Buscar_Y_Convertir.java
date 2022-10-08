
package Laboratorio2;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Usuario
 */
public class Funciones_Ordenar_Buscar_Y_Convertir {
    
    /*
        Esta funcion recibe como parametro un string,la funcion convertirá ese string a un arreglo de tipo int,
        Si el usuario ingresa valores que no sean enteros separados por coma (,) debemos usar un try{}catch(){}
        para el manejo de errores en los archivos que estemos usando la funcion convertir
    */
    
    public static int[] Convertir(String array)
    {
        StringTokenizer stk = new StringTokenizer(array, "[,]"); 
        String[] strings = new String[stk.countTokens()];
        int[] ArregloEntero = new int[stk.countTokens()]; // arreglo de enteros 
        int i = 0; // inicializamos variable para el ciclo de conversion del String en arreglo de int 
          
        // Ciclo para convertir el String en un arreglo de int 
        while (stk.hasMoreTokens()) {
            strings[i] = stk.nextToken();
            ArregloEntero[i] = Integer.parseInt(strings[i]);
            i++;
        }
        
        return ArregloEntero;
    }
    
    public static int Busqueda(String array, String elemento) 
    {
        
        int[] ArregloInt = Convertir(array);
        int Elemento = Integer.parseInt(elemento); // transformamos el elemntos a int  
        int indice = -1;
        
        // Busqueda del elemento en el arreglo 
        for (int x = 0; x < ArregloInt.length; x++) {
            if (ArregloInt[x] == Elemento) {
                indice = x;
                break;
            }
        }

        return indice;
    }
        
    /*
        Métodos de Ordenamiento para arreglos desordenados
    */
    public static String Burbuja (int[] array){
        
        //Metodo  burbuja
        for (int k = 0; k < ((array.length) -1) ; k++){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j+1]){
                    int temporal = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temporal;
                }
            }
        }//fin burbuja
        
        String ordenado = Arrays.toString(array);
        
        return ordenado;
    }
    
    public static String Inserccion(int[] array){
        
        int auxiliar, k;
        //Inserccion (A,N)
        for (int i = 1; i < array.length; i++){
            auxiliar = array[i];
            k = i -1;

            while ( (k >= 0) && (auxiliar < array[k])){
                array[k+1] = array[k];
                k -= 1;
            }

            array[k+1] = auxiliar;
        }//fin inserccion
        
        return Arrays.toString(array);
    }
    
    public static String Sacudida (int[] array){
        
        int izquierda = 1, derecha = array.length -1 , k = -1, temporal;
        
        //Sacudida
        while (derecha >= izquierda) {

            for (int i = derecha; i >= izquierda; i--) {

                if (array[i - 1] > array[i]) {

                    temporal = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temporal;
                    k = i;
                }
            }
            //fin primera parte sacudida

            izquierda = k + 1;

            for (int i = izquierda; i <= derecha; i++) {

                if (array[i - 1] > array[i]) {
                    temporal = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temporal;
                    k = i;
                }
            }

            derecha = k-1;
        }//fin sacudida
        
        return Arrays.toString(array);
    }
    
    public static String Seleccion(int[] array){
        
        int k, menor;
        
        //Seleccion
        for (int i = 0; i < array.length; i++){
            menor = array[i];
            k = i;

            for (int j = i +1; j < array.length; j++){

                if (array[j]  < menor){
                    menor = array[j];
                    k = j;
                }
            }

            array[k] = array[i];
            array[i] = menor;

        } //fin seleccion

        return Arrays.toString(array);
    }
    
    public static String Shell(int[] array){
        
        int entero = array.length + 1, i, temporal;
        boolean band;
        
        //shell
        while (entero > 0) {

            entero /= 2;
            band = true;

            while (band == true) {

                band = false;
                i = 0;

                while ((i + entero) < array.length) {

                    if (array[i] > array[i + entero]) {

                        temporal = array[i];
                        array[i] = array[i + entero];
                        array[i + entero] = temporal;
                        band = true;
                    }

                    i++;
                }
            }
        }
        
        return Arrays.toString(array);
    }
}
