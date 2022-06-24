package app;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrizDAO implements DAO<int[][], String> {

    @Override
    public int[][] get(String nomeArquivo) {
        List<int[]> vetores = new ArrayList<>();


        try (BufferedReader buffer_entrada = new BufferedReader(new FileReader("src/app/"+nomeArquivo))) {
            String linha = buffer_entrada.readLine();
            while (linha != null) {
                linha = linha.replaceAll("x","0");
                vetores.add(Arrays.stream(linha.substring(0, linha.length() - 1).split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray());
                linha = buffer_entrada.readLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int [][] matriz = new int [vetores.size()][4];
         for (int i = 0; i < vetores.size(); i++){
             matriz[i] = vetores.get(i);
         }

        return matriz;
    }

}
