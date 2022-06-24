package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForcaBruta {
    Mochila mochila = new Mochila(15);

	public List<List<ItemMochila>> encontrarSubConjunto(List<ItemMochila> itens) {

		List<List<ItemMochila>> subConjuntos = new ArrayList<>();

		if (itens.isEmpty()) {
			subConjuntos.add(Collections.emptyList());
			return subConjuntos;
		} else {
			List<List<ItemMochila>> recursivoConjunto = encontrarSubConjunto(itens.subList(1, itens.size()));
			for (int i = 0; i < recursivoConjunto.size(); i++) {
				List<ItemMochila> conjunto = recursivoConjunto.get(i);
				subConjuntos.add(conjunto);
				List<ItemMochila> item = new ArrayList<>(conjunto);
				item.add(0, itens.get(0));
				subConjuntos.add(item);
			}
		}
		return subConjuntos;
	}

	public Mochila conjuntoMaisValioso(List<ItemMochila> itens) throws Exception {
		List<List<ItemMochila>> subConjuntos = encontrarSubConjunto(itens);
		int maisValioso = 0;
		double peso = 0;
		int valor = 0;
		for (List<ItemMochila> item : subConjuntos) {
			valor = item.stream().reduce(0, (a,b) -> a + b.getValor(),Integer::sum);
			peso = item.stream().reduce(0, (a,b) -> a + b.getPeso(),Integer::sum);
			if (valor > maisValioso && peso <= mochila.getCapacidade()) {
				maisValioso = valor;
				this.mochila.setItens(item);
			}
		}

		return mochila;
	}
}
