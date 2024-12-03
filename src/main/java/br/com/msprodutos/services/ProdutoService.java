package br.com.msprodutos.services;

import br.com.msprodutos.model.Produtos;

import java.util.List;

public interface ProdutoService {
    Produtos addProduto(Produtos produto);
    Produtos updateProduto(Produtos produto, Long id);
    void deleteProduto(Long id);
    Produtos getProduto(Long id);
    List<Produtos> getProdutos();
    void removerEstoque(Long id, Integer quantidade);
}
