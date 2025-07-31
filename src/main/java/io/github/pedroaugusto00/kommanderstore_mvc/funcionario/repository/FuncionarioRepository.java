package io.github.pedroaugusto00.kommanderstore_mvc.funcionario.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.pedroaugusto00.kommanderstore_mvc.funcionario.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID>{

}
