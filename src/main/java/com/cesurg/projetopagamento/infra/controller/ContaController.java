package com.cesurg.projetopagamento.infra.controller;

import com.cesurg.projetopagamento.core.domain.model.*;
import com.cesurg.projetopagamento.core.interfaces.ContaUseCase;
import com.cesurg.projetopagamento.core.interfaces.UsuarioRepository;
import com.cesurg.projetopagamento.core.interfaces.UsuarioUseCase;
import com.cesurg.projetopagamento.infra.DTO.ContaCorrenteDTO;
import com.cesurg.projetopagamento.infra.DTO.ContaCreditoDTO;
import com.cesurg.projetopagamento.infra.DTO.ContaPoupancaDTO;
import com.cesurg.projetopagamento.infra.DTO.TransferenciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    ContaUseCase contaUseCase;

    @Autowired
    UsuarioUseCase usuarioUseCase;

    @PostMapping("/corrente")
    void criarContaCorrente(@RequestBody ContaCorrenteDTO dto) {

        Usuario usuario = usuarioUseCase.buscarPorId(dto.getUsuarioId());
        ContaCorrente conta = new ContaCorrente();

        conta.setUsuario(usuario);
        conta.setAgencia(dto.getAgencia());
        conta.setSaldo(dto.getSaldo());

        contaUseCase.criarConta(conta);
    }

    @PostMapping("/poupanca")
    void criarContaPoupanca(@RequestBody ContaPoupancaDTO dto){

        Usuario usuario = usuarioUseCase.buscarPorId(dto.getUsuarioId());
        ContaPoupanca conta = new ContaPoupanca();

        conta.setUsuario(usuario);
        conta.setAgencia(dto.getAgencia());
        conta.setSaldo(dto.getSaldo());
        conta.setTaxaRendimento(dto.getTaxaRendimento());

        contaUseCase.criarConta(conta);
    }

    @PostMapping("/credito")
    void criarContaCredito(@RequestBody ContaCreditoDTO dto){

        Usuario usuario = usuarioUseCase.buscarPorId(dto.getUsuarioId());
        ContaCredito conta = new ContaCredito();

        conta.setUsuario(usuario);
        conta.setAgencia(dto.getAgencia());
        conta.setLimite(dto.getLimite());
        conta.setSaldo(0.0);

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
    void transferir(@RequestBody TransferenciaDTO dto){
        contaUseCase.transferir(dto.getIdOrigem(), dto.getIdDestino(), dto.getValor());
    }

    @GetMapping("/{identificador}")
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

    @PostMapping("/{identificador}/compra")
    void registrarCompra(@PathVariable String identificdor, @RequestBody Double valor){
        contaUseCase.registrarCompra(identificdor, valor);
    }

    @PostMapping("/rendimento")
    void aplicarRendimento() {
        contaUseCase.aplicarRendimento();
    }

}
