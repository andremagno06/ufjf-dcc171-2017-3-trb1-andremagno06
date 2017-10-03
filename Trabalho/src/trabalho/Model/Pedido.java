package trabalho.Model;

public class Pedido{
    private Item item;
    private int quantidade;
    private double preco;
    

    public Pedido() {
    }

    public Pedido(Item item, int quantidade, double preco) {
        this.item = item;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    @Override
    public String toString() {
        return item.getNome() + "  |  PREÇO UNIDADE: " +item.getPreco()+"  |  QUANTIDADE: "+ quantidade+ "  |  PREÇO TOTAL: R$" +preco  ;
    }
    
 
    
    
}
