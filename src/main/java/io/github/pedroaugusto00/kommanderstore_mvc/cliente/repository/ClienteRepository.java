package io.github.pedroaugusto00.kommanderstore_mvc.cliente.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.pedroaugusto00.kommanderstore_mvc.cliente.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID>{

}
