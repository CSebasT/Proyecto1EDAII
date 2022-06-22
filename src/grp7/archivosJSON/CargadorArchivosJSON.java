package grp7.archivosJSON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class CargadorArchivosJSON {

    private ArrayList<String> arregloPatrones;
    private String texto;

    /**
     * Constructor de la clase auxiliar para cargar archivos JSON.
     */
    public CargadorArchivosJSON(File archivoPatrones) throws IOException {
        arregloPatrones = new ArrayList<>();
        texto = "";
        cargarArchivoJSON(archivoPatrones);
    }

    /**
     * Abre el archivo y obtiene el texto y los patrones que contiene.
     *
     * @param archivoPatrones archivo que se procesará.
     */
    private void cargarArchivoJSON(File archivoPatrones) throws IOException {
        String contenido = "";
        FileInputStream fis = new FileInputStream(archivoPatrones);
        //Mediante el InputStreamReader se leen archivos en codificación UTF-8.
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String linea;
        while ((linea = br.readLine()) != null) {
            contenido += linea + "\n";
        }
        JSONObject obj = new JSONObject(contenido);
        JSONArray arregloPatronesJSON = obj.getJSONArray("patrones");
        for (int i = 0; i < arregloPatronesJSON.length(); i++) {
            //Obtiene el arreglo de patrones.
            arregloPatrones.add(arregloPatronesJSON.getString(i));
        }
        //Obtiene el texto.
        texto = obj.getString("texto");
    }

    public ArrayList<String> getArregloPatrones() {
        return arregloPatrones;
    }

    public String getTexto() {
        return texto;
    }

}
