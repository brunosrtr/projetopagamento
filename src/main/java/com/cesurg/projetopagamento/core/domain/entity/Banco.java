package com.cesurg.projetopagamento.core.domain.entity;

public class Banco {
    private String nome;
    private String agencia;

    public Banco(String nome, String agencia) {
        this.nome = nome;
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
}
