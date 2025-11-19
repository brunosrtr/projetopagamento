package com.cesurg.projetopagamento.core.interfaces;

import com.cesurg.projetopagamento.core.domain.model.ContaCredito;

import java.util.List;

public interface ContaCreditoRepository {
    void criarConta (ContaCredito conta);
    void atualizarSaldo (String id, Integer saldo);
    void deletarConta (String id);
    List<ContaCredito> listarConta ();
}