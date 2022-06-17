
import grp7.metodosDeBusqueda.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws IOException {
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
                case 4:{
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

    public static void buscarPatron( int algoritmo) throws IOException {
        int numCoincidencia = 0;
        String nombreAlgoritmo = "";
        String nombreArchivo;
        double tiempoTotal = 0; 
       ArrayList<Integer> lineasCoincidencia = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayPosiciones = new ArrayList<>();
        ArrayList<char[]> patronBuscado = new ArrayList<>();
        nombreArchivo = leerArchivo();
        ArrayList<char[]> patrones = leerPatrones();
        for (int i = 0; i < patrones.size(); i++) {
            BufferedReader br = null;
            try {
                int contadorLinea = 1;
                char[] texto;
                br = new BufferedReader(new FileReader(nombreArchivo));
                String textoAux;
                long tiempoInicio = System.currentTimeMillis();
                while ((textoAux = br.readLine()) != null) {
                    ArrayList<Integer> posiciones = new ArrayList<Integer>();
                    texto = textoAux.toCharArray();
                    if (algoritmo == 1) {
                        nombreAlgoritmo = "Fuerza Bruta";
                        posiciones = BF.buscarCoincidenciasBF(texto, patrones.get(i));
                    } else if (algoritmo == 2) {
                        nombreAlgoritmo = "Boyer Moore";
                        posiciones = BM.buscarCoincidenciasBM(texto, patrones.get(i));
                    } else if (algoritmo == 3) {
                        nombreAlgoritmo = "KMP";
                        posiciones = KMP.buscarCoincidenciasKMP(texto, patrones.get(i));
                    }
                    if (posiciones.size() > 0) {
                        lineasCoincidencia.add(contadorLinea);
                        arrayPosiciones.add(posiciones);
                        patronBuscado.add(patrones.get(i));
                        numCoincidencia++;
                    }
                    contadorLinea++;
                }
                long tiempoFin = System.currentTimeMillis();
                tiempoTotal = (double)(tiempoFin - tiempoInicio);
            } catch (Exception ex) {
                System.out.println(ex.toString());
            } finally {
                if (null != br) {
                    br.close();
                }
            }
        }
        mostrarResultados(nombreAlgoritmo, numCoincidencia, lineasCoincidencia, arrayPosiciones, patronBuscado, tiempoTotal);
    }

    public static ArrayList<char[]> leerPatrones() {
        int numPatrones = 0;
        ArrayList<char[]> patrones = new ArrayList<char[]>();
        Scanner leerNumPatrones = new Scanner(System.in);
        Scanner leerPatron = new Scanner(System.in);
        System.out.println("Ingrese el número de Patrones");
        numPatrones = leerNumPatrones.nextInt();

        for (int i = 0; i < numPatrones; i++) {
            System.out.println("Ingrese el patron " + (i+1));
            char[] aux = leerPatron.nextLine().toCharArray();
            patrones.add(aux);
        }
        return patrones;
    }

    public static String leerArchivo() {
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int resultado = selectorArchivos.showOpenDialog(null);

        File archivo = selectorArchivos.getSelectedFile();
        if ((archivo == null) || (archivo.getName().equals(""))) {
            JOptionPane.showMessageDialog(null, "Archivo inválido");
        }
        String nombre = archivo.getPath();
        System.out.println("El nombre del archivo escogido es: " + archivo.getName());
        return nombre;
    }

    public static void mostrarResultados(String nombreAlgoritmo, int numCoincidencia, ArrayList<Integer> lineasCoincidencia, ArrayList<ArrayList<Integer>> arrayPosiciones, ArrayList<char[]> patronBuscado, double tiempoTotal) {

        System.out.println("Para el algoritmo " + nombreAlgoritmo + " se encontraron " + numCoincidencia
                + " coincidencias y la busqueda tomó " + tiempoTotal + " milisegundos");

        System.out.println("Las coincidencias encontradas para el algoritmo " + nombreAlgoritmo
                + " fueron las siguientes:");

        for (int i = 0; i < numCoincidencia; i++) {
            System.out.print("Coincidencia " + (i+1) + " en la linea " + lineasCoincidencia.get(i)
                    + " en la posición(es) " + arrayPosiciones.get(i) + " del patron: ");
            System.out.println(patronBuscado.get(i));
        }
    }

}
