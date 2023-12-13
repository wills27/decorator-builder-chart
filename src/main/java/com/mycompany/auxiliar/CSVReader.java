package com.mycompany.auxiliar;

import com.mycompany.model.Pessoa;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jfree.data.category.DefaultCategoryDataset;

public class CSVReader {

    public CSVReader() {
    }
    
    public DefaultCategoryDataset readCsvToDataset() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./resources/pessoas.csv"))) {
            String line;
            br.readLine(); // Pula o cabeçalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Pessoa pessoa = new Pessoa();
                pessoa.setSexo(values[0]);
                pessoa.setNome(values[1]);
                pessoa.setEstadoCivil(values[2]);
                pessoas.add(pessoa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset = createDatasetBySex(pessoas);
        
        return dataset;
    }
    
    private DefaultCategoryDataset createDatasetBySex(ArrayList<Pessoa> pessoas) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Integer> countBySex = new HashMap<>();

        for (Pessoa pessoa : pessoas) {
            countBySex.putIfAbsent(pessoa.getSexo(), 0);
            countBySex.put(pessoa.getSexo(), countBySex.get(pessoa.getSexo()) + 1);
        }

        for (Map.Entry<String, Integer> entry : countBySex.entrySet()) {
            dataset.addValue(entry.getValue(), entry.getKey(), "Sexo");
        }

        return dataset;
    }

}
