import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MiLectorJSON {

    public static void main(String[] args) {
        String filePath = "src/main/java/datosUsuarios.json";
        String filePathModificado = "src/main/java/datosUsuarioModificado.json";

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject objetoJSON = new JSONObject(content);
            JSONArray habilidades  = objetoJSON.getJSONArray("habilidades");
            // Acceder al elemento "nombre" y mostrarlo:
            String nombre = objetoJSON.getString("nombre");
            System.out.println("El nombre en el JSON es: " + nombre);

            System.out.println("Habilidades actuales: " + habilidades);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese nueva habilidad de la persona" + nombre + ": ");
            String nuevaHabilidad = scanner.nextLine();

            habilidades.put(nuevaHabilidad);
            System.out.println("Habilidad modificadas: " + habilidades);


            Files.write(Paths.get(filePathModificado), objetoJSON.toString(4).getBytes());
            System.out.println("Datos guardados en el fichero: " + filePathModificado);
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}

