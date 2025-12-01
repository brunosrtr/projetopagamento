package com.cesurg.projetopagamento.infra.DTO;

public class OperacaoDTO {
    private String identificador;
    private Double valor;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

