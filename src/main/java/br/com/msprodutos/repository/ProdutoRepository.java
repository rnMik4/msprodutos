package br.com.msprodutos.repository;

import br.com.msprodutos.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {

}
