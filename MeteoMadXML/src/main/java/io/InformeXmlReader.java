package io;


import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class InformeXmlReader {

    /**
     * Un método de lectura XML utilizando DOM. Devuelve un Document con los datos
     * que nos serán útiles para procesarlos y sacarlos a distintos informes
     *
     * @return
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public Document leerInforme() throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document d = db.parse(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator +
                "java" + File.separator + "db" + File.separator + "mediciones.xml");
        return d;
    }
}
