package io.pedroaugusto00.kommanderstore.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pedroaugusto00.kommanderstore.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, UUID>{

}
