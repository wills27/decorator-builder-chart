/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.presenter;

import com.mycompany.builder.Diretor;
import com.mycompany.builder.GraficoBarraHorizontalBuilder;
import com.mycompany.builder.GraficoBarraVerticalBuilder;
import com.mycompany.builder.GraficoBuilder;
import com.mycompany.view.ChartView;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author mathe
 */
public class ChartPresenter {
    private ChartView chartView;

    public ChartPresenter() {
        chartView = new ChartView();
        graficoPlot();
        chartView.setVisible(true);
        initListeners();
    }
    
    public void initListeners(){
        this.chartView.getComboBoxGraficoBase().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                graficoPlot();
            }
        });
        
        this.chartView.getButtonFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
        
        this.chartView.getButtonPadrao().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                graficoPlot();
            }
        });
    }
    
    public void graficoPlot(){
        if(chartView.getComboBoxGraficoBase().getSelectedItem().toString() == "Barras Horizontais"){
            graficoPlotHorizontal();
        } else{
            graficoPlotVertical();
        }
    }
    
    public void graficoPlotHorizontal(){        
        chartView.getPanelGrafico().removeAll();
        GraficoBuilder builder = new GraficoBarraHorizontalBuilder();
        Diretor diretor = new Diretor(builder);
        chartView.getPanelGrafico().setLayout(new BorderLayout());
        chartView.getPanelGrafico().add(diretor.createChart(), BorderLayout.CENTER);
    }
    
    public void graficoPlotVertical(){
        chartView.getPanelGrafico().removeAll();
        GraficoBuilder builder = new GraficoBarraVerticalBuilder();
        Diretor diretor = new Diretor(builder);
        chartView.getPanelGrafico().setLayout(new BorderLayout());
        chartView.getPanelGrafico().add(diretor.createChart(), BorderLayout.CENTER);        
    }
    
    public void sair(){
        this.chartView.dispose();
    }
}
