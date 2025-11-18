package com.cesurg.projetopagamento.infra.controller;

import com.cesurg.projetopagamento.core.domain.model.Banco;
import com.cesurg.projetopagamento.core.interfaces.BancoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bancos")
public class BancoController {
    @Autowired
    BancoUseCase bancoUseCase;

    @PostMapping
    void criarBanco(@RequestBody Banco banco) {
        bancoUseCase.criarBanco(banco);
    }

    @PutMapping("/{agencia}")
    void atualizarBanco(@PathVariable Integer agencia, @RequestBody Banco banco) {
        bancoUseCase.atualizarBanco(agencia, banco);
    }

    @DeleteMapping("/{agencia}")
    void deletarBanco(@PathVariable Integer agencia) {
        bancoUseCase.deletarBanco(agencia);
    }

    @GetMapping
    List<Banco> listarBanco() {
        return bancoUseCase.listarBanco();
    }
}
