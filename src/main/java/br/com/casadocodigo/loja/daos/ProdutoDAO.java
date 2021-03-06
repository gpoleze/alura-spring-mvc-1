package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository     // This annotation defines that Srping will take care of this class
@Transactional  // Defines that this class is Transactional and will be handled by the TransactionManager
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Produto produto) {
        manager.persist(produto);
    }

    public List<Produto> list() {
        return manager
                .createQuery("select p from Produto p", Produto.class)
                .getResultList();
    }

    public Produto find(int id) {
        String query = "SELECT DISTINCT (p) FROM Produto p JOIN fetch p.precos preco WHERE p.id = :id";
        return manager.createQuery(query, Produto.class).setParameter("id", id).getSingleResult();
    }
}
