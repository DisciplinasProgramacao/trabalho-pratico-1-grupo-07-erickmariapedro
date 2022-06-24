public class Backtracking {
    static int[][] matriz = {
            {10,4,6,8},
            {9,4,6,9},
            {8,4,7,12},
            {7,4,10,16},
            {6,5,12,0},
            {5,7,0,0}
    };

    static Rolo[][] construirMatrizRolos(int[][] matriz) {
        Rolo[][] novaMatriz = new Rolo[6][3];
        for (int i = 0; i < 6;i++) {
            for (int j = 0; j < 3;j++) {
                novaMatriz[i][j] = new Rolo(j+1,matriz[i][j+1]);
            }
        }
        return  novaMatriz;
    }

    static boolean ePromissor(Rolo[][] matriz, int row, int col) {
        return row <= 6;
    }


    static double backtracking(Rolo[][] matriz, int row, int col, int espessuraAtual, double somaCustos, double melhorCusto) {
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

    public static void main(String[] args) {
        System.out.println(backtracking(
                construirMatrizRolos(matriz),
                0,
                1,
                matriz[0][0],
                0,
                Double.POSITIVE_INFINITY
        ));
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