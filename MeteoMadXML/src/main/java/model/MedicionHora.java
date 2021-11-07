package model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
public class MedicionHora {
    private Double medicion;
    private String hora;
    private String nulo;

    public MedicionHora(Double medicion, String hora) {
        this.medicion = medicion;
        this.hora = hora;

    }
    public MedicionHora(String nulo){
        this.nulo=nulo;


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
