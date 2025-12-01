package com.cesurg.projetopagamento.core.domain.usecase;

import ch.qos.logback.core.joran.spi.ElementPath;
import com.cesurg.projetopagamento.core.domain.model.Banco;
import com.cesurg.projetopagamento.core.interfaces.BancoRepository;
import com.cesurg.projetopagamento.core.interfaces.BancoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BancoUseCaseImpl implements BancoUseCase {
    @Autowired
    BancoRepository bancoRepository;

    @Override
    public void criarBanco(Banco banco) {

        boolean agenciaExiste = false;

        for (int i = 0; i < listarBanco().size(); i++) {
            Banco b = listarBanco().get(i);
            if (Objects.equals(b.getAgencia(), banco.getAgencia())) {
                agenciaExiste = true;
            }
        }

        if (agenciaExiste) {
            throw new IllegalArgumentException("Esse número de agencia já existe");
        } else {
            bancoRepository.criarBanco(banco);
        }
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

    @Override
    public Banco buscarPorId(Long id) {
        return bancoRepository.buscarPorId(id);
    }
}
