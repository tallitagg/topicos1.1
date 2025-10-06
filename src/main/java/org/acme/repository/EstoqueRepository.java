package org.acme.repository;

import org.acme.model.Estoque;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EstoqueRepository implements PanacheRepository<Estoque> {

    public List<Estoque> findByLocal(String local) {
        return find("UPPER(local) LIKE ?1", "%" + local + "%").firstResult();
    }

}
