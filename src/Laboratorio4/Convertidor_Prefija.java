package Laboratorio4;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Convertidor_Prefija {
    
    public static String Prefija(String cadena)
    {
        int i, l, Tope = -1;

        String EPRE = "", simb, IEpre = "";
        l = cadena.length();
        String Pila[] = new String[l];
        i = l - 1;
        while (i >= 0) {
            simb = cadena.substring(i, i + 1);
            i--;
            if (simb.equalsIgnoreCase(")")) {
                Tope++;
                Pila[Tope] = simb;

            } else {
                if (simb.equalsIgnoreCase("(")) {
                    while (Pila[Tope].compareTo(")") != 0) {
                        EPRE += Pila[Tope];
                        Tope--;
                    }
                    Tope--;
                } else {
                    if ((simb.compareTo("A") >= 0) && (simb.compareTo("Z") <= 0)) {
                        EPRE += simb;
                    } else {
                        if (Tope >= 0) {
                            while (Prioridad(simb) < Prioridad(Pila[Tope])) {
                                EPRE += Pila[Tope];
                                Tope--;
                                if (Tope == (-1)) {
                                    break;
                                }
                            }
                        }
                        Tope++;
                        Pila[Tope] = simb;
                    }
                }
            }
        }
        while (Tope >= 0) {
            EPRE += Pila[Tope];
            Tope--;
        }
        for (i = (EPRE.length() - 1); i >= 0; i--) {
            IEpre += EPRE.substring(i, i + 1);
        }
        
        return IEpre;
    }

    public static int Prioridad(String operador) {
        if (operador.equals("^")) {
            return 4;
        } else {
            if ((operador.equals("*")) || (operador.equals("/"))) {
                return 3;
            } else {
                if ((operador.equals("+")) || (operador.equals("-"))) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }

    }
}

