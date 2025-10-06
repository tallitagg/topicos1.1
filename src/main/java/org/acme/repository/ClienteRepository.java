package org.acme.repository;

import org.acme.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public List<Cliente> findByNome(String nome) {
        return find("UPPER(usuario.nome)", "%" + nome + "%").firstResult();
    }

    public List<Cliente> findByEmail(String email) {
        return find("UPPER(usuario.email)", "%" + email + "%").firstResult();
    }

    public List<Cliente> findByCpf(String cpf) {
        return find("UPPER(usuario.cpf)", "%" + cpf + "%").firstResult();
    }

}
