package controller;


import lombok.NonNull;
import model.Medicion;
import model.MedicionHora;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import service.MapeoCiudadCodigo;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Clase que convierte los xml en objetos con el parser JAXB
 */
public class XMLController {
    private static XMLController controller=null;
    private String uri=null;
    private Document data=null;

    //Se le pasa la uri del XML que vamos a mapear
    private XMLController(String uri) {
        this.uri = uri;
    }

    public static XMLController getInstance(@NonNull String uri) {
            controller = new XMLController(uri);
        return controller;
    }

    public void loadData() throws IOException, JDOMException {
        data= new Document();
        this.data=data;
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(this.uri);
        this.data = builder.build(xmlFile);
    }

    //Se le pasa una <medicion> y se mapean sus hijos
    public List<Medicion> getMedicionesPorCiudad(String ciudad) {
        Element root = this.data.getRootElement();
        List<Element> listaMediciones = root.getChildren("medicion");
        List<Medicion> medicionesLista = new ArrayList<>();

        MapeoCiudadCodigo mcc = new MapeoCiudadCodigo();

//============================METERLE UN FILTRO POR CIUDAD =============================//

        listaMediciones.stream().filter(x -> x.getChild("puntoMuestreo").getText().substring(0, 8).equals(mcc.mapearCiudadCodigo().get(ciudad))).forEach(medicionElement -> {
            Medicion medicion = new Medicion();
            medicion.setProvincia(medicionElement.getChildText("provincia"));
            medicion.setMunicipio(medicionElement.getChildText("municipio"));
            medicion.setEstacion(medicionElement.getChildText("estacion"));
            medicion.setMagnitud(Integer.parseInt(medicionElement.getChildText("magnitud")));
            medicion.setPuntoMuestreo(medicionElement.getChildText("puntoMuestreo"));
            medicion.setAnio(Integer.parseInt(medicionElement.getChildText("anio")));
            medicion.setMes(Integer.parseInt(medicionElement.getChildText("mes")));
            medicion.setDia(Integer.parseInt(medicionElement.getChildText("dia")));

            for (int i = 1; i <= 24; i++) {
                if (!medicionElement.getChildText("h" + i).contains("null")) {
                    NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
                    try {
                        double med = nf.parse(medicionElement.getChildText("h" + i)).doubleValue();
                        MedicionHora medicionHora = new MedicionHora(med, i + "Horas");
                        medicion.getMedicionesHoras().add(medicionHora);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {

                    MedicionHora medicionHora = new MedicionHora(null, null);
                    medicion.getMedicionesHoras().add(medicionHora);
                }

            }


            medicionesLista.add(medicion);
            //System.out.println(medicion);
        });
        return medicionesLista;
    }
}

