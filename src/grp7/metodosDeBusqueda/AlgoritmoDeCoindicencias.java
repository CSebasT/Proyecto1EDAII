package grp7.metodosDeBusqueda;

import java.util.ArrayList;

public abstract class AlgoritmoDeCoindicencias {
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
