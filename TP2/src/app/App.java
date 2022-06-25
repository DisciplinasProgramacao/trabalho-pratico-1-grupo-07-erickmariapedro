package app;

import business.backtracking.Backtracking;
import business.backtracking.Rolo;
import business.guloso.Guloso;
import business.progDinamica.ProgDinamica;

public class App {

    public static void main(String[] args) {
        MatrizDAO leitor = new MatrizDAO();
        int[][] matriz = leitor.get("LaminacaoTeste4.txt");
        long tempoExecucaoInicial = 0;
        long tempoExecucaoFinal = 0;
        long tempoExecucaoBacktracking = 0;
        long tempoExecucaoProgDinamica = 0;
        long tempoExecucaoGuloso = 0;
                
        Backtracking backtracking = new Backtracking();
        Guloso guloso = new Guloso();    
        Rolo[][] matrizBacktracking = backtracking.construirMatrizRolos(matriz);

        System.out.println("Resultados Backtracking");

        tempoExecucaoInicial = System.currentTimeMillis();
        System.out.println("Melhor custo: " + backtracking.backtracking(matrizBacktracking,
                0,
                matriz[0].length - 1,
                matriz[0][0],
                0,
                Double.POSITIVE_INFINITY
        ));        tempoExecucaoFinal = System.currentTimeMillis();
        tempoExecucaoBacktracking = ((tempoExecucaoFinal - tempoExecucaoInicial));

        System.out.println("Tempo de execução: " + tempoExecucaoBacktracking + " ms\n");

        System.out.println("Resultados Programação Dinâmica");
        
        tempoExecucaoInicial = System.currentTimeMillis();
        ProgDinamica progDinamica = new ProgDinamica(matriz);
        tempoExecucaoFinal = System.currentTimeMillis();
        tempoExecucaoProgDinamica = ((tempoExecucaoFinal - tempoExecucaoInicial));
        
        System.out.println("Sequência de rolos: " + progDinamica.getSequenciaCilindros().toString());
        System.out.println("Quantidade de rolos: " + progDinamica.getTamanhoSequencia());
        System.out.println("Melhor custo: " + progDinamica.getCustoTotal());
        System.out.println("Tempo de execução: " + tempoExecucaoProgDinamica + " ms\n");

        System.out.println("Resultados Guloso");
        
        tempoExecucaoInicial = System.currentTimeMillis();
        System.out.println("Sequência de rolos: " + guloso.guloso(matriz));
        tempoExecucaoFinal = System.currentTimeMillis();
        tempoExecucaoGuloso = ((tempoExecucaoFinal - tempoExecucaoInicial));
        
        System.out.println("Quantidade de rolos: " + guloso.getTamanhoSequencia());
        System.out.println("Melhor custo: " + guloso.getCustoTotal());
        System.out.println("Tempo de execução: " + tempoExecucaoGuloso + " ms\n");
    }
}
