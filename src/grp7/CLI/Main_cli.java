package grp7.CLI;

import static grp7.CLI.Utils.leerArchivo;
import static grp7.CLI.Utils.leerPatrones;
import static grp7.CLI.Utils.mostrarResultados;

import grp7.metodosDeBusqueda.*;
import java.io.BufferedReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_cli {

    public static void main(String[] args) {
        int opcion = 0;
        Scanner leerOpcion = new Scanner(System.in);
        while (opcion != 4) {
            System.out.println("Eliga el algoritmo de Pattern Matching");
            System.out.println("1. Fuerza Bruta");
            System.out.println("2. Boyer Moore");
            System.out.println("3. KMP");
            System.out.println("4. Salir");
            opcion = leerOpcion.nextInt();
            switch (opcion) {
                case 1: {
                    buscarPatron(opcion);
                    break;
                }
                case 2: {
                    buscarPatron(opcion);
                    break;
                }
                case 3: {
                    buscarPatron(opcion);
                    break;
                }
                case 4: {
                    System.out.println("Fin algoritmos");
                    break;
                }
                default: {
                    System.out.println("Eliga una opcion valida");
                }
            }
        }
        //Ejemplo de uso para el paquete grp7.metodosDeBusqueda.*
        /*char[] texto = "AAFMOFEDMSDABABACAADOANROAABABACA".toCharArray();
        char[] patron = "ABABACA".toCharArray();
        System.out.println(BM.buscarCoincidenciasBM(texto, patron));
        System.out.println(BM.calcularTablaD1(texto, patron));
        System.out.println(BF.buscarCoincidenciasBF(texto, patron));
        System.out.println(KMP.buscarCoincidenciasKMP(texto, patron));
        System.out.println(Arrays.toString(KMP.calcularFuncionFallo(patron)));*/
    }

    public static void buscarPatron(int opcionAlgoritmo) {
        BufferedReader br = leerArchivo();
        int numCoincidencia = 0;
        double tiempoTotal = 0;
        ArrayList<Integer> lineasCoincidencia = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayPosiciones = new ArrayList<>();
        ArrayList<char[]> patronBuscado = new ArrayList<>();
        ArrayList<char[]> patrones = leerPatrones();
        Algoritmo algoritmo;
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
    }
}
