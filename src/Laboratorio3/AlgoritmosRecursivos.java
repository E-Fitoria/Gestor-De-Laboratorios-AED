
package Laboratorio3;

public class AlgoritmosRecursivos {
    
    /*
        Funcion recursiva para mostrar el inverso de un array
    */
    public static String MostrarInverso(int[] array, int iactual, int indice, String nums) {
         
        if (iactual == indice)    {
            nums += "" + array[iactual];
        } else {
            nums = MostrarInverso(array, iactual + 1, indice, nums);
            nums += "," + array[iactual];
        }
        return nums;
    }
    
    /*
     Ejercicio2
     */
    
     public static String invertirPalabra(String palabra){

        if(palabra.length() == 1){ //caso base, acaba cuando entre a la condicion
            return palabra;
        } else {
            return invertirPalabra(palabra.substring(1)) + palabra.charAt(0);
        }
    }
     
      /*
     ejercicio 3
     */
     public static int ProductoNUm(int[] numerous, int num){

        int producto = 1;

        if(num < 0){

            return producto;

        }else{

            producto *= numerous[num] * ProductoNUm(numerous,num-1);
        }

        return producto;
    }
    
    /*
     Ejercicio4
     */
     
    public static int NumEspacios(String cadena, int valor_inicial){

      int espacios = 0;

      if(valor_inicial == cadena.length())
      {
          return espacios;
      }
      else if(cadena.charAt(valor_inicial) ==  ' ') //revisamos caracter a caracter iniciando de la posicion 0
      {
          espacios++;
      }

      valor_inicial++; //aumentamos el valor para ir buscando el espacio

      return espacios + NumEspacios(cadena, valor_inicial);
    }
    
    /*
      Ejercicio 5
    */
      
    public static String[][] Calculo(double cuenta1, double interes1, double cuenta2, double interes2, int year,double t , int x, int y, String tabla[][]) {
       
        tabla[x][y] = ""+year;
        tabla[x][y+1] = String.format("%.2f", cuenta1);
        tabla[x][y+2] = String.format("%.2f", cuenta2);
        
        cuenta1 =  cuenta1*(1.0 + (t*interes1/100.0));
       
        cuenta2 = cuenta2*(1.0 + (t*interes2/100.0));
                
        if (cuenta1 <= cuenta2) {
         tabla = Calculo(cuenta1, interes1, cuenta2, interes2, year+1, t+1.0,x+1,y,tabla);
        } else {
            tabla[x][y] = ""+year;
            tabla[x][y+1] = String.format("%.2f", cuenta1);
            tabla[x][y+2] = String.format("%.2f", cuenta2);
        }
      
       return tabla; 
    }
    
     /*
      Ejercicio 6
      */
     public static String ulam(int numero, String secuencia){
        
        
        if (numero > 1 && numero % 2 == 0)
        {
            
            secuencia += numero +" "+ulam(numero/2,secuencia);
        }
        else if (numero > 1 && numero % 2 != 0)
        {
            secuencia += numero +" "+ulam((numero*3)+1,secuencia);
        }
        else
        {      
            return secuencia;       
        }
       
        return secuencia;
    }

}
