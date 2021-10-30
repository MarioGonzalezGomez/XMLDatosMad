package Tema2_xml.model;

import java.sql.Time;

public class MedicionHora {
private float meidicion;
private Time hora;
private String valida;

    public MedicionHora() { }

    public MedicionHora(float medicion, String valida, Time hora) {
        this.meidicion = medicion;
        this.hora = hora;
        this.valida=valida;

    }

}
