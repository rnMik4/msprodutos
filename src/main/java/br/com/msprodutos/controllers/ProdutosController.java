package br.com.msprodutos.controllers;

import br.com.msprodutos.model.Produtos;
import br.com.msprodutos.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutosController {
    @Autowired
    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produtos> addProduto(@RequestBody Produtos produto) {
        return new ResponseEntity<>(produtoService.addProduto(produto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Produtos>> getAllProdutos() {
        return ResponseEntity.ok().body(produtoService.getProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> getProdutoById(@PathVariable Long id) {
        return ResponseEntity.ok().body(produtoService.getProduto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produtos> updateProduto(@PathVariable Long id, @RequestBody Produtos produto) {
        return new ResponseEntity<>(produtoService.updateProduto(produto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
        return new ResponseEntity<>("Produto removido com sucesso", HttpStatus.OK);
    }

}
