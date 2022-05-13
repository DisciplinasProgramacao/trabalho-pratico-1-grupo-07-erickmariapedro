package business;
import java.util.Collections;
import java.util.List;



public class Guloso {
    Mochila mochila = new Mochila(15);

    public Mochila mochilaGulosa (List<ItemMochila> itens) throws Exception {

        Collections.sort(itens, new SortByValorPeso());
        for (int i = 0; i<itens.size();i++) {
            int capacidadeUtilizada = mochila.getItens().stream().reduce(0, (a,b) -> a + b.getPeso(),Integer::sum);
            if(itens.get(i).getPeso() <= mochila.getCapacidade() - capacidadeUtilizada) {
                this.mochila.addItemMochila(itens.get(i));
            }
        }
        return mochila;
    }
}
