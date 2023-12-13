/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.decorator;

import java.awt.Color;
import java.awt.Paint;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;

import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;

import java.awt.*;
import org.jfree.chart.plot.PlotOrientation;

public class CoresBarrasPorGrupoDecorator extends DecoradorBase {
    public CoresBarrasPorGrupoDecorator(ComponenteGrafico componente) {
        super(componente);
    }

    @Override
    public JFreeChart criarGrafico(PlotOrientation orientation) {
        JFreeChart chart = super.criarGrafico(orientation);
        CategoryPlot plot = chart.getCategoryPlot();

        // Cria um renderer personalizado com cores diferentes para cada grupo
        CategoryItemRenderer renderer = new BarRenderer() {
            private final Paint[] colors = {Color.BLUE, Color.GREEN, Color.RED};

            @Override
            public Paint getItemPaint(int row, int column) {
                return colors[column % colors.length];
            }
        };

        // Configura o novo renderer
        plot.setRenderer(renderer);

        return chart;
    }
}
