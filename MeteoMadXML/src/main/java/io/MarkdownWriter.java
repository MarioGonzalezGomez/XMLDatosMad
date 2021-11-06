package io;


import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class MarkdownWriter {
    private InformeXmlReader ixr;
    private List<String> nombreCiudades;
    String nombreDoc;

    /**
     * Un escritor que genera un archivo markdown en resources con los datos aportados en una List<String>
     */
    public void generarMarkdown() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException, JDOMException {
        List<String> texto = procesarMarkdown();
        nombreDoc = "informe";
        nombreCiudades.forEach(x -> nombreDoc = nombreDoc + "-" + x);
        Path path = Paths.get(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
                + "resources" + File.separator + "informes" + File.separator + nombreDoc + ".md");
        Files.write(path, texto, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

    }

    /**
     * Genere una lista de tipo String cargando en ella los datos del informe, precedidos de sus respectivas etiquetas markdown para darle formato.
     * Para la lectura de los datos, utiliza expresiones XPath
     *
     * @return List<String> con el texto del .md
     * @throws XPathExpressionException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    private List<String> procesarMarkdown() throws XPathExpressionException, ParserConfigurationException, IOException, JDOMException, SAXException {
        List<String> textoMd = new LinkedList<>();
        Document d = ixr.leerInforme();
        XPath xp = XPathFactory.newInstance().newXPath();
        NodeList ciudades = (NodeList) xp.compile("//resultado").evaluate(d, XPathConstants.NODESET);

        for (int i = 0; i < ciudades.getLength(); i++) {

            nombreCiudades.add(xp.compile("./ciudad").evaluate(ciudades.item(i)));

            textoMd.add("##Informe de " + xp.compile("./ciudad").evaluate(ciudades.item(i)));
            textoMd.add("-Fecha de inicio de la medición: " + xp.compile("./fxinicio").evaluate(ciudades.item(i)));
            textoMd.add("-Fecha de fin de la medición: " + xp.compile("./fxfin").evaluate(ciudades.item(i)));
            textoMd.add("---");
            textoMd.add("##Datos Meteorológicos");
            textoMd.add("####Medias mensuales");
            textoMd.add("-Precipitación: " + xp.compile("./datos-meteorologicos/precipitacion/media").evaluate(ciudades.item(i)));
            //... no olvidar los - para que sea lista.
            textoMd.add("---");
            textoMd.add("##Datos de Contaminación");
            textoMd.add("####Medias mensuales");
            textoMd.add("-Dióxido de azufre: " + xp.compile("./datos-contaminacion/dioxido-azufre/media").evaluate(ciudades.item(i)));
            //... no olvidar los - para que sea lista.
        }
        return textoMd;
    }
}
