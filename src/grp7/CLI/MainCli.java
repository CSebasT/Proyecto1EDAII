package grp7.CLI;

import static grp7.CLI.Utils.leerArchivo;
import static grp7.CLI.Utils.leerPatrones;
import static grp7.CLI.Utils.mostrarResultados;

import grp7.metodosDeBusqueda.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainCli {

    public static void main(String[] args) {
        BuscadorPatrones buscador = new BuscadorPatrones();
        ArrayList<AlgoritmoDeCoindicencias> algoritmos = menu();
        ArrayList<String> listaPatrones = new ArrayList<>();
        ArrayList<Resultado> resultados = new ArrayList<>();
        listaPatrones = leerPatrones();
        String texto = "";
        try {
            BufferedReader br = leerArchivo();
            String linea;
            while ((linea = br.readLine()) != null) {
                texto += linea + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < listaPatrones.size(); i++) {
            System.out.println(listaPatrones.get(i));
        }
        for (String patron : listaPatrones) {
            resultados.addAll(buscador.getResultado(algoritmos, texto, patron));

        }
        for (Resultado resultado : resultados) {
            System.out.println(resultado.getResultado());
        }
        if (resultados.size() > 1) {
            Collections.sort(resultados);
            System.out.println(resultados.get(0).toString());
        }
    }

    public static ArrayList<AlgoritmoDeCoindicencias> menu() {
        int opcion = 0;
        Scanner leerOpcion = new Scanner(System.in);
        ArrayList<AlgoritmoDeCoindicencias> algoritmos = new ArrayList<>();
        ArrayList<Integer> opciones = new ArrayList<>();
        while (opcion != 4) {
            System.out.println("Eliga los algoritmos de Pattern Matching con los que se realizará la busqueda (Ingresar uno a la vez)");
            System.out.println("1. Fuerza Bruta");
            System.out.println("2. Boyer Moore");
            System.out.println("3. KMP");
            System.out.println("4. Terminar selección");
            opcion = leerOpcion.nextInt();
            if (opciones.contains(opcion) == false) {
                switch (opcion) {
                    case 1: {
                        algoritmos.add(new FuerzaBruta());
                        opciones.add(opcion);
                        break;
                    }
                    case 2: {
                        algoritmos.add(new BoyerMoore());
                        opciones.add(opcion);
                        break;
                    }
                    case 3: {
                        algoritmos.add(new KnuthMorrisPratt());
                        opciones.add(opcion);
                        break;
                    }
                    case 4: {
                        System.out.println("Fin selección");
                        break;
                    }
                    default: {
                        System.out.println("Eliga una opción valida");
                    }
                }
            } else {
                System.out.println("Ya se registo anteriormente el algoritmo");
            }

        }
        return algoritmos;
    }

    /*public static void buscarPatron(int opcionAlgoritmo) {
        BufferedReader br = leerArchivo();
        int numCoincidencia = 0;
        double tiempoTotal = 0;
        ArrayList<Integer> lineasCoincidencia = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayPosiciones = new ArrayList<>();
        ArrayList<char[]> patronBuscado = new ArrayList<>();
        ArrayList<char[]> patrones = leerPatrones();
        AlgoritmoDeCoindicencias algoritmo;
        switch (opcionAlgoritmo) {
            case 1:
                algoritmo = new FuerzaBruta();
                break;
            case 2:
                algoritmo = new BoyerMoore();
                break;
            default:
                algoritmo = new KnuthMorrisPratt();
                break;
        }
        for (int i = 0; i < patrones.size(); i++) {
            try {
                int contadorLinea = 1;
                char[] texto;

                String textoAux;
                long tiempoInicio = System.currentTimeMillis();
                while ((textoAux = br.readLine()) != null) {
                    ArrayList<Integer> posiciones = new ArrayList<Integer>();
                    texto = textoAux.toCharArray();
                    posiciones = algoritmo.resolver(texto, patrones.get(i));
                    if (posiciones.size() > 0) {
                        lineasCoincidencia.add(contadorLinea);
                        arrayPosiciones.add(posiciones);
                        patronBuscado.add(patrones.get(i));
                        numCoincidencia++;
                    }
                    contadorLinea++;
                }
                long tiempoFin = System.currentTimeMillis();
                tiempoTotal = (double) (tiempoFin - tiempoInicio);
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
        mostrarResultados(algoritmo.getNombre(), numCoincidencia, lineasCoincidencia, arrayPosiciones, patronBuscado, tiempoTotal);
    }*/
}
