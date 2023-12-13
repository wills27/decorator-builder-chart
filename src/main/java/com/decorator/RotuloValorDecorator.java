package com.decorator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYDataset;

public class RotuloValorDecorator extends DecoradorBase {
    public RotuloValorDecorator(ComponenteGrafico componente) {
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
            return String.valueOf(dataset.getValue(series, category));
        }
    }
}
