package com.cesurg.projetopagamento.core.interfaces;

import com.cesurg.projetopagamento.core.domain.model.Conta;

import java.util.List;

public interface ContaUseCase {
    void criarConta (Conta conta);
    void atualizarSaldo (String id, double saldo);
    void deletarConta (String id);
    List<Conta> listarConta ();
}
