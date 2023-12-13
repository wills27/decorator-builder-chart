/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.decorator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;

public class TituloEixosDecorator extends DecoradorBase {
    private String tituloEixoX;
    private String tituloEixoY;

    public TituloEixosDecorator(ComponenteGrafico componente, String tituloEixoX, String tituloEixoY) {
        super(componente);
        this.tituloEixoX = tituloEixoX;
        this.tituloEixoY = tituloEixoY;
    }

    @Override
    public JFreeChart criarGrafico(PlotOrientation orientation) {
        JFreeChart chart = super.criarGrafico(orientation);
        CategoryPlot plot = chart.getCategoryPlot();

        // Adiciona títulos aos eixos X e Y
        plot.getDomainAxis().setLabel(tituloEixoX);
        plot.getRangeAxis().setLabel(tituloEixoY);

        return chart;
    }
}