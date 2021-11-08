package model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlType;
import java.sql.Time;

@Data
@NoArgsConstructor

@XmlType(propOrder = {"medicion", "hora"})
public class MedicionHora {
    private Double medicion;
    private String hora;
    private String nulo;

    public MedicionHora(Double medicion, String hora) {
        this.medicion = medicion;
        this.hora = hora;

    }
    public MedicionHora(Double medicion){
        this.medicion=medicion;


    }


    @Override
    public String toString() {
        if (medicion != null) {
            return
                    "Medicion= " + medicion +
                    ",  Hora= " + hora + '\'';

        } else {
            return
                    "Medicion= " + nulo;

        }
    }
}
