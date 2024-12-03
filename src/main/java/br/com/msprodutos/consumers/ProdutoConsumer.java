package br.com.msprodutos.consumers;

import br.com.msprodutos.model.ProdutoRequest;
import br.com.msprodutos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;



@Component
public class ProdutoConsumer {

    private final ProdutoService produtoService;

    public ProdutoConsumer(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Bean(name = "remova-estoque")
    Consumer<ProdutoRequest> consumer(){
        return pR -> this.produtoService.removerEstoque(pR.getId(), pR.getQuantidade());
    }
}
