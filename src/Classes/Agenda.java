package Classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alamtrindade
 */
public class Agenda {

    private int id;
    private String CPFCliente;
    private String placaVeiculo;
    private String CPFProfissional;
    private String servico;
    private String data;
    private String hora;
    private boolean status;
    private String observacoes;
    private Double preco;

    public Agenda(String CPFCliente, String placaVeiculo, String CPFProfissional, String servico, String data, String hora, boolean status, String observacoes, Double preco) {
        this.CPFCliente = CPFCliente;
        this.placaVeiculo = placaVeiculo;
        this.CPFProfissional = CPFProfissional;
        this.servico = servico;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.observacoes = observacoes;
        this.preco = preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPreco() {
        return preco;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCPFCliente(String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public void setCPFProfissional(String CPFProfissional) {
        this.CPFProfissional = CPFProfissional;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public String getCPFCliente() {
        return CPFCliente;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public String getCPFProfissional() {
        return CPFProfissional;
    }

    public String getServico() {
        return servico;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    
}
