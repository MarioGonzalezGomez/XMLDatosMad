package io;

import model.Medicion;
import model.MedicionHora;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatosMesReader {


    public static Optional<List<Medicion>> leerMedicionesMensuales(String p) {

        if (Files.exists(Path.of((p)))) {

            try (Stream<String> stream = Files.lines(Path.of(p), Charset.forName("Cp1252"))) {
                return Optional.of(stream

                        .map(s -> s.split(";"))
                        .map(splitted -> {

                            String provincia = splitted[0];
                            String municipio = splitted[1];
                            String estacion = splitted[2];
                            Float magnitud = Float.parseFloat(splitted[3]);
                            String puntoMuestreo = splitted[4];
                            int anio = Integer.parseInt((splitted[5]));
                            int mes = Integer.parseInt(splitted[6]);
                            int dia = Integer.parseInt(splitted[7]);
                            Time hora;
                            int contador = 0;
                            List<MedicionHora> medicionesHora = new ArrayList<>();
                            for (int i = 8; i < splitted.length; i++) {
                                MedicionHora medicion_hora = new MedicionHora(Float.parseFloat(splitted[i]), splitted[i + 1], hora = new Time(contador + 1));
                                contador++;
                                medicionesHora.add(medicion_hora);
                            }
                            return new Medicion(provincia, municipio, estacion, magnitud, puntoMuestreo, anio, mes, dia, medicionesHora);
                        })
                        .collect(Collectors.toList()));
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }


    }
}
