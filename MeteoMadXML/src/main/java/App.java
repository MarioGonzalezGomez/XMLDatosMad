import io.DatosMesReader;

import java.io.File;

public class App {
    public static void main(String[] args) {

        String urlMeteo = System.getProperty("user.dir") + File.separator + "XMLDatosMad" + File.separator + "data" + File.separator + "calidad_aire_datos_meteo_mes.csv";
        DatosMesReader.leerMedicionesMensuales(urlMeteo);

        DatosMesReader.leerMedicionesMensuales(urlMeteo).stream().forEach(e -> {
            e.toString();

        });
    }
}
