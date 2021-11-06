package io;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;


public class InformeXmlReader {

    public Document leerInforme() throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document d = builder.build(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
                + "resources" + File.separator + "informes" + File.separator + "mediciones.xml");
        return d;
    }
}
