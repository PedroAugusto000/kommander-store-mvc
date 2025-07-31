package io.github.pedroaugusto00.kommanderstore_mvc.produto.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.pedroaugusto00.kommanderstore_mvc.produto.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID>{
	List<Produto> findAllByAtivoTrue();
}
