package com.cesurg.projetopagamento.infra.DTO;

import com.cesurg.projetopagamento.core.domain.model.Usuario;

public class ContaCreditoDTO {
    private Long usuarioId;
    private Integer agencia;
    private Integer limite;

    public ContaCreditoDTO() {}

    public ContaCreditoDTO(Long usuarioId, Integer agencia, Integer limite) {
        this.usuarioId = usuarioId;
        this.agencia = agencia;
        this.limite = limite;
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

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }
}
