package br.com.msprodutos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Produtos")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    @Column(name = "preco",  nullable = false)
    private float preco;

    @Column(name = "tamanho", length = 10, nullable = false)
    private String tamanho;

    @Column(name = "cor", length = 50, nullable = false)
    private String cor;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public void removerEstoque(Integer quantidade) {
        if(quantidade <= 0) {
            throw new UnsupportedOperationException("Quantidade deve ser maior que zero");
        } else if (this.quantidade - quantidade < 0) {
            throw new UnsupportedOperationException("Estoque insuficiente");
        } else{
            this.quantidade -= quantidade;
        }
    }
}