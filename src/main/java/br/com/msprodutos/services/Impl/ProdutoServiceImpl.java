package br.com.msprodutos.services.Impl;

import br.com.msprodutos.model.Produtos;
import br.com.msprodutos.repository.ProdutoRepository;
import br.com.msprodutos.services.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produtos addProduto(Produtos produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produtos updateProduto(Produtos produto, Long id) {
        Produtos produtoExistente = getProduto(id);
        if(produtoExistente != null) {
            BeanUtils.copyProperties(produto, produtoExistente, "id");
            return produtoRepository.save(produtoExistente);
        }else{
            throw new RuntimeException("Produto não encontrado");
        }
    }

    @Override
    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public Produtos getProduto(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Produtos> getProdutos() {
        return produtoRepository.findAll();
    }

    public void removerEstoque(Long id, Integer quantidade) {
        this.getProdutos()
            .stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElseThrow().removerEstoque(quantidade);

        Produtos produto = getProduto(id);
        produto.setQuantidade(produto.getQuantidade() - quantidade);
        produtoRepository.save(produto);
    }
}
