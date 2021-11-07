package model;

public class InformacionMedicion {

    private Double mediaMensual;
    private String momentoYMaxima;
    private String momentoYMinima;
    private Object grafica; ///cambiar a JFreeChart tanto aqui como en getters y setters


    public Double getMediaMensual() {
        return mediaMensual;
    }

    public void setMediaMensual(Double mediaMensual) {
        this.mediaMensual = mediaMensual;
    }

    public String getMomentoYMaxima() {
        return momentoYMaxima;
    }

    public void setMomentoYMaxima(String momentoYMaxima) {
        this.momentoYMaxima = momentoYMaxima;
    }

    public String getMomentoYMinima() {
        return momentoYMinima;
    }

    public void setMomentoYMinima(String momentoYMinima) {
        this.momentoYMinima = momentoYMinima;
    }

    public Object getGrafica() {
        return grafica;
    }

    public void setGrafica(Object grafica) {
        this.grafica = grafica;
    }
}
