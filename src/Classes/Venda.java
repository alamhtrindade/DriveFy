package Classes;


public class Venda {

    private int IDvenda;
    private String CPFCliente;
    private String Id_produto;
    private String Nome_produto;
    private String preco;
    private String qtd;
    private String totalVenda;
    private String Data;

    public Venda(String CPFCliente, String Id_produto, String Nome_produto, String preco, String qtd, String totalVenda, String Data) {
        this.CPFCliente = CPFCliente;
        this.Id_produto = Id_produto;
        this.Nome_produto = Nome_produto;
        this.preco = preco;
        this.qtd = qtd;
        this.totalVenda = totalVenda;
        this.Data = Data;
    }

    public String getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(String totalVenda) {
        this.totalVenda = totalVenda;
    }
    
    

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    public void setIDvenda(int IDvenda) {
        this.IDvenda = IDvenda;
    }

    public void setCPFCliente(String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }

    public void setId_produto(String Id_produto) {
        this.Id_produto = Id_produto;
    }

    public void setNome_produto(String Nome_produto) {
        this.Nome_produto = Nome_produto;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public int getIDvenda() {
        return IDvenda;
    }

    public String getCPFCliente() {
        return CPFCliente;
    }

    public String getId_produto() {
        return Id_produto;
    }

    public String getNome_produto() {
        return Nome_produto;
    }

    public String getPreco() {
        return preco;
    }

    public String getData() {
        return Data;
    }

}
