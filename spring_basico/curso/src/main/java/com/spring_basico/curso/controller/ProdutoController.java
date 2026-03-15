package com.spring_basico.curso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_basico.curso.model.Produto;
import com.spring_basico.curso.service.ProdutoService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

// Faz as requisições para o caminho "api/produtos" e retorna os dados no formato JSON

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {
    private final ProdutoService produto;

    public ProdutoController(ProdutoService produto) {
        this.produto = produto;
    }

    @GetMapping
    public List<Produto> getProdutos() {
        return produto.listarProdutos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {
        Produto produtoEncontrado = produto.buscarPorId(id);
        return ResponseEntity.ok(produtoEncontrado);
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return this.produto.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produto.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        return this.produto.atualizarProduto(id, produtoAtualizado);
    }


}

