package com.cesurg.projetopagamento.infra.controller;

import com.cesurg.projetopagamento.core.domain.model.Conta;
import com.cesurg.projetopagamento.core.interfaces.ContaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    ContaUseCase contaUseCase;

    @PostMapping
    void criarConta(@RequestBody Conta conta) {
        contaUseCase.criarConta(conta);
    }

    @PutMapping("/{id}")
    void atualizarConta(@PathVariable String id, @RequestBody double saldo) {
        contaUseCase.atualizarSaldo(id, saldo);
    }

    @DeleteMapping("/{id}")
    void deletarContaDTO(@PathVariable String id) {
        contaUseCase.deletarConta(id);
    }

    @GetMapping
    List<Conta> listarConta() {
        return contaUseCase.listarConta();
    }

    @PostMapping("/transferir")
    void transferir(@RequestBody String idOrigem, String idDestino, double valor){
        contaUseCase.transferir(idOrigem,idDestino, valor);
    }

    @GetMapping("/{id}")
    Conta buscarPorIdentificador(@PathVariable String identificador){
        return contaUseCase.buscarPorIdentificador(identificador);
    }

    @PostMapping("/{id}/depositar")
    void depositar(@PathVariable String identificador, @RequestBody Double valor){
        contaUseCase.depositar(identificador, valor);
    }

    @PostMapping("/{id}/sacar")
    void sacar(@PathVariable String identificador, @RequestBody Double valor){
        contaUseCase.sacar(identificador, valor);
    }

}
