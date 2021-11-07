import controller.CSVController;
import controller.MeteoController;
import controller.XMLController;
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

        String urlXMLTemperatura = System.getProperty("user.dir") + File.separator + "MeteoMadXML"+ File.separator+"src" + File.separator + "main" + File.separator + "resources" + File.separator + "Temperatura.xml";
        String urlXMLContaminacion = System.getProperty("user.dir") + File.separator + "MeteoMadXML"+ File.separator+ "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Contaminacion.xml";
        String urlCSVMeteo = System.getProperty("user.dir") + File.separator+ "MeteoMadXML"+ File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "calidad_aire_datos_meteo_mes.csv";
        String urlCSVContaminacion = System.getProperty("user.dir") + File.separator + "MeteoMadXML"+ File.separator+ "src" + File.separator + "main" + File.separator + "resources" + File.separator + "calidad_aire_datos_mes.csv";

        //Luego lo adaptamos para que se pida mediante args. Pero por ahora lo pongo como un string de entrada a los lectores
        String ciudad = Utiles.normalizar("Móstoles");


        CSVController CSVContaminacion = CSVController.getInstance(urlCSVContaminacion);
        CSVContaminacion.convertCSVtoXML();
        CSVContaminacion.writeXMLFile(urlXMLContaminacion);
       // XMLController XMLContaminacion = XMLController.getInstance(urlXMLContaminacion);
       // XMLContaminacion.loadData();


        CSVController CSVTemperatura = CSVController.getInstance(urlCSVMeteo);
        CSVTemperatura.convertCSVtoXML();
        CSVTemperatura.writeXMLFile(urlXMLTemperatura);
        XMLController xmlTemperatura = XMLController.getInstance(urlXMLTemperatura);
        xmlTemperatura.loadData();
        MeteoController mc = new MeteoController();
        mc.filtrarMagnitudesTemperatura(xmlTemperatura.getMedicionesPorCiudad(ciudad));
        List<InformacionMedicion> infor = mc.getEstatisticsMeteo();






        //long initTime = System.currentTimeMillis();
        //HtmlWriter htmlW = new HtmlWriter();





    }
}
