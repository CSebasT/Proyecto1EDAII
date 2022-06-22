package grp7.metodosDeBusqueda;

import java.util.List;
import java.util.ArrayList;

public class BuscadorPatrones {

    /**
     * Con cada algoritmo en la Lista, se buscan las coincidencias del patrón
     * en el texto y se guarda cada uno de los Resultados.
     * 
     * @param algoritmos Lista de los algoritmas de busqueda de coincidencias.
     * @param texto el texto en el que se realizara la busqueda.
     * @param patron el patrón que se buscará.
     * @return un ArrayList con los resultados de todas las búsquedas.
     */
    public ArrayList<Resultado> getResultado(List<AlgoritmoDeCoindicencias> algoritmos, String texto, String patron) {
        int totalCoincidencias, indexLinea;
        double tiempoInicial, tiempo;
        char[] lineaChars, patronChars;
        String resultado, coincidencias;
        String[] lineas = texto.split("\r?\n|\r");
        ArrayList<Resultado> resultados = new ArrayList<>();
        //Se realiza la búsqueda por cada algoritmo.
        for (AlgoritmoDeCoindicencias algoritmo : algoritmos) {
            tiempo = 0;
            indexLinea = 0;
            totalCoincidencias = 0;
            resultado = "";
            coincidencias = "";
            //Recorre las lineas del texto.
            for (String linea : lineas) {
                indexLinea++;
                patronChars = patron.toCharArray();
                lineaChars = linea.toCharArray();
                tiempoInicial = System.nanoTime();
                ArrayList<Integer> posiciones = algoritmo.resolver(lineaChars, patronChars);
                //Calcula el tiempo por búsqueda.
                tiempo += (System.nanoTime() - tiempoInicial)/1000000;
                //Guarda las coincidencias encontradas.
                if (!posiciones.isEmpty()){
                    for (int posicion : posiciones) {
                        totalCoincidencias++;
                        coincidencias += "\n\tCoincidencia " + totalCoincidencias + " en la línea " + indexLinea + " en la poscición " + posicion;
                    }
                }
            }
            //Guarda los resultados.
            resultado = "Para el algoritmo " + algoritmo + " con el patron \"" + patron + "\" se encontraron " + totalCoincidencias + " coincidencias y la búsqueda tomó " +String.format("%.4f",tiempo)+ " milisegundos. ";
            if (!coincidencias.equals("")){
                resultado += "\nLas coincidencias encontradas fueron las siguientes:" + coincidencias;
            }
            resultados.add(new Resultado(algoritmo.getNombre(), resultado, patron, tiempo));
        }
        return resultados;
    }
}
