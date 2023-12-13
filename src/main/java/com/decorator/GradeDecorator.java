/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.decorator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;

public class GradeDecorator extends DecoradorBase {

    public GradeDecorator(ComponenteGrafico componente) {
        super(componente);
    }

    @Override
    public JFreeChart criarGrafico(PlotOrientation orientation) {
        JFreeChart chart = super.criarGrafico(orientation);

        if (chart.getPlot() instanceof CategoryPlot categoryPlot) {
            adicionarGradeCategoria(categoryPlot);
        } else if (chart.getPlot() instanceof XYPlot xYPlot) {
            adicionarGradeXY(xYPlot);
        }

        return chart;
    }

    private void adicionarGradeCategoria(CategoryPlot plot) {
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(true);
    }

    private void adicionarGradeXY(XYPlot plot) {
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(true);
    }
}