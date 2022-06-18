
import grp7.GUI.Main_gui;
import grp7.CLI.Main_cli;

public class Main {

    public static void main(String[] args) {
        String op = "gui";
        try {
            op = args[0];
        } catch (Exception e) {
        }
        switch (op) {
            case "cli":
                Main_cli.main(args);
                break;
            case "gui":
                Main_gui.main(args);
                break;
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
}
