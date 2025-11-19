package com.cesurg.projetopagamento.core.interfaces;

import com.cesurg.projetopagamento.core.domain.model.ContaCorrente;
import com.cesurg.projetopagamento.core.domain.model.ContaPoupanca;

public interface ContaPoupancaUseCase {
    void criarContaPoupanca(ContaPoupanca contaP);
    void atualizarContaPoupanca(ContaPoupanca contaP);
    void deletarContaCorrente(ContaPoupanca contaP);
    void transfereciaEntreUsuario(ContaPoupanca contaDeEnvio, ContaPoupanca contaAreceber, Integer saldo);
}
