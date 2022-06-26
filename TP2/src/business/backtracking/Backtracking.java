package business.backtracking;

public class Backtracking {
    public Rolo[][] construirMatrizRolos(int[][] matriz) {
        Rolo[][] novaMatriz = new Rolo[matriz.length][matriz[0].length - 1];
        for (int i = 0; i < matriz.length;i++) {
            for (int j = 0; j < matriz[0].length - 1;j++) {
                novaMatriz[i][j] = new Rolo(j+1,matriz[i][j+1]);
            }
        }
        return  novaMatriz;
    }

    public boolean ePromissor(Rolo[][] matriz, int row, double somaCustos, double melhorCusto) {
        return row <= matriz.length && somaCustos < melhorCusto;
    }


    public double backtracking(Rolo[][] matriz, int row, int col, int espessuraAtual,
                               double somaCustos, double melhorCusto) {
        if (ePromissor(matriz, row, somaCustos, melhorCusto)) {
            if (espessuraAtual == 4) {
                row--;
                if (somaCustos < melhorCusto)
                    return somaCustos;
            } else {
                for (int i = 0;i<col;i++) {
                    int jump = espessuraAtual -  matriz[row][i].espessura;
                    melhorCusto = backtracking(matriz, row + matriz[row][i].espessura, col, jump,
                            somaCustos + matriz[row][i].custo, melhorCusto);
                }
            }
        }
        return melhorCusto;
    }
}

