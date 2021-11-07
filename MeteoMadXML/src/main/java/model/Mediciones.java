package model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "mediciones")
@XmlAccessorType (XmlAccessType.FIELD)
public class Mediciones {

    @XmlElement(name = "medicion")
    private List<Medicion> mediciones;


    public List<Medicion> getMediciones() {
        return mediciones;
    }

    public void setMediciones(List<Medicion> listaMediciones) {
        mediciones = listaMediciones;
    }
}
