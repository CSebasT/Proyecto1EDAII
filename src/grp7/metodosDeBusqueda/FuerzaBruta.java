package grp7.metodosDeBusqueda;

import java.util.ArrayList;

public class FuerzaBruta extends AlgoritmoDeCoindicencias {

    /*
    ** Método para buscar las coincidencias de un patrón en un texto dado, mediante Fuerza Bruta
     */
    public FuerzaBruta() {
        super();
        this.nombre = "Fuerza Bruta";
    }

    @Override
    public ArrayList<Integer> resolver(char[] texto, char[] patron) {
        int longitudDelTexto = texto.length;
        int longitudDelPatron = patron.length;

        ArrayList<Integer> posicionesCoincidencias = new ArrayList<>(); //Estructura con posiciónes de las coincidencias encontradas.

        for (int i = 0; i <= longitudDelTexto - longitudDelPatron; i++) {
            int j; //Variable auxiliar para recorrer el patrón y el texto.
            for (j = 0; j < longitudDelPatron; j++) {
                if (texto[i + j] != patron[j]) {
                    break; //Deja de comparar si existe un fallo.
                }
            }
            if (j == longitudDelPatron) {
                posicionesCoincidencias.add(i); //Guarda la posición de coincidencia.
            }
        }
        return posicionesCoincidencias;
    }
}
