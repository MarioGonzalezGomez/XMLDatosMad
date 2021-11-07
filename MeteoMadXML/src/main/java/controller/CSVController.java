package controller;

import lombok.NonNull;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CSVController {

    private static CSVController controller;
    private String uri=null;
    private Document data = null;
    private List<Element> listaElementos = new ArrayList<>();
    private BufferedReader bf =null;

    private CSVController(String uri) {
        this.uri=uri;
    }

    /**
     * Obtiene una instancia del controlador
     *
     * @param uri
     * @return
     */
    public static CSVController getInstance(@NonNull String uri) {

        if (controller == null)
            controller = new CSVController(uri);
        return controller;
    }

    public void createLector() throws IOException {
        this.data = new Document();
        this.data.setRootElement(new Element("mediciones"));

        try {
            this.bf = new BufferedReader(new FileReader(this.uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void convertCSVtoXML() throws IOException {

        createLector();
        String line = null;
        try {
            while ((line = this.bf.readLine()) != null) { //***********************************//
                if (!line.contains("provincia")) {
                    line = line.replaceAll(";;", ";null;");
                    StringTokenizer tokens = new StringTokenizer(line, ";");
                    while (tokens.hasMoreTokens()) {
                        Element medicionElement = new Element("medicion");
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

                            medicionElement.addContent(new Element("h" + contador).setText(tokens.nextToken()));
                            medicionElement.addContent(new Element("v" + contador).setText(tokens.nextToken()));
                            contador++;
                        }
                        listaElementos.add(medicionElement);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = (Element) this.data.getRootElement();
        root.addContent(listaElementos);

    }

    private XMLOutputter preProcess() {
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        return xmlOutput;
    }

    public void writeXMLFile(String uri) throws IOException {
        XMLOutputter xmlOutput = this.preProcess();
        xmlOutput.output(this.data, new FileWriter(uri));
        System.out.println("Fichero XML generado con éxito");
        controller=null;

    }


}
