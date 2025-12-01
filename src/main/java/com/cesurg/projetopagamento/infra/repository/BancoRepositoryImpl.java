package com.cesurg.projetopagamento.infra.repository;

import com.cesurg.projetopagamento.core.domain.model.Banco;
import com.cesurg.projetopagamento.core.interfaces.BancoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BancoRepositoryImpl implements BancoRepository {
    List<Banco> bancos = new ArrayList<>();

    @Override
    public void criarBanco(Banco banco) {
       bancos.add(banco);
    }

    @Override
    public void atualizarBanco(Integer agencia, Banco banco) {
        for (int i = 0; i < bancos .size(); i++) {
            Banco b = bancos.get(i);
            if (Objects.equals(b.getAgencia(), agencia)) {
                banco.setAgencia(b.getAgencia());
                bancos.set(i, banco);
            }
        }
    }

    @Override
    public void deletarBanco(Integer agencia) {
        for (int i = 0; i < bancos .size(); i++) {
            Banco b = bancos.get(i);
            if (Objects.equals(b.getAgencia(), agencia)) {
                bancos.remove(i);
            }
        }
    }

    @Override
    public List<Banco> listarBanco() {
        return bancos;
    }
}
