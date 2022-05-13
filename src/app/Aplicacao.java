package app;

import business.ForcaBruta;
import business.Guloso;
import business.ItemMochila;
import business.Mochila;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aplicacao {

    public static List<ItemMochila> geradorDeItens(int capacidade, int quantidadeDeItens) {
        List<ItemMochila> itens = new ArrayList<>();
        Random gerador = new Random();
        for (int i = 0; i < quantidadeDeItens;i++) {
            int peso = gerador.nextInt(( (capacidade * 4 / quantidadeDeItens) - (capacidade * 2 / quantidadeDeItens)) +1) + (capacidade * 2/ quantidadeDeItens);
            int valor =  gerador.nextInt(99) + 1;
            itens.add(new ItemMochila(i,peso,valor));
        }
        return itens;
    }

    public static int contaIgualdadeIteracoes(ForcaBruta forcaBruta, Guloso guloso) throws Exception {
        int contador = 0;
        List<ItemMochila> itens;
        Mochila mochilaGulosa;
        Mochila mochilaForcaBruta;

        for (int i = 0; i<500; i++ ) {
            itens = geradorDeItens(15, 60000);
            mochilaForcaBruta = forcaBruta.conjuntoMaisValioso(itens);
            mochilaGulosa = guloso.mochilaGulosa(itens);
            if (mochilaForcaBruta == mochilaGulosa) {
                contador++;
            }
        }
        return contador;
    }
    
    public static void main(String[] args) throws Exception {
        ForcaBruta forcaBruta = new ForcaBruta();
        Guloso guloso = new Guloso();
        int resultado = contaIgualdadeIteracoes(forcaBruta, guloso);
        System.out.println(resultado);
        long start, elapsed;
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
