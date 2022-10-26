package Classes;



public class Materiap extends Material{
    
    private int id;
    private int quantidade;
    
    public Materiap(String tipo, String descricao, int quantidade){
        super(tipo,descricao);
        this.quantidade = quantidade;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
