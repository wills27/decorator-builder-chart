/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.decorator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.RectangleEdge;

public class LegendaDecorator extends DecoradorBase {
    private String legenda;

    public LegendaDecorator(ComponenteGrafico componente, String legenda) {
        super(componente);
        this.legenda = legenda;
    }

    @Override
    public JFreeChart criarGrafico(PlotOrientation orientation) {
        JFreeChart chart = super.criarGrafico(orientation);
        LegendTitle legend = chart.getLegend();

        legend.setItemFont(new Font("Arial", Font.PLAIN, 12));
        legend.setPosition(RectangleEdge.TOP); // Configura a posição da legenda

        return chart;
    }
}
