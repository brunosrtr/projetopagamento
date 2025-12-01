package com.cesurg.projetopagamento.core.interfaces;

import com.cesurg.projetopagamento.core.domain.model.Banco;
import com.cesurg.projetopagamento.core.domain.model.Conta;
import com.cesurg.projetopagamento.core.domain.model.Usuario;

import java.util.List;

public interface BancoRepository {
    void criarBanco (Banco banco);
    void atualizarBanco (Integer agencia, Banco banco);
    void deletarBanco (Integer agencia);
    List<Banco> listarBanco ();
    Banco buscarPorId(Long id);
}
