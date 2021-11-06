package io;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class HtmlWriter {
    XmlReader xr = new XmlReader();

    public void generarHtml() throws IOException, ParserConfigurationException, SAXException {
        List<String> texto = procesarHtml();
        String nombreDoc = texto.get(0).toLowerCase() + ".html";
        Path path = Paths.get(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
                + "resources" + File.separator + "informes" + File.separator + nombreDoc);
        Files.write(path, texto, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

    }

    //StringBuilder sb = new StringBuilder("<html><head><title>Lector MGG y AGDP</title></head><body><h2>Lector de CSV by Andrea Gómez De Pablo y Mario González Gómez</h2>");
    //        sb.append("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyTGSdHD9cZg4fzanfhuydnOH4c0dLXoiHZw&usqp=CAU width=\"290\" height=\"174\">");
    //        sb.append("<hr/><h1>Informe de datos de " + ciudad + "</h1>");
    //        sb.append("<ul><li>Fecha de inicio de la medición: </li><li>Fecha de fin de la medición: </li><li>Estación/estaciones asociadas:</li></ul>");
    //        sb.append("<hr/><h2>************************   DATOS METEO   *******************************</h2>");
    //        sb.append("<h4>TEMPERATURA</h4><ul><li>Temperatura media mensual: " + datos.get(2).getMediaMensual() + "</li> <li>Momento y temperatura máxima: </li> <li>Momento y temperatura mínima:</li> </ul> <img src=\"" + System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "graficoTemp\"></br>");
    //        sb.append("<h4>RADIACIÓN SOLAR</h4> <ul><li>Radiación solar media mensual: " + datos.get(5).getMediaMensual() + "</li> <li>Momento y radiación máxima: </li> <li>Momento y radiación mínima:</li> </ul> <img src=\"" + System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "graficoSolar\"></br>");
    //        sb.append("<h4>PRECIPITACIÓN</h4> <ul><li>Precipitación media mensual: " + datos.get(6).getMediaMensual() + "</li> <li>Lista de días que ha llovido y precipitación de cada día: </li></ul>");
    //        sb.append("<h4>HUMEDAD</h4> <ul><li>Humedad relativa media mensual: " + datos.get(3).getMediaMensual() + "</li> <li>Momento y humedad máxima: </li> <li>Momento y humedad mínima :</li></ul> <img src=\"" + System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "graficoHumedad\"></br>");
    //        sb.append("<h4>VELOCIDAD DEL VIENTO</h4> <ul><li>Velocidad media del viento mensual: " + datos.get(0).getMediaMensual() + "</li> <li>Momento y velocidad máxima: </li> <li>Momento y velocidad mínima :</li></ul> <img src=\"" +System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "graficoViento\"></br>");
    //        sb.append("<p><i>Informe generado el " + ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear() + " a las " + cldr.get(Calendar.HOUR_OF_DAY)
    //                + ":" + cldr.get(Calendar.MINUTE) + ":" + cldr.get(Calendar.SECOND)
    //                + " en " + (System.currentTimeMillis() - initTime) / 1000 + " segundos.</p></i>");
    //
    //        sb.append("</body></html>");

    private List<String> procesarHtml() throws ParserConfigurationException, IOException, SAXException {

        List<String> texto = new LinkedList<>();
        texto.add("<html><head><title>Mario&Andrea proyect</title></head><body><h4>Práctica de Acceso a Datos by Andrea Gómez De Pablo y Mario González Gómez</h4>");
        texto.add("<h2>Informe de datos de" + "</h2>");
        texto.add("<img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyTGSdHD9cZg4fzanfhuydnOH4c0dLXoiHZw&usqp=CAU\" width=\"290\" height=\"174\">");
        texto.add("<hr/><h1>Informe de datos de </h1>");
        return texto;
    }
}
