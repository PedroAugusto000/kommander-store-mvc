package io.github.pedroaugusto00.kommanderstore_mvc.produto.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.pedroaugusto00.kommanderstore_mvc.produto.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID>{

}
