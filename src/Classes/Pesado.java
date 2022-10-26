package Classes;



public class Pesado extends Veiculo{
    
    private int id;
    private int eixos;
    private String cacamba;
    
    public Pesado(String placa, String marca, String modelo, int ano, String cor, int eixos, String cacamba, String CPF) {
        super(placa, marca, modelo, ano, cor, CPF);
        this.eixos = eixos;
        this.cacamba = cacamba;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos) {
        this.eixos = eixos;
    }
    
    public String getCacamba() {
        return cacamba;
    }

    public void setCacamba(String cacamba) {
        this.cacamba = cacamba;
    }
} 
