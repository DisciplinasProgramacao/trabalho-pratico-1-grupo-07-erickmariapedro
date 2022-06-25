package app;

import business.backtracking.Backtracking;
import business.backtracking.Rolo;
import business.guloso.Guloso;
import business.progDinamica.ProgDinamica;

public class App {

    public static void main(String[] args) {
        MatrizDAO leitor = new MatrizDAO();
        int[][] matriz = leitor.get("LaminacaoTeste4.txt");

        Backtracking backtracking = new Backtracking();
        ProgDinamica progDinamica = new ProgDinamica(matriz);
        Guloso guloso = new Guloso();
        Rolo[][] matrizBacktracking = backtracking.construirMatrizRolos(matriz);
        System.out.println("(Backtracking) Melhor custo: " + backtracking.backtracking(matrizBacktracking,
                0,
                matriz[0].length - 1,
                matriz[0][0],
                0,
                Double.POSITIVE_INFINITY
        ));

        System.out.println("(Programa��o Din�mica) Sequ�ncia de rolos: " +progDinamica.getSequenciaCilindros().toString());
        System.out.println("(Guloso) Sequ�ncia de rolos: " + guloso.guloso(matriz));
    }
}
