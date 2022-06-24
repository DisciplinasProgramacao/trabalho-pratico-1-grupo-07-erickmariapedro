package app;

import business.ProgDinamica;

public class App {

    public static void main(String[] args) {
        int[][] matriz = {
            {10,4,6,8},
            {9,4,6,9},
                {8,4,7,12},
                {7,4,10,16},
                {6,5,12,0},
                {5,7,0,0}
        };

        System.out.println(matriz[0][2]);
        System.out.println(matriz[0].length);

        ProgDinamica progDinamica = new ProgDinamica(matriz);
    }
}
