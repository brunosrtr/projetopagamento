package com.cesurg.projetopagamento.core.interfaces;

import com.cesurg.projetopagamento.core.domain.model.Conta;

import java.util.List;

public interface ContaRepository {
    void criarConta (Conta conta);
    void atualizarSaldo (String id, Double saldo);
    void deletarConta (String id);
    List<Conta> listarConta ();

    void transferir(String idOrigem, String idDestino, Double valor);
    Conta buscarPorIdentificador(String identificador);

    void depositar(String identificador, Double valor);
    void sacar(String identificador, Double valor);

    void registrarCompra(String identificador, Double valor);

}
