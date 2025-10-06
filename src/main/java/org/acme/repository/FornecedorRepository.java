package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.model.Fornecedor;

import java.util.List;

public class FornecedorRepository implements PanacheRepository<Fornecedor> {

    public List<Fornecedor> findByNome(String nome) {
        return find("UPPER(nome)", "%" + nome + "%").firstResult();
    }

    public List<Fornecedor> findByCnpj(String cnpj) {
        return find("UPPER(cnpj)", "%" + cnpj + "%").firstResult();
    }

    public List<Fornecedor> findByEmail(String email) {
        return find("UPPER(email)", "%" + email + "%").firstResult();
    }

}
