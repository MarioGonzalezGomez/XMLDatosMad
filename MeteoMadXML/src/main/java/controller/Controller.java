package controller;

import io.HtmlWriter;
import org.jdom2.JDOMException;
import service.GeneradorGraficas;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Controller {


    public Controller(String ciudad, Path path) throws IOException, JDOMException, JAXBException {

        String uriResources =  System.getProperty("user.dir") + File.separator + "MeteoMadXML" + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        String CSV_meteo =uriResources+ File.separator + "calidad_aire_datos_meteo_mes.csv";
        String CSV_contaminacion = uriResources+ File.separator + "calidad_aire_datos_mes.csv";
        String OUTPUT_temperatura = uriResources+ File.separator + "Temperatura.xml";
        String OUTPUT_contaminacion = uriResources+ File.separator + "Contaminacion.xml";


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


        MeteoController meteo = new MeteoController(xmlTemperatura.getMedicionesPorCiudad(ciudad));
        ContaminacionController conta = new ContaminacionController(xmlContaminacion.getMedicionesPorCiudad(ciudad));
        long initTime = System.currentTimeMillis();

        GeneradorGraficas gg = new GeneradorGraficas();
        gg.generarGraficas(meteo.getMedicionesMeteo());
        HtmlWriter htmlW = new HtmlWriter();
        htmlW.generarHtml(meteo.getEstatisticsMeteo(), conta.getEstatisticsConta(), initTime, ciudad, path);


        InformeController informe = InformeController.getInstance();
        informe.generarXMLbbdd(ciudad, meteo, conta);
    }

    }

