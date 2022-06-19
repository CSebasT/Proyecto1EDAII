package grp7.archivosJSON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;

public class CargadorArchivosJSON {

    public ArrayList<String> cargarArchivoPatronesJSON(File archivoPatrones) throws IOException {
        ArrayList<String> arregloPatrones = new ArrayList<>();
        String contenido = "";
        FileInputStream fis = new FileInputStream(archivoPatrones);
        //Mediante el InputStreamReader s leen archivos en codificación UTF-8.
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String linea;
        while ((linea = br.readLine()) != null) {
            contenido += linea + "\n";
        }
        JSONObject obj = new JSONObject(contenido);
        JSONArray arregloPatronesJSON = obj.getJSONArray("arregloPatrones");
        for (int i = 0; i < arregloPatronesJSON.length(); i++) {
            arregloPatrones.add(arregloPatronesJSON.getJSONObject(i).getString("patron"));
        }
        return arregloPatrones;
    }

}
