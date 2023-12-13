/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.decorator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class CoresBarrasDecorator implements ComponenteGrafico {
    private ComponenteGrafico componente;

    public CoresBarrasDecorator(ComponenteGrafico componente) {
        this.componente = componente;
    }

    @Override
    public JFreeChart criarGrafico(PlotOrientation orientation) {
        JFreeChart chart = componente.criarGrafico(orientation);
        chart.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.GREEN); // Modifica a cor da primeira série
        return chart;
    }
}