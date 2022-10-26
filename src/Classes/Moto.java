package Classes;



public class Moto extends Veiculo{
    
    private int id;
    private String porte;
    
    public Moto(String placa, String marca, String modelo, int ano, String cor, String porte, String CPF) {
        super(placa, marca, modelo, ano, cor, CPF);
        this.porte = porte;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getPorte() {
        return porte;
    }

    public void setPortas(String porte) {
        this.porte = porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }


    
}
