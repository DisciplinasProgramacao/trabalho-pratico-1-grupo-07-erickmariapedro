package business.progDinamica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgDinamica {
    ItemMatriz[][] matrizProg;
    final static int MAX_INT = Integer.MAX_VALUE;


    public ProgDinamica(int[][] custos){
        matrizProg = new ItemMatriz[custos[0].length][custos.length+2];

        for (int i = 0; i <= custos.length; i++){
            if(i < custos.length){
                matrizProg[0][i+1] = new ItemMatriz(custos[i][0],MAX_INT);
            }
            else {
                matrizProg[0][i+1] = new ItemMatriz(4,MAX_INT);
            }

        }
        for (int i = 1; i < matrizProg.length; i++){
            matrizProg[i][0] = new ItemMatriz(i,0);
        }
        for (int i = 1; i < matrizProg[0].length;i++){
            for (int j = 1; j < matrizProg.length; j++){
                if (i-1 < custos.length){
                    matrizProg[j][i] = new ItemMatriz(custos[i-1][j]);
                }
                else {
                    matrizProg[j][i] = new ItemMatriz(0);
                }
            }
        }
        preencheMatriz();
    }

    private void preencheMatriz(){
        for (int i = 1; i < matrizProg.length;i++){
            for (int j = 2; j < matrizProg[0].length; j++){
                matrizProg[i][j].setTotal(retornaMelhorTotal(i,j));
            }
        }
    }

    private int retornaMelhorTotal(int i, int j) {
        int total = 0;
        if (j - i > 0) {
            if (matrizProg[0][j - i] != null && matrizProg[0][j].getCusto() + i <= matrizProg[0][j - i].getCusto()){
                total = verificaMelhorTotal(i,j);
            }
        }else {
            total = matrizProg[i - 1][j].getTotal();
        }
        return total;
    }

    private int verificaMelhorTotal(int i, int j){
        if (i == 1){
            return matrizProg[i][j - i].getSoma();
        }
        int anteriorLinha = matrizProg[i][j - i].getSoma();
        int anteriorColuna = matrizProg[i-1][j].getTotal();
        int anterior1 = matrizProg[1][j-1].getCusto() + matrizProg[i][j - 1].getTotal();
        int[] totais = {anteriorLinha, anteriorColuna, anterior1};

        return Arrays.stream(totais).min().getAsInt();
    }
    public List<Integer> getSequenciaCilindros(){
        List<Integer> sequencia = new ArrayList<>();
        int ultimaCelula = 7;
        do {
            int diff = matrizProg[3][ultimaCelula].getTotal() - matrizProg[3][ultimaCelula-1].getTotal();
            if (diff == matrizProg[1][ultimaCelula-1].getCusto()){
                sequencia.add(1);
                ultimaCelula--;
                continue;
            }else if (diff == matrizProg[2][ultimaCelula-2].getCusto()){
                sequencia.add(2);
                ultimaCelula -= 2;
                continue;
            }else{
                sequencia.add(3);
                ultimaCelula -= 3;
                continue;
            }
        }while (ultimaCelula > 1);

        return sequencia;
    }

    public int getTamanhoSequencia(){
        return getSequenciaCilindros().size();
    }


}
