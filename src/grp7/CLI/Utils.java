package grp7.CLI;

import grp7.metodosDeBusqueda.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Utils {

    /**
     * Retorna un ArrayList con los patrones ingresados por consola.
     */
    public static ArrayList<String> leerPatrones() {
        int numPatrones;
        ArrayList<String> patrones = new ArrayList<>();
        Scanner leerNumPatrones = new Scanner(System.in);
        //El Scanner considera la codificación "ISO-8859-1" para los carácteres del alfabeto latino.
        //Scanner leerPatron = new Scanner(System.in, "UTF-8");
        Scanner leerPatron = new Scanner(System.in, "ISO-8859-1");
        System.out.println("Ingrese el número de Patrones");
        numPatrones = leerNumPatrones.nextInt();
        for (int i = 0; i < numPatrones; i++) {
            System.out.println("Ingrese el patron " + (i + 1));
            patrones.add(leerPatron.nextLine());
        }
        return patrones;
    }

    /**
     * Retorna un String con el texto del archivo.
     */
    public static String leerArchivo() {
        String pathArchivo;
        BufferedReader br = null;
        Scanner in = new Scanner(System.in);
        String texto = "";
        String linea;
        while (br == null) {
            try {
                System.out.println("Ingrese el path al archivo:");
                pathArchivo = in.nextLine();
                File archivo = new File(pathArchivo);
                FileInputStream fis = new FileInputStream(archivo);
                //Mediante el InputStreamReader se leen archivos en codificación UTF-8 (incluye caracteres no ASCII).
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                br = new BufferedReader(isr);
                while ((linea = br.readLine()) != null) {
                    //System.out.println(linea);
                    texto += linea + "\n";
                }
            } catch (Exception e) {
                System.out.println("Archivo no pudo ser leido ingrese un nuevo path");
            }
        }
        return texto;
    }

    /**
     * Retorna un Arraylist con los Algoritmos seleccionados por consola.
     */
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
                        if (algoritmos.isEmpty()) {
                            System.out.println("Debe escoger al menos un algoritmo");
                            opcion = 0;
                        } else {
                            System.out.println("Fin selección");
                        }
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
}
