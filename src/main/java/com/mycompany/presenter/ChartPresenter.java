/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.presenter;

import com.decorator.ComponenteGrafico;
import com.decorator.CoresBarrasDecorator;
import com.decorator.CoresBarrasPorGrupoDecorator;
import com.decorator.GraficoSimples;
import com.decorator.RotuloPorcentagemDecorator;
import com.decorator.RotuloValorDecorator;
import com.decorator.RotuloValorPorcentagemDecorator;
import com.decorator.TituloAdicionalDecorator;
import com.decorator.TituloEixosDecorator;
import com.mycompany.builder.Diretor;
import com.mycompany.builder.GraficoBarraHorizontalBuilder;
import com.mycompany.builder.GraficoBarraVerticalBuilder;
import com.mycompany.builder.GraficoBuilder;
import com.mycompany.view.ChartView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

/**
 *
 * @author mathe
 */
public class ChartPresenter implements ComponenteGrafico{
    JFreeChart grafChart;
    private ChartView chartView;

    public ChartPresenter() {
        chartView = new ChartView();
        graficoPlot();
        chartView.setVisible(true);
        initListeners();
    }
    
    public void initListeners(){
        ItemListener itemListener = e -> aplicarDecoradores(this,
                    this.chartView.getCheckBoxTituloGrafico().isSelected(), this.chartView.getCheckBoxCorIndividual().isSelected(),
                    this.chartView.getCheckBoxRotuloValores().isSelected(), this.chartView.getCheckBoxRotuloPorcento().isSelected(),
                    this.chartView.getCheckBoxRotuloDadosPorcento().isSelected(), this.chartView.getCheckBoxCorGrupo().isSelected(),
                    this.chartView.getCheckBoxTituloEixos().isSelected());
        
        this.chartView.getCheckBoxTituloGrafico().addItemListener(itemListener);
        this.chartView.getCheckBoxCorIndividual().addItemListener(itemListener);
        this.chartView.getCheckBoxRotuloValores().addItemListener(itemListener);
        this.chartView.getCheckBoxRotuloPorcento().addItemListener(itemListener);
        this.chartView.getCheckBoxRotuloDadosPorcento().addItemListener(itemListener);
        this.chartView.getCheckBoxCorGrupo().addItemListener(itemListener);
        this.chartView.getCheckBoxTituloEixos().addItemListener(itemListener);
        
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
                criarGrafico(PlotOrientation.HORIZONTAL);
            }
        });
    }
    
    public ChartPanel graficoPlot(){
        if(chartView.getComboBoxGraficoBase().getSelectedItem().toString() == "Barras Horizontais"){
            return graficoPlotHorizontal();
        } else{
            return graficoPlotVertical();
        }
    }
    
    public ChartPanel graficoPlotHorizontal(){
        chartView.getPanelGrafico().removeAll();
        GraficoBuilder builder = new GraficoBarraHorizontalBuilder();
        Diretor diretor = new Diretor(builder);
        ChartPanel panel = diretor.createChart();
        chartView.getPanelGrafico().setLayout(new BorderLayout());
        chartView.getPanelGrafico().add(panel, BorderLayout.CENTER); 
        return panel;
    }
    
    public ChartPanel graficoPlotVertical(){
        chartView.getPanelGrafico().removeAll();
        GraficoBuilder builder = new GraficoBarraVerticalBuilder();
        Diretor diretor = new Diretor(builder);
        ChartPanel panel = diretor.createChart();
        chartView.getPanelGrafico().setLayout(new BorderLayout());
        chartView.getPanelGrafico().add(panel, BorderLayout.CENTER); 
        return panel;
    }
    
    public void sair(){
        this.chartView.dispose();
    }
    
    public void aplicarDecoradores(ComponenteGrafico graficoSimples,
            boolean tituloAdicional, boolean coresBarras, boolean rotuloValor,
            boolean rotuloPorcentagem, boolean rotuloCombinado, boolean coresBarrasPorGrupo,
            boolean tituloEixos) {
        ComponenteGrafico graficoDecorado = graficoSimples;

        if (tituloAdicional) {
            graficoDecorado = new TituloAdicionalDecorator(graficoDecorado, "Título Adicional");
        }

        if (coresBarras) {
            graficoDecorado = new CoresBarrasDecorator(graficoDecorado);
        }

        if (rotuloValor) {
            graficoDecorado = new RotuloValorDecorator(graficoDecorado);
        }

        if (rotuloPorcentagem) {
            graficoDecorado = new RotuloPorcentagemDecorator(graficoDecorado);
        }

        if (rotuloCombinado) {
            graficoDecorado = new RotuloValorPorcentagemDecorator(graficoDecorado);
        }

        if (coresBarrasPorGrupo) {
            graficoDecorado = new CoresBarrasPorGrupoDecorator(graficoDecorado);
        }

        if (tituloEixos) {
            graficoDecorado = new TituloEixosDecorator(graficoDecorado, "Eixo X", "Eixo Y");
        }

        JFreeChart chart = graficoDecorado.criarGrafico(PlotOrientation.HORIZONTAL);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));

        chartView.getPanelGrafico().removeAll();
        chartView.getPanelGrafico().add(chartPanel, BorderLayout.CENTER);

        chartView.pack();
        chartView.repaint();
        
        
    }

    @Override
    public JFreeChart criarGrafico(PlotOrientation o) {
        GraficoBuilder builder;
        if("Barras Horizontais".equals(chartView.getComboBoxGraficoBase().getSelectedItem().toString()))
        {
            builder = new GraficoBarraHorizontalBuilder();
        }
        else
        {
            builder = new GraficoBarraVerticalBuilder();
        }
        chartView.getPanelGrafico().removeAll();
        
        JFreeChart chart = builder.getChart();
        if (chart == null)
        {
            chart = new GraficoSimples().criarGrafico(PlotOrientation.HORIZONTAL);
        }
        Diretor diretor = new Diretor(builder);
        ChartPanel panel = diretor.createChart();
        chartView.getPanelGrafico().setLayout(new BorderLayout());
        chartView.getPanelGrafico().add(panel, BorderLayout.CENTER); 
        return chart;
    }
}
