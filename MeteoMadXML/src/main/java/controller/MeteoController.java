package controller;

import model.*;

import java.util.*;
import java.util.stream.Collectors;


public class MeteoController {

    MedicionesMeteo medicionesMeteo = new MedicionesMeteo();

    /**
     * Este método filtra las mediciones por magnitud,sacamos entonces listas de magnitudes con todas sus mediciones para las estadisticas
     * @param listaMedicionesTemperatura
     */
    public void filtrarMagnitudesTemperatura(List<Medicion> listaMedicionesTemperatura) {
        for (Medicion medicion : listaMedicionesTemperatura
        ) {

            switch (medicion.getMagnitud()) {
                case 81:
                    medicion.setNombreMedicion("Velocidad del viento");
                    medicion.setUnidadMedida("m/s");
                    medicionesMeteo.getVelocidadViento().add(medicion);
                    break;
                case 82:
                    medicion.setNombreMedicion("Direccion del viento");
                    medicion.setUnidadMedida("m/s");
                    medicionesMeteo.getDireccionViento().add(medicion);

                    break;
                case 83:
                    medicion.setNombreMedicion("Temperatura");
                    medicion.setUnidadMedida("m/s");

                    medicionesMeteo.getTemperatura().add(medicion);
                    break;
                case 86:
                    medicion.setNombreMedicion("Humedad relativa");
                    medicion.setUnidadMedida("m/s");

                    medicionesMeteo.getHumedadRelativa().add(medicion);

                    break;
                case 87:
                    medicion.setNombreMedicion("Presion atmosferica");
                    medicion.setUnidadMedida("m/s");

                    medicionesMeteo.getPresionAtmosferica().add(medicion);

                    break;
                case 88:
                    medicion.setNombreMedicion("Radiacion solar");
                    medicion.setUnidadMedida("m/s");

                    medicionesMeteo.getRadiacionSolar().add(medicion);

                    break;
                case 89:
                    medicion.setNombreMedicion("Precipitacion");
                    medicion.setUnidadMedida("m/s");
                    medicionesMeteo.getPrecipitacion().add(medicion);
                    break;

            }
        }
    }

    /**
     * Calcula las estadisticas de cada lista de magnitudes
     * @param medicionesPorEstadistica
     * @return
     */
    public InformacionMedicion generarEstadisticas(List<Medicion>medicionesPorEstadistica) {

        DoubleSummaryStatistics estadisticas = new DoubleSummaryStatistics();
        InformacionMedicion infoMedicion = new InformacionMedicion();

        //PROBLEMA : en estadisticas solo se introducen 24, las de 1 dia. Necesito las 24 de los 27 dias.

        for (Medicion med : medicionesPorEstadistica
        ) {
            estadisticas = med.getMedicionesHoras().stream()
                    .filter(me -> me.getMedicion() != null)
                    .collect(Collectors.summarizingDouble(MedicionHora::getMedicion));


        }

        infoMedicion.setMomentoYMaxima(String.valueOf(estadisticas.getMax()));
        infoMedicion.setMomentoYMinima(String.valueOf(estadisticas.getMin()));
        infoMedicion.setMediaMensual(estadisticas.getAverage());

        return infoMedicion;
    }


    public List<InformacionMedicion>getEstatisticsMeteo(){


        List<InformacionMedicion>listaEstadisticas = new ArrayList<>();

        listaEstadisticas.add(generarEstadisticas(medicionesMeteo.getVelocidadViento()));
        listaEstadisticas.add(generarEstadisticas(medicionesMeteo.getDireccionViento()));
        listaEstadisticas.add(generarEstadisticas(medicionesMeteo.getTemperatura()));
        listaEstadisticas.add(generarEstadisticas(medicionesMeteo.getHumedadRelativa()));
        listaEstadisticas.add(generarEstadisticas(medicionesMeteo.getPresionAtmosferica()));
        listaEstadisticas.add(generarEstadisticas(medicionesMeteo.getRadiacionSolar()));
        listaEstadisticas.add(generarEstadisticas(medicionesMeteo.getPrecipitacion()));

        return listaEstadisticas;




    }

    }









    /*public DoubleSummaryStatistics procesarDatos(List<Medicion> mediciones) {

         mediciones.stream()
                .map(Medicion::getMedicionesHoras)
                .forEach(this::mapear);


         return estadisticas;

    }

    public DoubleSummaryStatistics mapear(List<MedicionHora> mh) {

        this.estadisticas= new DoubleSummaryStatistics();
        DoubleSummaryStatistics dss = mh.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.summarizingDouble(MedicionHora::getMedicion));
        this.estadisticas.combine(dss);
        return dss;
    }*/

