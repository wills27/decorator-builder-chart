/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.decorator;

/**
 *
 * @author santa
 */
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;

public class RotuloPorcentagemDecorator extends DecoradorBase {
    public RotuloPorcentagemDecorator(ComponenteGrafico componente) {
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
            return String.format("%.2f%%", value * 100);
        }
    }
}