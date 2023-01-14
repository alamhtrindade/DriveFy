package Classes;



public class Carro extends Veiculo{
    
    private int id;
    private int portas;
    private String categoria;
    
    public Carro(String placa, String marca, String modelo, int ano, String cor, int portas, String categoria, String CPF) {
        super(placa, marca, modelo, ano, cor, CPF);
        this.portas = portas;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
}
