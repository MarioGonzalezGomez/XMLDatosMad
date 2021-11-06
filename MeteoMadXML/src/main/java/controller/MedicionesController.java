package controller;

import lombok.NonNull;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MedicionesController {

    private static MedicionesController controller;
    private final String uri;
    private Document data;

    private MedicionesController(String uri) {
        this.uri = uri;
    }

    /**
     * Obtiene una instancia del controlador
     *
     * @param uri
     * @return
     */
    public static MedicionesController getInstance(@NonNull String uri) {
        if (controller == null)
            controller = new MedicionesController(uri);
        return controller;
    }


    public void convertCSVtoXML(String uriCSV) throws IOException {
        this.data = new Document();
        this.data.setRootElement(new Element("Mediciones"));
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(uriCSV));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line =null;
        try {

                while (!((line = bf.readLine()) != null)){
                if (!line.contains("provincia")) {
                    StringTokenizer tokens = new StringTokenizer(line, ";");
                    while (tokens.hasMoreTokens()) {
                        Element medicionElement = new Element("Medicion");
                        medicionElement.addContent(new Element("provincia").setText(tokens.nextToken()));
                        medicionElement.addContent(new Element("municipio").setText(tokens.nextToken()));
                        medicionElement.addContent(new Element("estacion").setText(tokens.nextToken()));
                        medicionElement.addContent(new Element("magnitud").setText(tokens.nextToken()));
                        medicionElement.addContent(new Element("puntoMuestreo").setText(tokens.nextToken()));
                        medicionElement.addContent(new Element("anio").setText(tokens.nextToken()));
                        medicionElement.addContent(new Element("mes").setText(tokens.nextToken()));
                        medicionElement.addContent(new Element("dia").setText(tokens.nextToken()));
                        int contador = 01;
                        while (tokens.hasMoreTokens()) {

                            medicionElement.addContent(new Element("h"+contador).setText(tokens.nextToken()));
                            medicionElement.addContent(new Element("v"+contador).setText(tokens.nextToken()));
                            contador++;
                        }
                        Element root = (Element) this.data.getRootElement();
                        root.addContent(medicionElement);


                    }

                }
                bf.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //le da formato pretty al xml
    private XMLOutputter preProcess() {
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        return xmlOutput;
    }

    public void writeXMLFile(String uri) throws IOException {
        XMLOutputter xmlOutput = this.preProcess();
        xmlOutput.output(this.data, new FileWriter(uri));
        System.out.println("Fichero XML generado con éxito");
    }

    public void printXML() throws IOException {
        XMLOutputter xmlOutput = this.preProcess();
        xmlOutput.output(this.data, System.out);
    }


}