// Esta classe é responsável por implementar a lógica de negócios relacionada aos produtos. Ela utiliza o repositório ProdutoRepository para acessar os dados dos produtos no banco de dados e fornecer métodos para listar, buscar, salvar, deletar e atualizar produtos. Cada método lida com as operações correspondentes e lança exceções personalizadas quando necessário, como quando um produto não é encontrado.

package com.spring_basico.curso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_basico.curso.model.Produto;
import com.spring_basico.curso.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto com id " + id + " não encontrado"));
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto com id " + id + " não encontrado");
        }
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoAtualizado.getNome());
                    produto.setPreco(produtoAtualizado.getPreco());
                    return produtoRepository.save(produto);
                })
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
