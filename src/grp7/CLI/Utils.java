package grp7.CLI;

import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Utils {

    public static ArrayList<char[]> leerPatrones() {
        int numPatrones;
        ArrayList<char[]> patrones = new ArrayList<char[]>();
        Scanner leerNumPatrones = new Scanner(System.in);
        Scanner leerPatron = new Scanner(System.in);
        System.out.println("Ingrese el número de Patrones");
        numPatrones = leerNumPatrones.nextInt();

        for (int i = 0; i < numPatrones; i++) {
            System.out.println("Ingrese el patron " + (i + 1));
            char[] aux = leerPatron.nextLine().toCharArray();
            patrones.add(aux);
        }
        return patrones;
    }

    public static BufferedReader leerArchivo() {
        String pathArchivo;
        BufferedReader br = null;
        Scanner in = new Scanner(System.in);
        while (br == null) {
            try {
                System.out.println("Ingrese el path al archivo:");
                pathArchivo = in.nextLine();
                FileReader archivo = new FileReader(pathArchivo);
                return new BufferedReader(archivo);
            } catch (Exception e) {
                System.out.println("Archivo no pudo ser leido ingrese un nuevo path");
            }
        }
        return null;
    }

    public static void mostrarResultados(String nombreAlgoritmo, int numCoincidencia, ArrayList<Integer> lineasCoincidencia, ArrayList<ArrayList<Integer>> arrayPosiciones, ArrayList<char[]> patronBuscado, double tiempoTotal) {

        System.out.println("Para el algoritmo " + nombreAlgoritmo + " se encontraron " + numCoincidencia
                + " coincidencias y la busqueda tomó " + tiempoTotal + " milisegundos");

        System.out.println("Las coincidencias encontradas para el algoritmo " + nombreAlgoritmo
                + " fueron las siguientes:");

        for (int i = 0; i < numCoincidencia; i++) {
            System.out.print("Coincidencia " + (i + 1) + " en la linea " + lineasCoincidencia.get(i)
                    + " en la posición(es) " + arrayPosiciones.get(i) + " del patron: ");
            System.out.println(patronBuscado.get(i));
        }
    }

}
