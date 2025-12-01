package com.cesurg.projetopagamento.core.domain.model;

public class Banco {

    private Long id;
    private String nome;
    private Integer agencia;

    public Banco() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
