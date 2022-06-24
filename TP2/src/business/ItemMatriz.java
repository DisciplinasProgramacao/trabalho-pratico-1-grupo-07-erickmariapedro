package business;

public class ItemMatriz {
    int custo;
    int total;

    public ItemMatriz(int custo){
        setCusto(custo);
        setTotal(0);
    }
    public ItemMatriz(int custo,int max){
        setCusto(custo);
        setTotal(max);
    }


    @Override
    public String toString() {
        return "ItemMatriz{" +
                "custo=" + custo +
                ", total=" + total +
                '}';
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSoma(){
        return this.getCusto() + this.getTotal();
    }
}
