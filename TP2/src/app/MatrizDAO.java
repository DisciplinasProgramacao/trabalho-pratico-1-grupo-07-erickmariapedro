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

        String caminho = "src/app/"+nomeArquivo;


        try (BufferedReader buffer_entrada = new BufferedReader(new FileReader(caminho))) {
            String linha = buffer_entrada.readLine();
            while (linha != null) {
                linha = linha.replaceAll("  "," ");
                linha = linha.replaceAll("x","0");
                vetores.add(Arrays.stream(linha.split(" ")).map(String::trim)
                        .mapToInt(Integer::parseInt).toArray());
                linha = buffer_entrada.readLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int [][] matriz = new int [vetores.size()][4];
         for (int i = 0; i < vetores.size(); i++){
             if (vetores.get(i).length == 3){
                 int newArr[] = Arrays.copyOf(vetores.get(i), vetores.get(i).length +1);
                 newArr[3] = 0;
                 matriz[i] = newArr;
             }else{
                 matriz[i] = vetores.get(i);
             }

         }

        return matriz;
    }

}
