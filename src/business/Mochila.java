package business;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
    private int capacidade;
    private List<ItemMochila> itens;

    public Mochila (int capacidade){
        itens = new ArrayList<>();
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void addItemMochila(ItemMochila item) throws Exception {
        if (item != null) {
            itens.add(item);
        } else {
            throw new Exception("Item nulo");
        }
    }

    public List<ItemMochila> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "Mochila{" +
                "capacidade=" + capacidade +
                ", itens=" + itens +
                '}';
    }
}