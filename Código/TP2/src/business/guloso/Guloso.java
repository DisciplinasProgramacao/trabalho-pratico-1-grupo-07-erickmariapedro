package business.guloso;

import java.util.ArrayList;
import java.util.List;

public class Guloso {
	List<Integer> sequencia = new ArrayList<>();
	int custoTotal = 0;

	public List<Integer> guloso(int[][] matriz) {
		int espessuraFinal = 4;
		int espessuraEntrada = matriz[0][0];
		int reducao = 1;
		double melhorCusto = Double.MAX_VALUE;

		for (int j = 0; j < matriz[j].length; j++) {
			for (int i = 0; i < matriz.length; i++) {
				if (espessuraEntrada > espessuraFinal) {
					melhorCusto = Double.MAX_VALUE;
					double custo = matriz[i][reducao] / reducao;
					if (custo < melhorCusto) {
						melhorCusto = custo;
						sequencia.add(reducao);
						espessuraEntrada -= reducao;
						custoTotal += matriz[i][reducao];
					}
				}
			}
			reducao++;
		}
		return sequencia;
	}

	public int getTamanhoSequencia() {
		return sequencia.size();
	}

	public int getCustoTotal() {
		return custoTotal;
	}
}
