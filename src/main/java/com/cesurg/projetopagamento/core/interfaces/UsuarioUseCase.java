package com.cesurg.projetopagamento.core.interfaces;

import com.cesurg.projetopagamento.core.domain.model.Usuario;

import java.util.List;

public interface UsuarioUseCase {
    void criarUsuario (Usuario usuario);
    void atualizarUsuario (Integer id, Usuario usuario);
    void deletarUsuario (Integer id);
    List<Usuario> listarUsuario ();

    Usuario buscarPorId(Long id);
}
