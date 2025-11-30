package com.cesurg.projetopagamento.infra.transferenciaDTO;

public class TransferenciaDTO {

    private String idOrigem;

    private String idDestino;

    private Double valor;

    public TransferenciaDTO() {}

    public TransferenciaDTO(String idOrigem, String idDestino, Double valor) {
        this.idOrigem = idOrigem;
        this.idDestino = idDestino;
        this.valor = valor;
    }

    public String getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(String idOrigem) {
        this.idOrigem = idOrigem;
    }

    public String getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(String idDestino) {
        this.idDestino = idDestino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
