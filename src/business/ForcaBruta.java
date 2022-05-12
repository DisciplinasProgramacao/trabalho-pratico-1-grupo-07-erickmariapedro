package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForcaBruta {

	public static List<List<ItemMochila>> encontrarSubConjunto(List<ItemMochila> itens) {

		List<List<ItemMochila>> subConjuntos = new ArrayList<>();

		if (itens.isEmpty()) {
			subConjuntos.add(Collections.emptyList());
			return subConjuntos;
		} else {
			List<List<ItemMochila>> recursivoConjunto = encontrarSubConjunto(itens.subList(1, itens.size()));
			for (int i = 0; i < recursivoConjunto.size(); i++) {
				List<ItemMochila> conjunto = recursivoConjunto.get(i);
				subConjuntos.add(conjunto);
				List<ItemMochila> item = new ArrayList<ItemMochila>(conjunto);
				item.add(0, itens.get(0));
				subConjuntos.add(item);
			}
		}
		return subConjuntos;
	}

	public static int conjuntoMaisValioso(List<ItemMochila> itens, int capacidade) {
		List<List<ItemMochila>> subConjuntos = encontrarSubConjunto(itens);
		int maisValioso = 0;

		for (int i = 0; i < subConjuntos.size(); i++) {
			double peso = 0;
			int valor = 0;
			for (ItemMochila item : subConjuntos.get(i)) {
				peso += item.getPeso();
			}

			if (peso <= capacidade) {
				for (ItemMochila item : subConjuntos.get(i)) {
					valor += item.getValor();
				}
				if (valor > maisValioso) {
					maisValioso = valor;
				}
			}
		}
		return maisValioso;
	}

}
