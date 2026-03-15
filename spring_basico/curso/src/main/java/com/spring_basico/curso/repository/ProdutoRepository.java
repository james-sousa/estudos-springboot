package com.spring_basico.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_basico.curso.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
