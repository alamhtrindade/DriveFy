package Classes;



public class Profissional extends Pessoa{
    private int id;
    private String funcao;
    private double salario;
    private boolean ativo;
    
    public Profissional(String nome, String cpf, String endereco, String telefone, String funcao, Double salario) {
        super(nome, cpf, endereco, telefone);
        this.funcao = funcao;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
}
