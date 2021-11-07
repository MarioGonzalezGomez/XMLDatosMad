package service;

import model.Medicion;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.util.List;

public class GeneradorGraficas {

    /**
     * Utilizando la librería JFreeChart, esta clase implementa el código necesario para generar las gráficas de las
     * mediciones. Adicionalmente, utiliza condiciones con un index para poder hacer gráficos personalizados y
     * más adecuados para cada tipo de dato
     * @param mediciones
     * @param index
     * @param nombreTabla
     * @return
     */
    public JFreeChart hacerGrafica(List<Medicion> mediciones, int index, String nombreTabla) {
        JFreeChart grafica = null;
        //Para las gráficas de pastel debemos hacer DefaultPieDataset
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        Medicion medicion = mediciones.get(index);
        //List<Double> diarias = medicion.getMediaMensual();
        //double acumulado = 0.0;
        //for (int i = 0; i < diarias.size(); i++) {
        // datos.addValue(diarias.get(i), nombreTabla, "" + (i + 1));
        // acumulado = acumulado + diarias.get(i);
        // }
        if (index == 2) {
            grafica = ChartFactory.createLineChart(nombreTabla + " día a día", "Día del mes", "ºC", datos, PlotOrientation.VERTICAL, true, false, false);
        }
        if (index == 5) {
            grafica = ChartFactory.createBarChart(nombreTabla + " día a día", "Día del mes", "W/m2", datos, PlotOrientation.VERTICAL, true, false, false);
        }
        if (index == 3) {
            grafica = ChartFactory.createAreaChart(nombreTabla + " día a día", "Día del mes", "%", datos, PlotOrientation.VERTICAL, true, false, false);
        }
        if (index == 0) {
            grafica = ChartFactory.createBarChart(nombreTabla + " día a día", "Día del mes", "m/s", datos, PlotOrientation.HORIZONTAL, true, false, false);
        }
        grafica.setBackgroundPaint(new Color(250, 6, 34, 48));
        return grafica;
    }
}
