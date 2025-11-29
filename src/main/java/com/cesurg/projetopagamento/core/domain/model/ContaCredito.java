package com.cesurg.projetopagamento.core.domain.model;

public class ContaCredito extends Conta{
    private Integer limiteCredito;
    private double faturaAtual;

    public void registrarCompra(double valor) {
        if (valor > limiteCredito - faturaAtual) {
            throw new IllegalArgumentException("Limite insuficiente");
        } else {
            faturaAtual += valor;
        }
    }

    @Override
    public void sacar(double valor) {
        throw new UnsupportedOperationException("Conta de crédito não permite sacar.");
    }


    public Integer getLimite() {
        return limiteCredito;
    }

    public void setLimite(Integer limite) {
        this.limiteCredito = limiteCredito;
    }
}
