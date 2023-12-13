/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.decorator;
import com.mycompany.auxiliar.CSVReader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class GraficoSimples implements ComponenteGrafico {
    @Override
    public JFreeChart criarGrafico(PlotOrientation orientation) {
        CSVReader csvReader = new CSVReader();

        
        CategoryDataset dataset = csvReader.readCsvToDataset();
        return ChartFactory.createBarChart(
                "Gráfico Simples",
                "Categoria",
                "Valor",
                dataset,
                orientation,
                true,
                true,
                false
        );
    }
}
