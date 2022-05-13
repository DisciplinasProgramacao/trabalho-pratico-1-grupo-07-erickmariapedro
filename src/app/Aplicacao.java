package app;

import business.ItemMochila;
import business.Mochila;
import business.SortByValorPeso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Aplicacao {

    public static List<ItemMochila> geradorDeItens(int capacidade, int quantidadeDeItens) {
        List<ItemMochila> itens = new ArrayList<>();
        Random gerador = new Random();
        for (int i = 0; i < quantidadeDeItens;i++) {
            int peso = gerador.nextInt((int) ( (capacidade * 5 / quantidadeDeItens) - (capacidade / quantidadeDeItens))+1) + capacidade/ quantidadeDeItens;
            int valor =  gerador.nextInt(99) + 1;
            itens.add(new ItemMochila(i,peso,valor));
        }
        return itens;
    }
    
    public static void main(String[] args) throws Exception {
        Mochila mochila = new Mochila(15);
         List<ItemMochila> itens = new ArrayList<ItemMochila>();
        long start, elapsed = 0, elapsedTotal = 0;
        int cont = 60000;
        /*while (elapsed < 4000) {
            start = System.currentTimeMillis();
            itens = geradorDeItens(mochila.getCapacidade(),cont);
            Collections.sort(itens, new SortByValorPeso());

            for (int i = 0; i<itens.size();i++) {
                int capacidadeUtilizada = mochila.getItens().stream().reduce(0, (a,b) -> a + b.getPeso(),Integer::sum);
                if(itens.get(i).getPeso() <= mochila.getCapacidade() - capacidadeUtilizada) {
                    mochila.addItemMochila(itens.get(i));
                }
            }
            cont = cont + 1;
            elapsed  = System.currentTimeMillis() - start;
            elapsedTotal += elapsed;
            System.out.println("Quantidade de itens: " + cont);
            System.out.println("Tempo: " + elapsed);
        }*/
        start = System.currentTimeMillis();



        cont = cont + 1;
        elapsed  = System.currentTimeMillis() - start;


        System.out.println("Quantidade de itens: " + cont);
        System.out.println("Tempo total: " + elapsed);
    }
}
