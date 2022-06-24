package app;

import business.ForcaBruta;
import business.Guloso;
import business.ItemMochila;
import business.Mochila;

import java.util.ArrayList;
import java.util.Collections;
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

        for (int i = 0; i<250; i++ ) {
            itens = geradorDeItens(15, 22);
            mochilaForcaBruta = forcaBruta.conjuntoMaisValioso(itens);
            mochilaGulosa = guloso.mochilaGulosa(itens);
            if (mochilaForcaBruta.valorTotal() == mochilaGulosa.valorTotal() &&
            mochilaForcaBruta.pesoTotal() == mochilaGulosa.pesoTotal()) {
                contador++;
            }
        }
        return contador;
    }
    
    public static void main(String[] args) throws Exception {
        ForcaBruta forcaBruta = new ForcaBruta();
        Guloso guloso = new Guloso();
        int resultado = contaIgualdadeIteracoes(forcaBruta, guloso);
        System.out.println("Quantidade de mochilas iguais: " + resultado);
        /*
         Mochila mochila1 = new Mochila(15);
        List<ItemMochila> itens = new ArrayList<>();
        long start, elapsed = 0;
        int cont = 0;
        while (elapsed < 4000) {
            start = System.currentTimeMillis();
            itens = geradorDeItens(mochila1.getCapacidade(),cont);
            forcaBruta.conjuntoMaisValioso(itens);
            cont = cont + 1;
            elapsed  = System.currentTimeMillis() - start;
            System.out.println("Quantidade de itens: " + cont);
        }
        start = System.currentTimeMillis();
        cont = cont + 1;
        elapsed  = System.currentTimeMillis() - start;

        System.out.println("Quantidade de itens: " + cont);
        System.out.println("Tempo total: " + elapsed);*/
    }
}
