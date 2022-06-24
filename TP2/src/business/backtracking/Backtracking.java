package business.backtracking;

public class Backtracking {

    public Rolo[][] construirMatrizRolos(int[][] matriz) {
        Rolo[][] novaMatriz = new Rolo[6][3];
        for (int i = 0; i < 6;i++) {
            for (int j = 0; j < 3;j++) {
                novaMatriz[i][j] = new Rolo(j+1,matriz[i][j+1]);
            }
        }
        return  novaMatriz;
    }

    public boolean ePromissor(Rolo[][] matriz, int row, int col) {
        return row <= 6;
    }


    public double backtracking(Rolo[][] matriz, int row, int col, int espessuraAtual, double somaCustos, double melhorCusto) {
        if (ePromissor(matriz, row, col)) {
            if (espessuraAtual == 4) {
                row--;
                if (somaCustos < melhorCusto)
                    return somaCustos;
            } else {
                for (int i = 0;i<3;i++) {
                    int jump = espessuraAtual -  matriz[row][i].espessura;
                    melhorCusto = backtracking(matriz, row + matriz[row][i].espessura, col, jump,
                            somaCustos + matriz[row][i].custo, melhorCusto);
                }
            }
        }
        return melhorCusto;
    }

}

//                } else {
//                    // se não for mais aceitavel, volta 1 linha e testa todas as colunas de acordo
//                    // testar as colunas de acordo é necessário
//                    // nao vai precisar ter isso se eu andar na linha cm o for -> if (finished) row -= 1;
//                    for (int i = 1;i<3;i++)
//                        backtracking(matriz, row, i, espessuraAtual, somaCustos, melhorCusto);
//                }
//backtracking(matriz, row - 1, col, espessuraAtual + rolo.espessura,
//        somaCustos - rolo.custo, melhorCusto);