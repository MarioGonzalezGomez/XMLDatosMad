package Tema2_xml.model;

import java.util.List;

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


    public Medicion(String provincia, String municipio, String estacion, float magnitud, String puntoMuestreo, int anio, int mes, int dia, List<MedicionHora> medicionesHoras) {
        this.provincia = provincia;
        this.municipio = municipio;
        this.estacion = estacion;
        this.magnitud = magnitud;
        this.puntoMuestreo = puntoMuestreo;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        MedicionesHoras = medicionesHoras;
    }

    public Medicion() {
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public Float getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(Float magnitud) {
        this.magnitud = magnitud;
    }

    public String getPuntoMuestreo() {
        return puntoMuestreo;
    }

    public void setPuntoMuestreo(String puntoMuestreo) {
        this.puntoMuestreo = puntoMuestreo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public List<MedicionHora> getMedicionesHoras() {
        return MedicionesHoras;
    }

    public void setMedicionesHoras(List<MedicionHora> medicionesHoras) {
        MedicionesHoras = medicionesHoras;
    }

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