package com.cesurg.projetopagamento.infra.DTO;

public class ContaPoupancaDTO {
    private Long usuarioId;
    private Long bancoId;
    private Double saldo;
    private Double taxaRendimento;

    public ContaPoupancaDTO() {}

    public ContaPoupancaDTO(Long usuarioId, Long bancoId, Double saldo, Double taxaRendimento) {
        this.usuarioId = usuarioId;
        this.bancoId = bancoId;
        this.saldo = saldo;
        this.taxaRendimento = taxaRendimento;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getBancoId() {
        return bancoId;
    }

    public void setBancoId(Long bancoId) {
        this.bancoId = bancoId;
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
