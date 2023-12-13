/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.builder;

import org.jfree.chart.ChartPanel;

/**
 *
 * @author mathe
 */
public class Diretor {
    private GraficoBuilder builder;

    public Diretor(GraficoBuilder builder) {
        this.builder = builder;
    }
    
    public ChartPanel createChart(){
        return builder.createChart();
    }
}
