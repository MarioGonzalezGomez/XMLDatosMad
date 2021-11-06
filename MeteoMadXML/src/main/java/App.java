import controller.MedicionesController;
import io.DatosMesReader;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        String urlXML="C:\\Users\\neago\\IdeaProjects\\ACCESO-A-DATOS\\XMLDatosMad\\MeteoMadXML\\src\\main\\resources\\xmlgenerado.xml";

        String urlCSV="C:\\Users\\neago\\IdeaProjects\\ACCESO-A-DATOS\\XMLDatosMad\\MeteoMadXML\\src\\main\\resources\\calidad_aire_datos_meteo_mes.csv";
        //String urlMeteo = System.getProperty("user.dir") + File.separator + "MeteoMadXML" + File.separator +"src"+ File.separator+ "resources"+File.separator+ "calidad_aire_datos_meteo_mes.csv";
        MedicionesController controller = MedicionesController.getInstance(urlCSV);
        controller.convertCSVtoXML(urlCSV);
        controller.writeXMLFile(urlXML);




    }
}
