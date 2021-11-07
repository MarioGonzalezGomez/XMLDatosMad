package controller;

import model.Medicion;
import model.MedicionHora;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;


public class MedicionController {

    public void procesarDatos(List<Medicion> mediciones) {
        mediciones.stream().map(Medicion::getMedicionesHoras).forEach(this::mapear);

    }

    public DoubleSummaryStatistics mapear(List<MedicionHora> mh) {
        DoubleSummaryStatistics dss = mh.stream().collect(Collectors.summarizingDouble(x -> x.getMedicion()));
        return dss;
    }
}
