package com.cesurg.projetopagamento.core.domain.usecase;

import com.cesurg.projetopagamento.core.domain.model.Banco;
import com.cesurg.projetopagamento.core.interfaces.BancoRepository;
import com.cesurg.projetopagamento.core.interfaces.BancoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoUseCaseImpl implements BancoUseCase {
    @Autowired
    BancoRepository bancoRepository;

    @Override
    public void criarBanco(Banco banco) {
        bancoRepository.criarBanco(banco);
    }

    @Override
    public void atualizarBanco(Integer agencia, Banco banco) {
        bancoRepository.atualizarBanco(agencia, banco);
    }

    @Override
    public void deletarBanco(Integer agencia) {
        bancoRepository.deletarBanco(agencia);
    }

    @Override
    public List<Banco> listarBanco() {
        return bancoRepository.listarBanco();
    }
}
