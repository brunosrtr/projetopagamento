package com.cesurg.projetopagamento.core.domain.model;

public class Banco {

    private String nome;
    private Integer agencia;

    public Banco() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }
}
