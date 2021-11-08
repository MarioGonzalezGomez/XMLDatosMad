package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


public class Informe {
    private String uuid;
    private String nombreCiudad;
    private String fecha;

    private List<InformacionMedicion> informacionMeteorologica; //MeteoController.getEstatisticsMeteo
    private List<InformacionMedicion> informacionContaminacion;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<InformacionMedicion> getInformacionMeteorologica() {
        return informacionMeteorologica;
    }

    public void setInformacionMeteorologica(List<InformacionMedicion> informacionMeteorologica) {
        this.informacionMeteorologica = informacionMeteorologica;
    }

    public List<InformacionMedicion> getInformacionContaminacion() {
        return informacionContaminacion;
    }

    public void setInformacionContaminacion(List<InformacionMedicion> informacionContaminacion) {
        this.informacionContaminacion = informacionContaminacion;
    }
}