package com.cesurg.projetopagamento.core.interfaces;

import com.cesurg.projetopagamento.core.domain.model.ContaCorrente;

public interface ContaCreditoUseCase {
    void criarContaCredito(ContaCorrente contaC);
    void atualizarContaCredito(ContaCorrente contaC);
    void deletarContaCredito(ContaCorrente contaC);
    //void transfereciaEntreUsuario(ContaCorrente contaDeEnvio, ContaCorrente contaAreceber, Integer saldo);
}
