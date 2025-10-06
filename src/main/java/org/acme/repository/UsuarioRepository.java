package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.model.Usuario;

import java.util.List;

public class UsuarioRepository implements PanacheRepository<Usuario> {

    public List<Usuario> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%" + nome + "%").firstResult();
    }

    public List<Usuario> findByEmail(String email) {
        return find("UPPER(email) LIKE ?1", "%" + email + "%").firstResult();
    }

    public List<Usuario> findByCpf(String cpf) {
        return find("UPPER(cpf) LIKE ?1", "%" + cpf + "%").firstResult();
    }
}
