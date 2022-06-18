package grp7.metodosDeBusqueda;

import java.util.ArrayList;

/**
 *
 * @author rnbp
 */
public abstract class Algoritmo {

    String nombre;

    public abstract ArrayList<Integer> resolver(char[] texto, char[] patron);

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
