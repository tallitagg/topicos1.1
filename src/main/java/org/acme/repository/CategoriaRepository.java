package org.acme.repository;

import org.acme.model.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepository<Categoria> {

    public List<Categoria> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").firstResult();
    }

}
