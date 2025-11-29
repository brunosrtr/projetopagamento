package com.cesurg.projetopagamento.infra.repository;

import com.cesurg.projetopagamento.core.domain.model.Conta;
import com.cesurg.projetopagamento.core.interfaces.ContaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ContaRepositoryImpl implements ContaRepository {
    List<Conta> contas = new ArrayList<>();

    @Override
    public void criarConta(Conta conta) {
        contas.add(conta);
        conta.setIdentificador(conta.getId_usuario().toString() + "-" + conta.getAgencia().toString());
    }

    @Override
    public void atualizarSaldo(String id, double saldo) {
        for (int i = 0; i < contas.size(); i++) {
            Conta c = contas.get(i);
            if (Objects.equals(c.getIdentificador(), id)) {
                contas.get(i).setSaldo(saldo);
            }
        }
    }

    @Override
    public void deletarConta(String id) {
        for (int i = 0; i < contas.size(); i++) {
            Conta c = contas.get(i);
            if (Objects.equals(c.getIdentificador(), id)) {
                contas.remove(i);
            }
        }
    }

    @Override
    public List<Conta> listarConta() {
        return contas;
    }
}
