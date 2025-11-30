package com.cesurg.projetopagamento.core.domain.usecase;

import com.cesurg.projetopagamento.core.domain.model.Conta;
import com.cesurg.projetopagamento.core.interfaces.ContaRepository;
import com.cesurg.projetopagamento.core.interfaces.ContaUseCase;
import com.cesurg.projetopagamento.infra.repository.ContaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaUseCaseImpl implements ContaUseCase {
    @Autowired
    ContaRepository contaRepository;
    @Override
    public void criarConta(Conta conta) {
        contaRepository.criarConta(conta);
    }

    @Override
    public void atualizarSaldo(String id, Double saldo) {
        contaRepository.atualizarSaldo(id, saldo);
    }

    @Override
    public void deletarConta(String id) {
        contaRepository.deletarConta(id);
    }

    @Override
    public List<Conta> listarConta() {
        return contaRepository.listarConta();
    }

    @Override
    public void transferir(String idOrigem, String idDestino, Double valor) {
        contaRepository.transferir(idOrigem, idDestino, valor);
    }

    @Override
    public Conta buscarPorIdentificador(String identificador) {
        return contaRepository.buscarPorIdentificador(identificador);
    }

    @Override
    public void depositar(String identificador, Double valor) {
        contaRepository.depositar(identificador, valor);
    }

    @Override
    public void sacar(String identificador, Double valor) {
        contaRepository.sacar(identificador, valor);
    }
}
