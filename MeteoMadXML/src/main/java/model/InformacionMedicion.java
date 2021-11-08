package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"mediaMensual", "momentoYMaxima", "momentoYMinima"})
public class InformacionMedicion {


    private String nombreMedicion;
    private Double mediaMensual;
    private MedicionHora momentoYMaxima;
    private MedicionHora momentoYMinima;
    //private Object grafica; ///cambiar a JFreeChart tanto aqui como en getters y setters




    public String getNombreMedicion() {
        return nombreMedicion;
    }

    public void setNombreMedicion(String nombreMedicion) {
        this.nombreMedicion = nombreMedicion;
    }

    public Double getMediaMensual() {
        return mediaMensual;
    }

    public void setMediaMensual( Double mediaMensual) {
        this.mediaMensual = mediaMensual;
    }
    @XmlElementWrapper(name = "max")
    @XmlElement
    public MedicionHora getMomentoYMaxima() {
        return momentoYMaxima;
    }

    public void setMomentoYMaxima(MedicionHora momentoYMaxima) {
        this.momentoYMaxima = momentoYMaxima;
    }
    @XmlElementWrapper(name = "min")
    @XmlElement
    public MedicionHora getMomentoYMinima() {
        return momentoYMinima;
    }

    public void setMomentoYMinima(MedicionHora momentoYMinima) {
        this.momentoYMinima = momentoYMinima;
    }


}
