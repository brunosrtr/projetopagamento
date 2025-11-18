package com.cesurg.projetopagamento.core.interfaces;

import com.cesurg.projetopagamento.core.domain.model.Banco;

import java.util.List;

public interface BancoUseCase {
    void criarBanco (Banco banco);
    void atualizarBanco (Integer agencia, Banco banco);
    void deletarBanco (Integer agencia);
    List<Banco> listarBanco ();
}
