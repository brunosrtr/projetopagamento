package com.cesurg.projetopagamento.core.interfaces;

import com.cesurg.projetopagamento.core.domain.model.ContaPoupanca;

import java.util.List;

public interface ContaPoupancaRepository {
    void criarConta (ContaPoupanca conta);
    void atualizarSaldo (String id, Integer saldo);
    void deletarConta (String id);
    List<ContaPoupanca> listarConta ();
}
