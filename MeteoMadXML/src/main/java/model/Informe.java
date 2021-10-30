package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class Informe {
    private String nombreCiudad;
    private LocalDate fechaInicioMedicion;
    private LocalDate fechaFinMedicion;
    private String estacionesAsociadas;
    private List<Object> informacionMeteorologica;
    private List<Object> informacionContaminacion;

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
