/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.decoratorbuilderchart;

import com.decorator.RotuloPorcentagemDecorator;
import com.decorator.RotuloValorPorcentagemDecorator;
import com.mycompany.auxiliar.CSVReader;
import com.mycompany.presenter.ChartPresenter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import com.decorator.ComponenteGrafico;
import com.decorator.CoresBarrasDecorator;
import com.decorator.CoresBarrasPorGrupoDecorator;
import com.decorator.GraficoSimples;
import com.decorator.RotuloValorDecorator;
import com.decorator.TituloAdicionalDecorator;
import com.decorator.TituloEixosDecorator;
import org.jfree.chart.plot.PlotOrientation;
/**
 *
 * @author mathe
 */
public class DecoratorBuilderChart {
    private static JPanel checkboxPanel;
    public static void main(String[] args) {
        new ChartPresenter();
//        call();
    }
}

