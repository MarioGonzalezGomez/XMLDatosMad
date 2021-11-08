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
    private List<InformacionMedicion> informacionMeteorologica;
    private List<InformacionMedicion> informacionContaminacion;

    @Override
    public String toString() {
        return "Informe{" +
                "nombreCiudad='" + nombreCiudad + '\'' +
                ", fechaInicioMedicion=" + fechaInicioMedicion +
                ", fechaFinMedicion=" + fechaFinMedicion +
                ", informacionMeteorologica=" + informacionMeteorologica +
                ", informacionContaminacion=" + informacionContaminacion +
                '}';
    }
}
