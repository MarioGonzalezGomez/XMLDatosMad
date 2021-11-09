package controller;

import model.InformacionMedicion;
import model.Medicion;
import model.MedicionesContaminacion;

import java.util.ArrayList;
import java.util.List;

public class ContaminacionController {


    List<Medicion>listaConta = new ArrayList<>();
    MedicionesContaminacion medicionesContaminacion = new MedicionesContaminacion();

    public ContaminacionController(List<Medicion> listaConta) {
        this.listaConta=listaConta;
    }

    /**
     * Este método filtra las mediciones por magnitud,sacamos entonces listas de magnitudes con todas sus mediciones para las estadisticas
     *
     */
    public void filtrarMagnitudesContaminacion() {
        for (Medicion medicion : listaConta
        ) {

            switch (medicion.getMagnitud()) {
                case 1:
                    medicion.setNombreMedicion("Dióxido de azufre");
                    medicion.setUnidadMedida("m/s");
                    medicionesContaminacion.getDioxidoAzufre().add(medicion);
                    break;
                case 6:
                    medicion.setNombreMedicion("Monóxido de carbono");
                    medicion.setUnidadMedida("m/s");
                    medicionesContaminacion.getMonoxidoCarbono().add(medicion);

                    break;
                case 7:
                    medicion.setNombreMedicion("Monóxido de nitrógeno");
                    medicion.setUnidadMedida("m/s");

                    medicionesContaminacion.getMonoxidoNitrogeno().add(medicion);
                    break;
                case 8:
                    medicion.setNombreMedicion("Dióxido de nitrógeno");
                    medicion.setUnidadMedida("m/s");

                    medicionesContaminacion.getDioxidoNitrogeno().add(medicion);

                    break;
                case 9:
                    medicion.setNombreMedicion("Partículas en suspension < PM2,5");
                    medicion.setUnidadMedida("m/s");

                    medicionesContaminacion.getParticulas2_5().add(medicion);

                    break;
                case 10:
                    medicion.setNombreMedicion("Partículas en suspension < PM10");
                    medicion.setUnidadMedida("m/s");

                    medicionesContaminacion.getParticulas10().add(medicion);

                    break;
                case 12:
                    medicion.setNombreMedicion("Óxidos de nitrógeno");
                    medicion.setUnidadMedida("m/s");
                    medicionesContaminacion.getOxidosNitrogeno().add(medicion);
                    break;
                case 14:
                    medicion.setNombreMedicion("Ozono");
                    medicion.setUnidadMedida("m/s");
                    medicionesContaminacion.getOzono().add(medicion);
                    break;
                case 20:
                    medicion.setNombreMedicion("Tolueno");
                    medicion.setUnidadMedida("m/s");
                    medicionesContaminacion.getTolueno().add(medicion);
                    break;
                case 22:
                    medicion.setNombreMedicion("Black Carbon");
                    medicion.setUnidadMedida("m/s");
                    medicionesContaminacion.getBlackCarbon().add(medicion);
                    break;
                case 30:
                    medicion.setNombreMedicion("Benceno");
                    medicion.setUnidadMedida("m/s");
                    medicionesContaminacion.getBenceno().add(medicion);
                    break;
                case 42:
                    medicion.setNombreMedicion("Hidrocarburos totales");
                    medicion.setUnidadMedida("m/s");
                    medicionesContaminacion.getHicrocarburosTotales().add(medicion);
                    break;
                case 44:
                    medicion.setNombreMedicion("Hidrocarburos no metánicos");
                    medicion.setUnidadMedida("m/s");
                    medicionesContaminacion.getHidrocarburosNoMetanicos().add(medicion);
                    break;
                case 431:
                    medicion.setNombreMedicion("MetaParaxileno");
                    medicion.setUnidadMedida("m/s");
                    medicionesContaminacion.getMetaParaXileno().add(medicion);
                    break;


            }
        }
    }


    //Hay que refactorizar este código para que reciba por parametro una lista genérica y le genere las estadisticas solo a esa lista.
    //Desde otra clase se podrá usar este método dentro de un bucle que genere las estadísticas de todas las listas
    public List<InformacionMedicion> getEstatisticsConta() {
        filtrarMagnitudesContaminacion();
        List<InformacionMedicion> listaEstadisticas = new ArrayList<>();

        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getDioxidoAzufre()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getMonoxidoCarbono()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getMonoxidoNitrogeno()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getDioxidoNitrogeno()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getParticulas2_5()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getParticulas10()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getOxidosNitrogeno()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getOzono()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getTolueno()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getBlackCarbon()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getBenceno()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getHicrocarburosTotales()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getHidrocarburosNoMetanicos()));
        listaEstadisticas.add(InformeController.generarEstadisticas(medicionesContaminacion.getMetaParaXileno()));

        return listaEstadisticas;


    }

}





