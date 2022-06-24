package app;

import business.backtracking.Backtracking;
import business.backtracking.Rolo;
import business.progDinamica.ProgDinamica;

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
        Backtracking backtracking = new Backtracking();
        ProgDinamica progDinamica = new ProgDinamica(matriz);
        Rolo[][] matrizBacktracking = backtracking.construirMatrizRolos(matriz);
        System.out.println(backtracking.backtracking(matrizBacktracking,
                0,
                1,
                matriz[0][0],
                0,
                Double.POSITIVE_INFINITY
        ));

        System.out.println(progDinamica.getSequenciaCilindros().toString());
    }
}
