package app;

import business.backtracking.Backtracking;
import business.backtracking.Rolo;
import business.progDinamica.ProgDinamica;

public class App {

    public static void main(String[] args) {
        MatrizDAO leitor = new MatrizDAO();
        int[][] matriz = leitor.get("LaminacaoTeste1.txt");

        System.out.println(matriz[0][2]);
        System.out.println(matriz[0].length);

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
