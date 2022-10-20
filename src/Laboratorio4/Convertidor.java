package Laboratorio4;

import java.util.Stack;

public class Convertidor {
    
    public static String Postfija(String cadena)
    {
        String expresion = depurar(cadena);
        String[] Array = expresion.split(" ");

        //Declaración de las pilas
        Stack< String> E = new Stack< String>(); //Pila entrada
        Stack< String> P = new Stack< String>(); //Pila temporal para operadores
        Stack< String> S = new Stack< String>(); //Pila salida

        //Añadir la array a la Pila de entrada (E)
        for (int i = Array.length - 1; i >= 0; i--) {
            E.push(Array[i]);
        }

        //Algoritmo Infijo a Postfijo
        while (!E.isEmpty()) {
            switch (pref(E.peek())) {
                case 1:
                    P.push(E.pop());
                    break;
                case 3:
                case 4:
                    while (pref(P.peek()) >= pref(E.peek())) {
                        S.push(P.pop());
                    }
                    P.push(E.pop());
                    break;
                case 2:
                    while (!P.peek().equals("(")) {
                        S.push(P.pop());
                    }
                    P.pop();
                    E.pop();
                    break;
                default:
                    S.push(E.pop());
            }
        }

            //Eliminacion de `impurezas´ en la expresiones algebraicas
            //String infix = expr.replace(" ", "");
            //String postfix = S.toString().replaceAll("[\\]\\[,]", "");
        
        return  S.toString().replaceAll("[\\]\\[,]", "");
    }
    
    
    //Depurar expresión algebraica
    public static String depurar(String s) 
    {
        s = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
        s = "(" + s + ")";
        String simbols = "^+-*/()";
        String str = "";

        //Deja espacios entre operadores
        for (int i = 0; i < s.length(); i++) {
            if (simbols.contains("" + s.charAt(i))) {
                str += " " + s.charAt(i) + " ";
            } else {
                str += s.charAt(i);
            }
        }
        return str.replaceAll("\\s+", " ").trim();
    }

    //Jerarquia de los operadores
    public static int pref(String op) {
        int prf = 99;
        if (op.equals("^")) {
            prf = 5;
        }
        if (op.equals("*") || op.equals("/")) {
            prf = 4;
        }
        if (op.equals("+") || op.equals("-")) {
            prf = 3;
        }
        if (op.equals(")")) {
            prf = 2;
        }
        if (op.equals("(")) {
            prf = 1;
        }
        return prf;
    }
    
}
