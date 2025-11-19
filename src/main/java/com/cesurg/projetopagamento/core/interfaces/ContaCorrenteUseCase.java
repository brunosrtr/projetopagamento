package com.cesurg.projetopagamento.core.interfaces;

import com.cesurg.projetopagamento.core.domain.model.Conta;
import com.cesurg.projetopagamento.core.domain.model.ContaCorrente;

public interface ContaCorrenteUseCase {
    void criarContaCorrente(ContaCorrente contaCr);
    void atualizarContaCorrente(ContaCorrente contaCr);
    void deletarContaCorrente(ContaCorrente contaCr);
    void transfereciaEntreUsuario(ContaCorrente contaDeEnvio, ContaCorrente contaAreceber, Integer saldo);
}
