import controller.CSVController;
import controller.InformeController;
import controller.MeteoController;
import controller.XMLController;
//import io.HtmlWriter;
import model.InformacionMedicion;
import model.Medicion;
import org.jdom2.JDOMException;
import service.Utiles;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
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


        String urlXMLTemperatura = System.getProperty("user.dir") + File.separator + "MeteoMadXML" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Temperatura.xml";
        String urlXMLContaminacion = System.getProperty("user.dir") + File.separator + "MeteoMadXML" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Contaminacion.xml";
        String urlCSVMeteo = System.getProperty("user.dir") + File.separator + "MeteoMadXML" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "calidad_aire_datos_meteo_mes.csv";
        String urlCSVContaminacion = System.getProperty("user.dir") + File.separator + "MeteoMadXML" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "calidad_aire_datos_mes.csv";

        //Luego lo adaptamos para que se pida mediante args. Pero por ahora lo pongo como un string de entrada a los lectores
        String ciudad = Utiles.normalizar("Móstoles");


        CSVController CSVContaminacion = CSVController.getInstance(urlCSVContaminacion);
        CSVContaminacion.convertCSVtoXML();
        CSVContaminacion.writeXMLFile(urlXMLContaminacion);


        CSVController CSVTemperatura = CSVController.getInstance(urlCSVMeteo);
        CSVTemperatura.convertCSVtoXML();
        CSVTemperatura.writeXMLFile(urlXMLTemperatura);


        //Carga los datos del xml para mapearlos
        XMLController xmlTemperatura = XMLController.getInstance(urlXMLTemperatura);
        xmlTemperatura.loadData();

        XMLController xmlContaminacion = XMLController.getInstance(urlXMLContaminacion);
        xmlContaminacion.loadData();



        InformeController informe = InformeController.getInstance();

        List<Medicion>listaTemperatura = xmlTemperatura.getMedicionesPorCiudad(ciudad);
        List<Medicion>listaContaminacion = xmlContaminacion.getMedicionesPorCiudad(ciudad);
        informe.generarXMLbbdd(ciudad,listaTemperatura,listaContaminacion);

        //long initTime = System.currentTimeMillis();
        //HtmlWriter htmlW = new HtmlWriter();
    }
}
//}

