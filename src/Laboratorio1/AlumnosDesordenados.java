package Laboratorio1;


import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaDouble;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaInt;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaTexto;
import static Laboratorio1.ValidarEntradaJOptionPane.ValidarJOption_ParaTexto01;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
 //@author HP

public class AlumnosDesordenados {

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
    
    public  static int InsertarAlumnos(String nombres[], Integer semestres[], Double promedios[], int n, int tam){
        if (n == -1) {
            
            n++;
            
            if (!ValidarJOption_ParaTexto(nombres,n,"Ingrese el nombre del Alumno") 
                || !ValidarJOption_ParaInt(semestres, n, "Ingrese los semestres")
                || !ValidarJOption_ParaDouble(promedios, n, "Ingrese el promedio"))
            {
                n--;
                for (int i = 0; i <= n; i++) {
                    nombres[i] = nombres[i + 1];
                    semestres[i] = semestres[i + 1];
                    promedios[i] = promedios[i + 1];
                }
            }   

        }else if(n < (tam - 1)){
            
            String nombreBus = ValidarJOption_ParaTexto01("Ingrese el nombre completo del alumno"); // se buscara el nombre del alumno en el arreglo para comprobar si ya existe en el 
            
            if (nombreBus != null)
            {
                int pos = Busca(nombres, nombreBus, n); // busca si el alumno ya existe en el arreglo mediante nombreBus

                if (pos == 0 && (nombreBus.equalsIgnoreCase(nombres[0]))) 
                {
                    JOptionPane.showMessageDialog(null, nombreBus + "El alumno ya existe");
                } 
                else 
                {
                    n = n + 1;
                    pos = pos * (-1);
                    
                    for (int i = n; i >= (pos + 1); i--) 
                    {
                        nombres[i] = nombres[i - 1];
                        semestres[i] = semestres[i - 1];
                        promedios[i] = promedios[i - 1];
                    }
                    
                    nombres[pos] = nombreBus;
                    
                    if (!ValidarJOption_ParaInt(semestres, pos, "Ingrese la cantidad de semestres cursados") ||
                        !ValidarJOption_ParaDouble(promedios, pos, "Ingrese el promedio") )
                    {
                        n--;
                        for (int i = n; i <= pos/-1; i++) {
                            nombres[i] = nombres[i + 1];
                            semestres[i] = semestres[i + 1];
                            promedios[i] = promedios[i + 1];
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
    
    public static int EliminarAlumnos(String nombres[], Integer semestres[], Double promedios[], int n){
        if(n>-1)
        {
            
            String nombreBus= ValidarJOption_ParaTexto01("Ingrese el nombre del alumno que desea eliminar");
            
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
                        semestres[i] = semestres[i + 1];
                        promedios[i] = promedios[i + 1];
                    }
                    JOptionPane.showMessageDialog(null, "Eliminacion realizada");
                }
            }
            
        }else
            JOptionPane.showMessageDialog(null, "Arreglo vacio");
        
        return n;
}
    
    
    public static void ModificarAlumno(String nombres[], Integer semestres[], Double promedios[], int n){
        
        if(n > -1){
            
            String nombreBus= ValidarJOption_ParaTexto01("Ingrese el nombre del alumno cuyos datos desea modificar");
            
            if (nombreBus != null)
            {
                int pos = Busca(nombres, nombreBus, n);

                if ((pos < 0) || (!nombreBus.equalsIgnoreCase(nombres[pos])))
                    JOptionPane.showMessageDialog(null, nombreBus + " no existe");
                else {
                    semestres[pos] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo semestre del alumno " + nombreBus));
                    promedios[pos] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo promedio del alumno " + nombreBus));
                    JOptionPane.showMessageDialog(null, "Modificacion realizada");
                }
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Arreglo vacio");
        }
    }
    
    public static void ListarAlumno(String nombres[], Integer semestres[], Double promedios[], int n){
        if( n > -1)
        {
            String nombreBus= ValidarJOption_ParaTexto01("Ingrese el nombre del alumno para mostras sus datos");
            
            if (nombreBus != null)
            {
                int pos = Busca(nombres, nombreBus, n);
                
                if ((!nombreBus.equalsIgnoreCase(nombres[0])) || (pos < 0))
                    JOptionPane.showMessageDialog(null, nombreBus + " no existe");
                else {
                    JOptionPane.showMessageDialog(null, "Nombre del alumno: " + nombres[pos] + "\nSemestre Cursado: " + semestres[pos] + "\nPromedio Total: " + promedios[pos]);
                }
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Arreglo vacio");
        }
        
    }//fin funcion
    
}//fin class
