package grp7.metodosDeBusqueda;

import java.util.ArrayList;

public abstract class AlgoritmoDeCoindicencias {

    protected String nombre;

    /**
     * Obtiene las posiciones donde se encuentraron coincidencias de un patron
     * en un texto.
     * 
     * @param texto el texto en el que se realizara la busqueda.
     * @param patron el patrón que se buscará.
     * @return un ArrayList con las posiciones en el texto con coincidencias.
     */
    public abstract ArrayList<Integer> resolver(char[] texto, char[] patron);

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
