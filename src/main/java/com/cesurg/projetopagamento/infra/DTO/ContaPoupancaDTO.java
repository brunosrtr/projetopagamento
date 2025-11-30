package com.cesurg.projetopagamento.infra.DTO;

import com.cesurg.projetopagamento.core.domain.model.Usuario;

public class ContaPoupancaDTO {
    private Long usuarioId;
    private Integer agencia;
    private Double saldo;
    private Double taxaRendimento;

    public ContaPoupancaDTO() {}

    public ContaPoupancaDTO(Long usuarioId, Integer agencia, Double saldo, Double taxaRendimento) {
        this.usuarioId = usuarioId;
        this.agencia = agencia;
        this.saldo = saldo;
        this.taxaRendimento = taxaRendimento;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuario(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(Double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
}
