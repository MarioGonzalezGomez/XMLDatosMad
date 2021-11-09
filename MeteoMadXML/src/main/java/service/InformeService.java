package service;

import model.*;
import org.jdom2.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Esta clase trabaja con la generacion del informe que se escribirá en una base de datos en formato xml.
 */
public class InformeService {

    private static InformeService instance;
    private Marshaller marshaller;
    private Informe informe;
    private String uri = System.getProperty("user.dir") + File.separator + "MeteoMadXML" + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "db" + File.separator + "mediciones.xml";
    private final File file = new File(uri);
    private Document doc;

    private InformeService() {
    }

    /**
     * Devuelve la instancia del controlador
     *
     * @return
     */
    public static InformeService getInstance() {
        if (instance == null) {
            instance = new InformeService();
        }
        return instance;
    }


    /**
     * Genera la base de datos en formato xml, añadiendole los datos ya procesados.
     *
     * @param ciudad
     * @param meteo
     * @param conta
     * @throws JAXBException
     */
    public void generarXMLbbdd(String ciudad, MeteoService meteo, ContaminacionService conta) throws JAXBException {

        System.out.println("Se están cargando los datos en la base de datos mediciones.xml");
        Informe informe = new Informe();
        Informes informes = new Informes();
        informe.setUuid(java.util.UUID.randomUUID().toString());
        informe.setNombreCiudad(ciudad);
        informe.setFecha("fechita");
        informe.setInformacionMeteorologica(meteo.getEstatisticsMeteo());
        informe.setInformacionContaminacion(conta.getEstatisticsConta());
        informes.getListaInformes().add(informe);
        JAXBContext context = JAXBContext.newInstance(Informes.class);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(informe, file);

        System.out.println("Los datos se han cargado con éxito");

    }

    /**
     * Genera las estadisticas de las listas de mediciones que se le pasen por parametro.
     *
     * @param medicionesPorEstadistica
     * @return
     */
    public static InformacionMedicion generarEstadisticas(List<Medicion> medicionesPorEstadistica) {
        InformacionMedicion infoMedicion = new InformacionMedicion();

        String nombre = null;
        if (medicionesPorEstadistica.size() != 0) {
            DoubleSummaryStatistics estadisticas;
            List<DoubleSummaryStatistics> listaEstadisticas = new ArrayList<>();

            for (Medicion med : medicionesPorEstadistica
            ) {
                estadisticas = med.getMedicionesHoras().stream()
                        .filter(me -> me.getMedicion() != null)
                        .collect(Collectors.summarizingDouble(MedicionHora::getMedicion));

                listaEstadisticas.add(estadisticas);
                nombre = med.getNombreMedicion();

            }

            Double maxMax = listaEstadisticas.stream().map(x -> x.getMax()).max(Double::compareTo).orElseThrow(NoSuchElementException::new);
            Double minMin = listaEstadisticas.stream().map(x -> x.getMin()).min(Double::compareTo).orElseThrow(NoSuchElementException::new);
            Double media = listaEstadisticas.stream().map(x -> x.getAverage()).mapToDouble(x -> x).average().getAsDouble();


            infoMedicion.setNombreMedicion(nombre);
            infoMedicion.setMomentoYMaxima(new MedicionHora(maxMax));
            infoMedicion.setMomentoYMinima(new MedicionHora(minMin));
            infoMedicion.setMediaMensual(media);


            return infoMedicion;
        } else
            infoMedicion.setNombreMedicion("No hay registros");

        return infoMedicion;
    }

}











