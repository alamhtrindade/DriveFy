package Classes;


public class Servico {

    
    private int id;
    private String nome_servico;
    private String descricao_servico;
    private Double preco; 

    public Servico(String nome_servico, String descricao_servico, Double preco) {
        this.nome_servico = nome_servico;
        this.descricao_servico = descricao_servico;
        this.preco = preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    
    public Double getPreco() {
        return preco;
    }
    
    

    public int getId() {
        return id;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public String getDescricao_servico() {
        return descricao_servico;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public void setDescricao_servico(String descricao_servico) {
        this.descricao_servico = descricao_servico;
    }
    
    
    
    
}
