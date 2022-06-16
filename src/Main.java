
import grp7.metodosDeBusqueda.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        
        
        
        
        
        //Ejemplo de uso para el paquete grp7.metodosDeBusqueda.*
        char[] texto = "AAFMOFEDMSDABABACAADOANROAABABACA".toCharArray();
        char[] patron = "ABABACA".toCharArray();
        System.out.println(BM.buscarCoincidenciasBM(texto, patron));
        System.out.println(BM.calcularTablaD1(texto, patron));
        System.out.println(BF.buscarCoincidenciasBF(texto, patron));
        System.out.println(KMP.buscarCoincidenciasKMP(texto, patron));
        System.out.println(Arrays.toString(KMP.calcularFuncionFallo(patron)));
        
    }

}
