package com.cesurg.projetopagamento.core.contract;

import com.cesurg.projetopagamento.core.domain.entity.Conta;

import java.util.List;

public interface ContaRepository {
    void criar(Conta conta);
    List<Conta> listar();
    void atualizr(Conta conta);
    void deletar(Conta conta);
}
