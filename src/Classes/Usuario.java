package Classes;



public class Usuario extends Pessoa{
    
    private int id;
    private String email;
    private String senha;
    
    public Usuario(String nome, String cpf, String endereco, String telefone, String email, String senha) {
        super(nome, cpf, endereco, telefone);
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
