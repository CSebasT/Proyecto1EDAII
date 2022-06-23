package grp7.CLI;

import grp7.metodosDeBusqueda.*;

import java.util.ArrayList;
import java.util.Collections;

public class MainCli {

    public static void main(String[] args) {
        BuscadorPatrones buscador = new BuscadorPatrones();
        ArrayList<Resultado> resultados = new ArrayList<>();
        //Elección de los algoritmos
        ArrayList<AlgoritmoDeCoindicencias> algoritmos = Utils.menu();
        //Elección de los patrones
        ArrayList<String> listaPatrones = Utils.leerPatrones();
        System.out.println("Los patrones ha buscar son: " + listaPatrones);
        //Carga del archivo de Texto
        String texto = Utils.leerArchivo();
        //Impresión de los resultados por cada patrón.
        for (String patron : listaPatrones) {
            resultados.addAll(buscador.getResultado(algoritmos, texto, patron));
            for (Resultado resultado : resultados) {
                System.out.println(resultado.getResumenResultado() + "\n");
            }
            //Impresión de la comparación.
            if (resultados.size() > 1) {
                Collections.sort(resultados);
                System.out.println(resultados.get(0).obtenerComoMejorResultado() + "\n");
            }
            resultados.clear();
        }
    }
}
