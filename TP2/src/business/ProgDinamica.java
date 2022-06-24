package business;

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
                matrizProg[j][i] = new ItemMatriz(custos[i-1][j]);
            }
        }
        preencheMatriz();
    }
    private void preencheMatriz(){
        int total = 0;
        for (int i = 1; i < matrizProg.length;i++){
            for (int j = 2; j < matrizProg[0].length; j++){
                matrizProg[i][j].setTotal(verificaMelhorTotal(i,j));
            }
        }
    }

    private int verificaMelhorTotal(int i, int j) {
        if (j - i > 0) {
            if (matrizProg[0][j - i] != null && matrizProg[0][j].getCusto() + i <= matrizProg[0][j - i].getCusto()){
                if (matrizProg[i - 1][j].getTotal() > matrizProg[i][j - i].getSoma()) {
                    return matrizProg[i][j - i].getSoma();
                }
            }
        }
        return matrizProg[i - 1][j].getTotal();
    }




}
