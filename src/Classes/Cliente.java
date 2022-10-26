package Classes;



public class Cliente extends Pessoa{
    private int id;
    private int fidelidade;
    
    public Cliente(String nome, String cpf, String endereco, String telefone, int fidelidade) {
        super(nome, cpf, endereco, telefone);
        this.fidelidade = fidelidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(int fidelidade) {
        this.fidelidade = fidelidade;
    }
    
    
}
