package business;

public class ProgDinamica {
    ItemMatriz[][] matrizProg;
    final static int MAX_INT = Integer.MAX_VALUE;


    public ProgDinamica(int[][] custos){
        matrizProg = new ItemMatriz[custos[0].length][custos.length+1];

        for (int i = 0; i < custos.length; i++){
            matrizProg[0][i+1] = new ItemMatriz(custos[i][0],MAX_INT);
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
                if(matrizProg[i][j].getCusto() + 1 <= matrizProg[0][1].getCusto()){
                    total = m
                    matrizProg[i][j].setTotal(); = matrizProg[]
                }

            }
        }
    }




}
