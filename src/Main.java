
/**
 *
 * @author Nicolas Burbano
 * @author Jhon Maiza
 * @author Cesar Tufino
 */
import grp7.GUI.MainGui;
import grp7.CLI.MainCli;

public class Main {

    public static void main(String[] args) {
        String op = "gui";
        try {
            op = args[0];
        } catch (Exception e) {
        }
        switch (op) {
            case "cli":
                MainCli.main(args);
                break;
            case "gui":
                MainGui.main(args);
                break;
        }
    }
}
