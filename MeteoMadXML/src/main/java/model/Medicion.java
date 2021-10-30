package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicion {
    private String provincia;
    private String municipio;
    private String estacion;
    private Float magnitud;
    private String puntoMuestreo;
    private int anio;
    private int mes;
    private int dia;
    List<MedicionHora> MedicionesHoras;

    @Override
    public String toString() {
        return "Medicion{" +
                "provincia='" + provincia + '\'' +
                ", municipio='" + municipio + '\'' +
                ", estacion='" + estacion + '\'' +
                ", magnitud=" + magnitud +
                ", puntoMuestreo='" + puntoMuestreo + '\'' +
                ", anio=" + anio +
                ", mes=" + mes +
                ", dia=" + dia +
                ", MedicionesHoras=" + MedicionesHoras +
                '}';
    }
}
