package io;

import model.Medicion;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import service.GeneradorGraficas;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class HtmlWriter {


    public void generarHtml(List<Medicion> temperatura, List<Medicion> contaminacion, long initTime, Path ruta) throws IOException {
        List<String> texto = procesarHtml(temperatura, contaminacion, initTime);
        String nombreDoc = texto.get(0).toLowerCase() + ".html";
       // Path path = Paths.get(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
        //        + "resources" + File.separator + "informes" + File.separator + nombreDoc);
       // Files.write(path, texto, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        Files.write(ruta, texto, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

    }

    private List<String> procesarHtml(List<Medicion> temperatura, List<Medicion> contaminacion, long initTime) {
        //Probablemente se reciba una lista de objetos informe o similar, y se hará el recorrido dependiendo del número de informees
        LocalDate ld = LocalDate.now();
        Calendar cldr = Calendar.getInstance();
        List<String> texto = new LinkedList<>();
        texto.add("<html><head><title>Mario&Andrea proyect</title></head><body><h4>Práctica de Acceso a Datos by Andrea Gómez De Pablo y Mario González Gómez</h4>");
        texto.add("<img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyTGSdHD9cZg4fzanfhuydnOH4c0dLXoiHZw&usqp=CAU\" width=\"290\" height=\"174\">");
        //Añadir el nombre de la ciudad
        //Añadir estas fechas
        texto.add("<hr/><h1>Informe de datos de </h1>");
        texto.add("<ul><li>Fecha de inicio de la medición: </li><li>Fecha de fin de la medición: </li><li>Estación/estaciones asociadas:</li></ul>");
        //Añadir los diferentes campos
        texto.add("<hr/><h2>************************   DATOS METEOROLÓGICOS   *******************************</h2>");
        //texto.add("<h4>TEMPERATURA</h4><ul><li>Temperatura media mensual: " + datos.get(2).getMediaMensual() + "</li> <li>Momento y temperatura m�xima: </li> <li>Momento y temperatura m�nima:</li> </ul> <img src=\"" + System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "graficas" + File.separator + "graficoTemp\"></br>");
        //texto.add("<h4>RADIACI�N SOLAR</h4> <ul><li>Radiaci�n solar media mensual: " + datos.get(5).getMediaMensual() + "</li> <li>Momento y radiaci�n m�xima: </li> <li>Momento y radiaci�n m�nima:</li> </ul> <img src=\"" + System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "graficas" + File.separator + "graficoSolar\"></br>");
        //texto.add("<h4>PRECIPITACI�N</h4> <ul><li>Precipitaci�n media mensual: " + datos.get(6).getMediaMensual() + "</li> <li>Lista de d�as que ha llovido y precipitaci�n de cada d�a: </li></ul>");
        // texto.add("<h4>HUMEDAD</h4> <ul><li>Humedad relativa media mensual: " + datos.get(3).getMediaMensual() + "</li> <li>Momento y humedad m�xima: </li> <li>Momento y humedad m�nima :</li></ul> <img src=\"" + System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "graficas" + File.separator + "graficoHumedad\"></br>");
        //texto.add("<h4>VELOCIDAD DEL VIENTO</h4> <ul><li>Velocidad media del viento mensual: " + datos.get(0).getMediaMensual() + "</li> <li>Momento y velocidad m�xima: </li> <li>Momento y velocidad m�nima :</li></ul> <img src=\"" +System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "graficas" + File.separator + "graficoViento\"></br>");
        // texto.add("<hr/><h2>************************   DATOS CONTAMINACIÓN   *******************************</h2>");
        texto.add("<p><i>Informe generado el " + ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear() + " a las " + cldr.get(Calendar.HOUR_OF_DAY)
                + ":" + cldr.get(Calendar.MINUTE) + ":" + cldr.get(Calendar.SECOND)
                + " en " + (System.currentTimeMillis() - initTime) / 1000 + " segundos.</p></i>");
        texto.add("</body></html>");

        return texto;
    }

    private void generarGraficas(List<Medicion> datos) throws IOException {
        GeneradorGraficas gg = new GeneradorGraficas();

        JFreeChart graficoTemp = gg.hacerGrafica(datos, 2, "Temperatura");
        File graficoTemperatura = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "graficas" + File.separator + "graficoTemp");
        ChartUtils.saveChartAsPNG(graficoTemperatura, graficoTemp, 600, 400);

        JFreeChart graficoSolar = gg.hacerGrafica(datos, 5, "Radiaci�n Solar");
        File graficoRadiacionSolar = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "graficas" + File.separator + "graficoSolar");
        ChartUtils.saveChartAsPNG(graficoRadiacionSolar, graficoSolar, 600, 400);

        JFreeChart graficoHum = gg.hacerGrafica(datos, 3, "Humedad relativa");
        File graficoHumedad = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "graficas" + File.separator + "graficoHumedad");
        ChartUtils.saveChartAsPNG(graficoHumedad, graficoHum, 600, 400);

        JFreeChart graficoViento = gg.hacerGrafica(datos, 0, "Humedad relativa");
        File graficoVelocidadCiento = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "graficas" + File.separator + "graficoViento");
        ChartUtils.saveChartAsPNG(graficoVelocidadCiento, graficoViento, 600, 400);

    }
}
