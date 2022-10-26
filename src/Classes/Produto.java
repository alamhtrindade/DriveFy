package Classes;



public class Produto extends Material{
    
    private int id;
    private double valor;
    private int quantidade;
    
    public Produto(String tipo, String descricao, double valor, int quantidade){
        super(tipo,descricao);
        this.valor = valor;
        this.quantidade = quantidade;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
