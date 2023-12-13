/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.decorator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

public abstract class DecoradorBase implements ComponenteGrafico {
    private ComponenteGrafico componente;

    public DecoradorBase(ComponenteGrafico componente) {
        this.componente = componente;
    }

    @Override
    public JFreeChart criarGrafico(PlotOrientation orientation) {
        return componente.criarGrafico(orientation);
    }
}
