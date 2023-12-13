/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.builder;

import com.mycompany.auxiliar.CSVReader;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author mathe
 */
public class GraficoBarraHorizontalBuilder implements GraficoBuilder{

    @Override
    public ChartPanel createChart(){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        CSVReader csvReader = new CSVReader();
        dataset = csvReader.readCsvToDataset();
        
        
        JFreeChart chart = ChartFactory.createBarChart(
            "",
            "",
            "",
            dataset,
            PlotOrientation.HORIZONTAL,
            true, true, false);
        
        ChartPanel panelChart = new ChartPanel(chart);
        panelChart.setPreferredSize(new Dimension(500, 300));
        
        return panelChart;
    }

}
