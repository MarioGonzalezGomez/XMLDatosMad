package model;

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

    public MedicionHora getMomentoYMaxima() {
        return momentoYMaxima;
    }

    public void setMomentoYMaxima(MedicionHora momentoYMaxima) {
        this.momentoYMaxima = momentoYMaxima;
    }

    public MedicionHora getMomentoYMinima() {
        return momentoYMinima;
    }

    public void setMomentoYMinima(MedicionHora momentoYMinima) {
        this.momentoYMinima = momentoYMinima;
    }


}
