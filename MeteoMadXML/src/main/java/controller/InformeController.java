package controller;

import model.InformacionMedicion;
import model.Informe;
import model.Medicion;
import model.MedicionHora;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class InformeController {

    private static InformeController instance;
    private Marshaller marshaller;
    private Informe informe;

    private InformeController() {
    }

    /**
     * Devuelve la instancia del controlador
     *
     * @return
     */
    public static InformeController getInstance() {
        if (instance == null) {
            instance = new InformeController();
        }
        return instance;
    }




    public void generarXMLbbdd(String ciudad, List<Medicion>temperaturas, List<Medicion>contaminacion) throws JAXBException {

        MeteoController meteo = new MeteoController();
        meteo.filtrarMagnitudesTemperatura(temperaturas);

        ContaminacionController contraminacion = new ContaminacionController();
        contraminacion.filtrarMagnitudesContaminacion(contaminacion);

        JAXBContext context = JAXBContext.newInstance(Informe.class);
        marshaller = context.createMarshaller();

        Informe informe = new Informe();
        informe.setUuid(java.util.UUID.randomUUID().toString());
        informe.setNombreCiudad(ciudad);
        informe.setFecha("fechita");
        informe.setInformacionMeteorologica(meteo.getEstatisticsMeteo());
        informe.setInformacionContaminacion(contraminacion.getEstatisticsConta());


        marshaller.marshal(informe,System.out); //cambiar a una ruta
    }

    public static InformacionMedicion generarEstadisticas(List<Medicion> medicionesPorEstadistica) {
        DoubleSummaryStatistics estadisticas;
        InformacionMedicion infoMedicion = new InformacionMedicion();
        List<DoubleSummaryStatistics> listaEstadisticas = new ArrayList<>();

        for (Medicion med : medicionesPorEstadistica
        ) {
            estadisticas = med.getMedicionesHoras().stream()
                    .filter(me -> me.getMedicion() != null)
                    .collect(Collectors.summarizingDouble(MedicionHora::getMedicion));

            listaEstadisticas.add(estadisticas);

        }

        Double maxMax = listaEstadisticas.stream().map(x -> x.getMax()).max(Double::compareTo).orElseThrow(NoSuchElementException::new);
        Double minMin = listaEstadisticas.stream().map(x -> x.getMin()).min(Double::compareTo).orElseThrow(NoSuchElementException::new);
        Double media = listaEstadisticas.stream().map(x -> x.getAverage()).mapToDouble(x -> x).average().getAsDouble();


        infoMedicion.setMomentoYMaxima(new MedicionHora(maxMax));
        infoMedicion.setMomentoYMinima(new MedicionHora(minMin));
        infoMedicion.setMediaMensual(media);


        return infoMedicion;
    }


}











