package io.pedroaugusto00.kommanderstore.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.pedroaugusto00.kommanderstore.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID>{

}
