package com.cesurg.projetopagamento.core.contract;

import com.cesurg.projetopagamento.core.domain.entity.Banco;

public interface BancoRepository {
    void criarBanco(Banco banco);
}
