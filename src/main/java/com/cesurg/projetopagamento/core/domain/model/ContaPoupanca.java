package com.cesurg.projetopagamento.core.domain.model;

public class ContaPoupanca extends Conta{
    private double taxaRendimento;

    public void aplicarRendimento() {
        double novoSaldo = getSaldo() + getSaldo() * taxaRendimento;
        setSaldo(novoSaldo);
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
}
