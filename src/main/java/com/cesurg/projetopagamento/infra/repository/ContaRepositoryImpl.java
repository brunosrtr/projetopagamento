package com.cesurg.projetopagamento.infra.repository;

import com.cesurg.projetopagamento.core.domain.model.*;
import com.cesurg.projetopagamento.core.interfaces.ContaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ContaRepositoryImpl implements ContaRepository {
    List<Conta> contas = new ArrayList<>();
    Long contador = 1L;

    @Override
    public void criarConta(Conta conta) {
        conta.setId(contador);

        if (conta instanceof ContaPoupanca) {
            conta.setIdentificador("CP-" + conta.getUsuario().getId().toString() + "-" + conta.getAgencia().toString());
        } else if (conta instanceof ContaCredito) {
            conta.setIdentificador("CR-" + conta.getUsuario().getId().toString() + "-" + conta.getAgencia().toString());
        } else if (conta instanceof ContaCorrente) {
            conta.setIdentificador("CC-" + conta.getUsuario().getId().toString() + "-" + conta.getAgencia().toString());
        }

        boolean identificadorExiste = false;

        for (int i = 0; i < listarConta().size(); i++) {
            Conta c = listarConta().get(i);
            if (Objects.equals(c.getIdentificador(), conta.getIdentificador())) {
                identificadorExiste = true;
            }
        }

        if (identificadorExiste) {
            throw new IllegalArgumentException("Este identificador já existe");
        } else {
            contas.add(conta);
            contador++;
        }
    }

    @Override
    public void atualizarSaldo(String id, Double saldo) {
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
    public void transferir(String idOrigem, String idDestino, Double valor) {
        Conta contaOrigem = null;
        Conta contaDestino = null;

        for(Conta c : contas){
            if(Objects.equals(c.getIdentificador(), idOrigem)){
                contaOrigem = c;
            }
            if(Objects.equals(c.getIdentificador(), idDestino)){
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
        Conta contaAlvo = null;
        for(Conta c : contas){
            if(Objects.equals(c.getIdentificador(), identificador)){
                contaAlvo =c;
                break;
            }
        }
        if(contaAlvo == null){
            throw new IllegalArgumentException("Conta não encontrada: " + identificador);
        }
        return contaAlvo;
    }

    @Override
    public void depositar(String identificador, Double valor) {
        Conta conta = buscarPorIdentificador(identificador);
        conta.depositar(valor);
    }

    @Override
    public void sacar(String identificador, Double valor) {
        Conta conta = buscarPorIdentificador(identificador);
        conta.sacar(valor);
    }

    @Override
    public void registrarCompra(String identificador, Double valor) {
        Conta conta = buscarPorIdentificador(identificador);

        if(conta instanceof ContaCredito){
            ContaCredito contaCredito = (ContaCredito) conta;
            contaCredito.registrarCompra(valor);
        } else {
            throw new IllegalArgumentException("Apenas contas de crédito podem registrar compras");
        }


    }

    @Override
    public void aplicarRendimento() {
        for (int i = 0; i < contas.size(); i++) {
            Conta conta = contas.get(i);

            if (conta instanceof ContaPoupanca) {
                ContaPoupanca poupanca = (ContaPoupanca) conta;
                poupanca.aplicarRendimento();
            }
        }

    }


}
