package com.cesurg.projetopagamento.infra.repository;

import com.cesurg.projetopagamento.core.domain.model.Conta;
import com.cesurg.projetopagamento.core.domain.model.Usuario;
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
        conta.setIdentificador(conta.getUsuario().getId().toString() + "-" + conta.getAgencia().toString());
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

    @Override
    public void transferir(String idOrigem, String idDestino, double valor) {
        Conta contaOrigem = null;
        Conta contaDestino = null;

        for(Conta c : contas){
            if(Objects.equals(c.getIdentificador(), idDestino)){
                contaOrigem = c;
            }
            if(Objects.equals(c.getIdentificador(), idOrigem)){
                contaDestino = c;
            }
            if(contaOrigem != null && contaDestino != null){
                break;
            }
        }

        if (contaOrigem == null) {
            throw new IllegalArgumentException("Conta de origem não encontrada");
        }
        if (contaDestino == null) {
            throw new IllegalArgumentException("Conta de destino não encontrada");
        }
        if (contaOrigem.getSaldo() < valor) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
    }

    @Override
    public Conta buscarPorIdentificador(String identificador) {
        return null;
    }
}
