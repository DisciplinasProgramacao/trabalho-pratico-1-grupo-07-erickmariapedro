package business;

public class ItemMochila {
    private int id;
    private int peso;
    private int valor;
    private double valorPeso;

    public ItemMochila(int id, int peso, int valor) {
        this.id = id;
        this.peso = peso;
        this.valor = valor;
        this.valorPeso = (double) valor/peso;
    }

    public int getId() {
        return id;
    }

    public int getPeso() {
        return peso;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "ItemMochila{" +
                "id=" + id +
                ", peso=" + peso +
                ", valor=" + valor +
                ", valorPeso=" + valorPeso +
                '}';
    }

    public double getValorPeso() {
        return valorPeso;
    }

}