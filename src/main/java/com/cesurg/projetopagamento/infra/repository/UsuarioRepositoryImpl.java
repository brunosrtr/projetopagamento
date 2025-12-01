package com.cesurg.projetopagamento.infra.repository;

import com.cesurg.projetopagamento.core.domain.model.Usuario;
import com.cesurg.projetopagamento.core.interfaces.UsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    List<Usuario> usuarios = new ArrayList<>();
    Long contador = 1L;

    @Override
    public void criarUsuario(Usuario usuario) {
        usuario.setId(contador);
        usuarios.add(usuario);
        contador++;
    }

    @Override
    public void atualizarUsuario(Long id, Usuario usuario) {
        boolean usuarioEncontrado = false;
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (Objects.equals(u.getId(), id)) {
                usuarioEncontrado = true;
                u.setNome(usuario.getNome());
                u.setCpf(usuario.getCpf());
            }
        }
        if (usuarioEncontrado==false) {
            throw new IllegalArgumentException("Usuário não encontrado: " + id);
        }
    }

    @Override
    public void deletarUsuario(Long id) {
        boolean usuarioEncontrado = false;
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (Objects.equals(u.getId(), id)) {
                usuarioEncontrado = true;
                usuarios.remove(i);
            }
        }
        if (usuarioEncontrado==false) {
            throw new IllegalArgumentException("Usuário não encontrado: " + id);
        }    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarios;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        for (Usuario u : usuarios){
            if(Objects.equals(u.getId(), id)) {
                return u;
            }
        }
        return null;
    }


}
