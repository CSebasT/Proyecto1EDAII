package grp7.metodosDeBusqueda;

import java.util.ArrayList;
import java.util.Arrays;

public class KMP {

    /*
    ** Método para buscar las coincidencias de un patrón en un texto dado, mediante KMP
     */
    public static ArrayList<Integer> buscarCoincidenciasKMP(char[] texto, char[] patron) {
        int longitudDelTexto = texto.length;
        int longitudDelPatron = patron.length;
        ArrayList<Integer> posicionesCoincidencias = new ArrayList<>(); //Estructura con posiciónes de las coincidencias encontradas.

        if (longitudDelPatron == 0) {
            return null; //Retorna null si el patrón se encuentra vacío.
        }

        int[] tablaFallo = calcularFuncionFallo(patron); //Variable con la Tabla de Fallo.
        int d = 0; //Variable auxiliar para recorrer el texto.
        int c = 0; //Variable auxiliar para recorrer el patrón.

        while (d < longitudDelTexto) {
            if (texto[d] == patron[c]) {
                if (c == longitudDelPatron - 1) {
                    posicionesCoincidencias.add(d - longitudDelPatron + 1); //Guarda la posición de coincidencia.
                    c = -1; //La variable auxiliar vuelve al inicio del patrón.
                }
                d++; //Avanzar en el texto.
                c++; //Avanzar en el patrón.
            } else if (c > 0) {
                c = tablaFallo[c - 1]; //Avanzar en el patrón según la Tabla de Fallo.
            } else {
                d++; //Avanzar en el texto.
            }
        }
        return posicionesCoincidencias;
    }

    /*
    ** Método para calcular los valores en la Tabla de Fallo.
     */
    public static int[] calcularFuncionFallo(char[] patron) {
        int longitudDelPatron = patron.length;

        int[] tablaFallo = new int[longitudDelPatron]; //Estrcutura con la Tabla de Fallo.
        int posicionActual = 1; //Variable auxiliar para recorrer el patrón.
        int posicionCandidato = 0; //Variable auxiliar para determinar los valores en la Tabla de Fallo.

        while (posicionActual < longitudDelPatron) {
            if (patron[posicionActual] == patron[posicionCandidato]) {
                tablaFallo[posicionActual] = posicionCandidato + 1; //Se añade el valor a la Tabla de Fallo.
                posicionActual++; //Avanzar en el patrón.
                posicionCandidato++; //La posición del candidato avanza en 1.
            } else if (posicionCandidato > 0) {
                posicionCandidato = tablaFallo[posicionCandidato - 1]; //El valor del candidato se obtiene de la Tabla de Fallo.
            } else {
                posicionActual++; //Avanzar en el patrón.
            }
        }
        return tablaFallo;
    }
}
