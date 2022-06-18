package grp7.metodosDeBusqueda;

import java.util.ArrayList;
import java.util.HashMap;

public class BoyerMoore extends Algoritmo {

    public BoyerMoore() {
        this.nombre = "Boyer Moore";
    }

    @Override
    public ArrayList<Integer> resolver(char[] texto, char[] patron) {
        /*
        ** Método para buscar las coincidencias de un patrón en un texto dado, mediante BM
        */
        int longitudDelTexto = texto.length;
        int longitudDelPatron = patron.length;

        HashMap<Character, Integer> tablaD1 = calcularTablaD1(texto, patron);
        ArrayList<Integer> posicionesCoincidencias = new ArrayList<>(); //Estrcutura con posiciónes de las coincidencias encontradas.

        int e = longitudDelPatron; ////Variable auxiliar para guardar la posición actual en el texto.
        int d; //Variable auxiliar para recorrer el texto.
        int c; //Variable auxiliar para recorrer el patrón.

        while (e <= longitudDelTexto) {
            c = longitudDelPatron; //La variable vuelve al final del patrón.
            d = e; //La variable avanza a la siguiente posición en el texto.

            while (c > 0 && patron[c - 1] == texto[d - 1]) {
                c--; //Retrocede en el texto.
                d--; //Retrocede en el patrón.
            }
            if (c == 0) {
                posicionesCoincidencias.add(e - longitudDelPatron);
                e++; //La posición actual en el texto avanza en 1.
            } else {
                int i = tablaD1.get(texto[d - 1]); //Variable auxiliar con el avance según la Tabla D1.
                if (e >= d + i) {
                    e++; //Si la siguiente posición en el texto no es mayor, la posición actual en el texto avanza en 1.
                } else {
                    e = d + i; ////La posición actual en el texto avanza según la Tabla D1.
                }
            }
        }
        return posicionesCoincidencias;
    }

    /*
    ** Método para calcular los valores en la Tabla D1.
     */
    public static HashMap<Character, Integer> calcularTablaD1(char[] texto, char[] patron) {
        int longitudDelTexto = texto.length;
        int longitudDelPatron = patron.length;

        HashMap<Character, Integer> tablaD1 = new HashMap<>(); //Estructura con la Tabla de D1.

        for (int i = 0; i < longitudDelTexto; i++) {
            tablaD1.put(texto[i], longitudDelPatron); //Valor para carácteres en el texto.
        }

        for (int i = 0; i < longitudDelPatron; i++) {
            tablaD1.replace(patron[i], longitudDelPatron - 1 - i); //Valor para carácteres en el patrón.
        }
        return tablaD1;
    }
}
