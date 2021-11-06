package io;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlReader {

    public Document leerXml(String nombreArchivo) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document d = db.parse(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
                + "resources" + File.separator + "resources" + File.separator + nombreArchivo);
        return d;
    }
    //Esto luego en el método donde proceses la info. Si no te convence usamos otro parse. Esto es dom. Para leer el 4 ya he usado sax y jdom, por eso lo de variar.
    // Document meteo = xr.leerXml("temperatura.xml");
    //        Element rootMeteo = meteo.getDocumentElement();
    //        NodeList nlMeteo = rootMeteo.getChildNodes();
    //        Document cont = xr.leerXml("contaminacion.xml");
    //        Element rootCont = cont.getDocumentElement();
    //        NodeList nlCont = rootCont.getChildNodes();
}
