import controller.CSVController;
import controller.XMLController;
import model.Medicion;
import org.jdom2.JDOMException;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, JDOMException, JAXBException {

        String urlXMLTemperatura = System.getProperty("user.dir") +  File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Temperatura.xml";
        String urlXMLContaminacion = System.getProperty("user.dir")  + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Contaminacion.xml";

        String urlCSVMeteo = System.getProperty("user.dir")  + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "calidad_aire_datos_meteo_mes.csv";
        String urlCSVContaminacion = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "calidad_aire_datos_mes.csv";

    //=======================CONVERSION DE CSV A XML TEMPERATURA===============================//
        CSVController CSVTemperatura = CSVController.getInstance(urlCSVMeteo);
        CSVTemperatura.convertCSVtoXML();
        CSVTemperatura.writeXMLFile(urlXMLTemperatura);
        //=======================CONVERSION DE CSV A XML CONTAMINACION===============================//

        CSVController CSVContaminacion = CSVController.getInstance(urlCSVContaminacion);
        CSVContaminacion.convertCSVtoXML();
        CSVContaminacion.writeXMLFile(urlXMLContaminacion);

        //=======================MAPEO XML TEMPERATURA===============================//

        XMLController XMLTemperatura = XMLController.getInstance(urlXMLTemperatura);
        XMLTemperatura.loadData();


        //ESTAS LISTAS SON LAS QUE SE TIENEN QUE SACAR POR HTML. PD: SACAN TODOS LOS DATOS, NO FILTRADO AUN POR CIUDAD.
        List<Medicion>medicionesTemperatura=XMLTemperatura.getMedicionesPorCiudad();


        //=======================MAPEO XML CONTAMINACION===============================//
        XMLController XMLContaminacion = XMLController.getInstance(urlXMLContaminacion);
        XMLContaminacion.loadData();

        //ESTAS LISTAS SON LAS QUE SE TIENEN QUE SACAR POR HTML. PD: SACAN TODOS LOS DATOS, NO FILTRADO AUN POR CIUDAD.
        List<Medicion>medicionesContaminacion=XMLContaminacion.getMedicionesPorCiudad();
        


    }
}
