package com.cesurg.projetopagamento.infra.DTO;

import com.cesurg.projetopagamento.core.domain.model.Usuario;

public class ContaCreditoDTO {
    private Long usuarioId;
    private Long bancoId;
    private Integer limite;

    public ContaCreditoDTO() {}

    public ContaCreditoDTO(Long usuarioId, Long bancoId, Integer limite) {
        this.usuarioId = usuarioId;
        this.bancoId = bancoId;
        this.limite = limite;
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

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }
}
