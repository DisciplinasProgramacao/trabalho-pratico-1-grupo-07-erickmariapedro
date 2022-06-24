package app;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class MatrizDAO implements DAO<int[][],String> {

    @Override
    public int[][] get() {
        int[][] matriz = null;

        try (BufferedReader buffer_entrada = new BufferedReader(new FileReader("LaminacaoTeste1.txt"))) {


            while (!buffer_entrada.readLine().isBlank()) {
                   System.out.println(buffer_entrada.readLine());
                }

            } catch (IOException ex) {
            ex.printStackTrace();
        }
        return matriz;
    }

}
