package controller;

import model.*;

import java.util.*;
import java.util.stream.Collectors;


public class MeteoController {

    MedicionesMeteo medicionesMeteo = new MedicionesMeteo();

    /**
     * Este método filtra las mediciones por magnitud,sacamos entonces listas de magnitudes con todas sus mediciones para las estadisticas
     *
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


    public List<InformacionMedicion> getEstatisticsMeteo() {

        List<InformacionMedicion> listaEstadisticas = new ArrayList<>();

        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesMeteo.getVelocidadViento()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesMeteo.getDireccionViento()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesMeteo.getTemperatura()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesMeteo.getHumedadRelativa()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesMeteo.getPresionAtmosferica()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesMeteo.getRadiacionSolar()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesMeteo.getPrecipitacion()));

        return listaEstadisticas;


    }

}





