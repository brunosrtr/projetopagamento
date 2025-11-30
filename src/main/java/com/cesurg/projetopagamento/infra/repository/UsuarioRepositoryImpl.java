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
    int contador = 1;

    @Override
    public void criarUsuario(Usuario usuario) {
        usuario.setId(contador);
        usuarios.add(usuario);
        contador++;
    }

    @Override
    public void atualizarUsuario(Integer id, Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (Objects.equals(u.getId(), id)) {
                usuario.setId(u.getId());
                usuarios.set(i, usuario);
            }
        }
        throw new IllegalArgumentException("Usuário não encontrado: " + id);
    }

    @Override
    public void deletarUsuario(Integer id) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (Objects.equals(u.getId(), id)) {
                usuarios.remove(i);
            }
        }
        throw new IllegalArgumentException("Usuário não encontrado: " + id);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarios;
    }

    @Override
    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios){
            if(Objects.equals(u.getId(), id));
            return u;
        }
        return null;
    }


}
