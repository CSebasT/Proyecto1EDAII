package grp7.metodosDeBusqueda;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author rnbp
 */
public class BuscadorPatrones {

    public ArrayList<Resultado> getResultado(Algoritmo algoritmo, String text, List<String> patrones) {
        int totalCoincidencias, indexLinea;
        double tiempoInicial, tiempo;
        char[] lineaChars, patronChars;
        String resultado, coincidencias;
        String[] lineas = text.split("\r?\n|\r");
        ArrayList<Resultado> resultados = new ArrayList<>();
        for (String patron : patrones) {
            tiempo = 0;
            indexLinea = 0;
            totalCoincidencias = 0;
            resultado = "";
            coincidencias = "";
            for (String linea : lineas) {
                patronChars = patron.toCharArray();
                lineaChars = linea.toCharArray();
                tiempoInicial = System.nanoTime();
                ArrayList<Integer> posiciones = algoritmo.resolver(lineaChars, patronChars);
                tiempo += (System.nanoTime() - tiempoInicial)/1000000;
                if (!posiciones.isEmpty()){
                    for (int posicion : posiciones) {
                        totalCoincidencias++;
                        indexLinea++;
                        coincidencias += "\n\tCoincidencia " + totalCoincidencias + " en la línea " + indexLinea + " en la poscición " + posicion;
                    }
                }
            }
            resultado = "Para el algoritmo " + algoritmo + " con el patron " + patron + " se encontraron " + totalCoincidencias + " coincidencias y la búsqueda tomó " +String.format("%.4f",tiempo)+ " milisegundos. " + coincidencias;
            resultados.add(new Resultado(algoritmo.getNombre(), resultado, patron, tiempo));
        }
        return resultados;
    }
}
