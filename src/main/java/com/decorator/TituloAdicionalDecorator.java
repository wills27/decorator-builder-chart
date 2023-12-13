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

public class TituloAdicionalDecorator extends DecoradorBase {
    private String tituloAdicional;

    public TituloAdicionalDecorator(ComponenteGrafico componente, String tituloAdicional) {
        super(componente);
        this.tituloAdicional = tituloAdicional;
    }

    @Override
    public JFreeChart criarGrafico(PlotOrientation orientation) {
        JFreeChart chart = super.criarGrafico(orientation);
        chart.addSubtitle(new org.jfree.chart.title.TextTitle(tituloAdicional));
        return chart;
    }
}
