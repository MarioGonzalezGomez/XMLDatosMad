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




    public void generarXMLbbdd(String ciudad, MeteoController meteo, ContaminacionController conta) throws JAXBException {
        String uri = System.getProperty("user.dir")+File.separator+"MeteoMadXML"+ File.separator+ "src"+File.separator+"main"+File.separator+"java"+File.separator+"db"+File.separator+"mediciones.xml";

        Informe informe = new Informe();
        informe.setUuid(java.util.UUID.randomUUID().toString());
        informe.setNombreCiudad(ciudad);
        informe.setFecha("fechita");
        informe.setInformacionMeteorologica(meteo.getEstatisticsMeteo());
        informe.setInformacionContaminacion(conta.getEstatisticsConta());

        JAXBContext context = JAXBContext.newInstance(Informe.class);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(informe,new File(uri));

    }

    public static InformacionMedicion generarEstadisticas(List<Medicion> medicionesPorEstadistica) {
        InformacionMedicion infoMedicion = new InformacionMedicion();

        if(medicionesPorEstadistica.size()!=0) {
            DoubleSummaryStatistics estadisticas;
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
        }else return infoMedicion;
    }

    public static void crearEstadisticas(List<Medicion> medicionesPorEstadistica) {


        List<MedicionHora>medicionesHora = new ArrayList<>();
      DoubleSummaryStatistics medicion;
        for (Medicion med : medicionesPorEstadistica
        ) {


        }



    }




}











