package com.cesurg.projetopagamento.core.interfaces;

import com.cesurg.projetopagamento.core.domain.model.ContaCorrente;

import java.util.List;

public interface ContaCorrenteRepository {
    void criarConta (ContaCorrente contaC);
    void atualizarSaldo (String id, Integer saldo);
    void deletarConta (String id);
    List<ContaCorrente> listarConta ();
}
