package com.cesurg.projetopagamento.infra.controller;

import com.cesurg.projetopagamento.core.domain.model.Usuario;
import com.cesurg.projetopagamento.core.interfaces.UsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioUseCase usuarioUseCase;

    @PostMapping
    void criarUsuario(@RequestBody Usuario usuario) {
        usuarioUseCase.criarUsuario(usuario);
    }

    @PutMapping("/{id}")
    void atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuarioUseCase.atualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    void deletarUsuario(@PathVariable Long id) {
        usuarioUseCase.deletarUsuario(id);
    }

    @GetMapping
    List<Usuario> listarUsuario() {
        return usuarioUseCase.listarUsuario();
    }

    @GetMapping("/{id}")
    Usuario buscarPorId(@PathVariable Long id){ return  usuarioUseCase.buscarPorId(id); }

}
