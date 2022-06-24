package business;

import java.util.Comparator;

public class SortByValorPeso implements Comparator<ItemMochila> {

    @Override
    public int compare(ItemMochila o1, ItemMochila o2) {
        if(o1.getValorPeso() < o2.getValorPeso()) {
            return 1;
        } else {
            return -1;
        }
    }
}
