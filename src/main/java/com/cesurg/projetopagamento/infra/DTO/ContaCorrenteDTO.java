package com.cesurg.projetopagamento.infra.DTO;

import com.cesurg.projetopagamento.core.domain.model.Usuario;

public class ContaCorrenteDTO {
    private Long usuarioId;
    private Integer agencia;
    private Double saldo;

    public ContaCorrenteDTO() {}

    public ContaCorrenteDTO(Long usuarioId, Integer agencia, Double saldo) {
        this.usuarioId = usuarioId;
        this.agencia = agencia;
        this.saldo = saldo;
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
}
