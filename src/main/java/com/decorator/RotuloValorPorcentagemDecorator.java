/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.decorator;

import java.text.NumberFormat;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;

public class RotuloValorPorcentagemDecorator extends DecoradorBase {
    public RotuloValorPorcentagemDecorator(ComponenteGrafico componente) {
        super(componente);
    }

    @Override
    public JFreeChart criarGrafico(PlotOrientation orientation) {
        JFreeChart chart = super.criarGrafico(orientation);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setDefaultItemLabelGenerator(new CustomCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);

        return chart;
    }

    private static class CustomCategoryItemLabelGenerator extends StandardCategoryItemLabelGenerator {
        public CustomCategoryItemLabelGenerator() {
            super();
        }

        @Override
        public String generateLabel(CategoryDataset dataset, int series, int category) {
            double value = dataset.getValue(series, category).doubleValue();
            double percent = value * 100;
            return String.format("%.2f (%.2f%%)", value, percent);
        }
    }
}
