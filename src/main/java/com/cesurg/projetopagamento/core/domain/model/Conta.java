package com.cesurg.projetopagamento.core.domain.model;

public class Conta {

    private Long id;
    private Usuario usuario;
    private Banco banco;
    private Double saldo;
    private String identificador;

    public void depositar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor inválido");
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        } else if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        } else {
            this.saldo -= valor;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

}
