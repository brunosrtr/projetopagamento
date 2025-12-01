package com.cesurg.projetopagamento.infra.DTO;

import com.cesurg.projetopagamento.core.domain.model.Usuario;

public class ContaCorrenteDTO {
    private Long usuarioId;
    private Long bancoId;
    private Double saldo;

    public ContaCorrenteDTO() {}

    public ContaCorrenteDTO(Long usuarioId, Long bancoId, Double saldo) {
        this.usuarioId = usuarioId;
        this.bancoId = bancoId;
        this.saldo = saldo;
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
}
