import controller.*;
import io.HtmlWriter;
import io.HtmlWriter;
import model.InformacionMedicion;
import model.Medicion;
import org.jdom2.JDOMException;
//import service.GeneradorGraficas;
import service.Utiles;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, JDOMException, JAXBException {
// + File.separator + "MeteoMadXML"
       /* if (args.length != 2) {
            System.out.println("Número de parámetros incorrecto: para usar este programa necesitas introducir dos parámetros: " +
                    "1.nombre de la ciudad de la que se desean obtener los datos " +
                    "2. directorio donde queremos guardar el informe resultante");
        } else {
            String ciudad = Utiles.normalizar(args[0]);
            Path ruta = Paths.get(args[1]);*/

        String uriResources =  System.getProperty("user.dir") + File.separator + "MeteoMadXML" + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        String CSV_meteo =uriResources+ File.separator + "calidad_aire_datos_meteo_mes.csv";
        String CSV_contaminacion = uriResources+ File.separator + "calidad_aire_datos_mes.csv";
        String OUTPUT_temperatura = uriResources+ File.separator + "Temperatura.xml";
        String OUTPUT_contaminacion = uriResources+ File.separator + "Contaminacion.xml";


        //Luego lo adaptamos para que se pida mediante args. Pero por ahora lo pongo como un string de entrada a los lectores
        String ciudad = Utiles.normalizar("Leganes");
        Path path = Paths.get("C:\\Users\\Mario\\Desktop\\AccesoDatos");


        CSVController CSVContaminacion = CSVController.getInstance(CSV_contaminacion);
        CSVContaminacion.convertCSVtoXML();
        CSVContaminacion.writeXMLFile(OUTPUT_contaminacion);
        CSVController CSVTemperatura = CSVController.getInstance(CSV_meteo);
        CSVTemperatura.convertCSVtoXML();
        CSVTemperatura.writeXMLFile(OUTPUT_temperatura);



        XMLController xmlTemperatura = XMLController.getInstance(OUTPUT_temperatura);
        xmlTemperatura.loadData();

        XMLController xmlContaminacion = XMLController.getInstance(OUTPUT_contaminacion);
        xmlContaminacion.loadData();

        //Meter esto en sus service




        MeteoController meteo = new MeteoController(xmlTemperatura.getMedicionesPorCiudad(ciudad));
        ContaminacionController conta = new ContaminacionController(xmlContaminacion.getMedicionesPorCiudad(ciudad));
        long initTime = System.currentTimeMillis();
       // GeneradorGraficas gg = new GeneradorGraficas();
        //gg.generarGraficas(meteo.getMedicionesMeteo());
       // HtmlWriter htmlW = new HtmlWriter();
        //htmlW.generarHtml(meteo.getEstatisticsMeteo(), conta.getEstatisticsConta(), initTime, ciudad, path);


        InformeController informe = InformeController.getInstance();
        informe.generarXMLbbdd(ciudad, meteo, conta);
        }
}


//decomentar htmlWriter y generador de graficas
//}

