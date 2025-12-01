package com.cesurg.projetopagamento.core.domain.usecase;

import com.cesurg.projetopagamento.core.domain.model.Usuario;
import com.cesurg.projetopagamento.core.interfaces.UsuarioRepository;
import com.cesurg.projetopagamento.core.interfaces.UsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void criarUsuario(Usuario usuario) {
        boolean cpfExiste = false;
        for (int i = 0; i < listarUsuario().size(); i++) {
            Usuario u = listarUsuario().get(i);
            if (usuario.getCpf().equals(u.getCpf())) {
                cpfExiste = true;
            }
        }

        if (cpfExiste) {
            throw new IllegalArgumentException("Este identificador já existe");
        } else {
            usuarioRepository.criarUsuario(usuario);
        }
    }

    @Override
    public void atualizarUsuario(Integer id, Usuario usuario) {
        boolean cpfExiste = false;
        for (int i = 0; i < listarUsuario().size(); i++) {
            Usuario u = listarUsuario().get(i);
            if (usuario.getCpf().equals(u.getCpf())) {
                cpfExiste = true;
            }
        }

        if (cpfExiste==false) {
            usuarioRepository.atualizarUsuario(id, usuario);
        }
    }

    @Override
    public void deletarUsuario(Integer id) {
        usuarioRepository.deletarUsuario(id);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepository.listarUsuario();
    }

    @Override
    public Usuario buscarPorId(Long id) { return usuarioRepository.buscarPorId(id); }
}
