package service;

import java.text.Normalizer;

public class Utiles {
    public static String normalizar(String ciudad) {
        ciudad = (Normalizer.normalize(ciudad, Normalizer.Form.NFD)).replaceAll("[^\\p{ASCII}]", "").toLowerCase().replace("-", "").replace(" ", "");
        return ciudad;
    }
}
