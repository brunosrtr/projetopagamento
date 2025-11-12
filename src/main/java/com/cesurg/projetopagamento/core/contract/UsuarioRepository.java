package com.cesurg.projetopagamento.core.contract;

import com.cesurg.projetopagamento.core.domain.entity.Usuario;

public interface UsuarioRepository {
    void criarUsuario(Usuario usuario);
}
