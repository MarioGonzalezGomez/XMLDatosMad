package Tema2_xml.model;

import java.time.LocalDate;
import java.util.List;

public class Informe {
    private String nombreCiudad;
    private LocalDate fechaInicioMedicion;
    private LocalDate fechaFinMedicion;
    private String estacionesAsociadas;
    private List<Object>informacionMeteorologica;
    private List<Object>informacionContaminacion;

    public Informe() {
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public LocalDate getFechaInicioMedicion() {
        return fechaInicioMedicion;
    }

    public void setFechaInicioMedicion(LocalDate fechaInicioMedicion) {
        this.fechaInicioMedicion = fechaInicioMedicion;
    }

    public LocalDate getFechaFinMedicion() {
        return fechaFinMedicion;
    }

    public void setFechaFinMedicion(LocalDate fechaFinMedicion) {
        this.fechaFinMedicion = fechaFinMedicion;
    }

    public String getEstacionesAsociadas() {
        return estacionesAsociadas;
    }

    public void setEstacionesAsociadas(String estacionesAsociadas) {
        this.estacionesAsociadas = estacionesAsociadas;
    }

    public List<Object> getInformacionMeteorologica() {
        return informacionMeteorologica;
    }

    public void setInformacionMeteorologica(List<Object> informacionMeteorologica) {
        this.informacionMeteorologica = informacionMeteorologica;
    }

    public List<Object> getInformacionContaminacion() {
        return informacionContaminacion;
    }

    public void setInformacionContaminacion(List<Object> informacionContaminacion) {
        this.informacionContaminacion = informacionContaminacion;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "nombreCiudad='" + nombreCiudad + '\'' +
                ", fechaInicioMedicion=" + fechaInicioMedicion +
                ", fechaFinMedicion=" + fechaFinMedicion +
                ", estacionesAsociadas='" + estacionesAsociadas + '\'' +
                ", informacionMeteorologica=" + informacionMeteorologica +
                ", informacionContaminacion=" + informacionContaminacion +
                '}';
    }
}
