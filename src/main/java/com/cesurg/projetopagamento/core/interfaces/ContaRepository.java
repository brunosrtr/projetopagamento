package com.cesurg.projetopagamento.core.interfaces;

import com.cesurg.projetopagamento.core.domain.model.Conta;
import com.cesurg.projetopagamento.core.domain.model.Usuario;

import java.util.List;

public interface ContaRepository {
    void criarConta (Conta conta);
    void atualizarSaldo (String id, double saldo);
    void deletarConta (String id);
    List<Conta> listarConta ();
}
