/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.builder;

import com.decorator.GraficoSimples;
import com.mycompany.auxiliar.CSVReader;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author mathe
 */
public class GraficoBarraVerticalBuilder implements GraficoBuilder{
    private JFreeChart savedChart;
    @Override
    public ChartPanel createChart(){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        CSVReader csvReader = new CSVReader();
        dataset = csvReader.readCsvToDataset();
        
        JFreeChart chart = new GraficoSimples().criarGrafico(PlotOrientation.VERTICAL);
        savedChart = chart;
        ChartPanel panelChart = new ChartPanel(chart);
        panelChart.setPreferredSize(new Dimension(500, 300));
        
        
        return panelChart;
    
    }

    @Override
    public JFreeChart getChart() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
