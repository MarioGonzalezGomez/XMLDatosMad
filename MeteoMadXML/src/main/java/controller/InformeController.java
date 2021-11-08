package controller;

import model.InformacionMedicion;
import model.Medicion;
import model.MedicionHora;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class InformeController {

    public void generarInforme() {
        MeteoController meteoController = new MeteoController();




    }

    public static InformacionMedicion generarEstadisticas(List<Medicion> medicionesPorEstadistica) {
        DoubleSummaryStatistics estadisticas;
        InformacionMedicion infoMedicion = new InformacionMedicion();
        List<DoubleSummaryStatistics> listaEstadisticas = new ArrayList<>();
        //PROBLEMA : en estadisticas solo se introducen 24, las de 1 dia. Necesito las 24 de los 27 dias.

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











