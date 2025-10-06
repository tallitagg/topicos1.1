package org.acme.repository;

import org.acme.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {

    public List<Produto> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%" + nome + "%").firstResult();
    }

    public Produto findbyFornecedorProduto(String nomeFornecedor) {
        return find("UPPER(fornecedor.nome) LIKE ?1","%" + nomeFornecedor + "%").firstResult();
    }

    public List<Produto> findBynomeCategoria(String nomeCategoria) {
        return find("UPPER(categoria.nome) LIKE ?1","%" + nomeCategoria + "%").firstResult();
    }

    public List<Produto> findByPrecoBetween(double min, double max) {
        return find("""
                SELECT DISTINCT p
                FROM Produto p
                JOIN p.variacoes v
                WHERE v.preco BETWEEN ?1 AND ?2
                ORDER BY p.nome
                """, min, max).firstResult();
    }
}
