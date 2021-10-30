package model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
public class MedicionHora {
    private float medicion;
    private Time hora;
    private String valida;

    public MedicionHora(float medicion, String valida, Time hora) {
        this.medicion = medicion;
        this.hora = hora;
        this.valida= valida;

    }

}
