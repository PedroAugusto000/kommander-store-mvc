package io.github.pedroaugusto00.kommanderstore_mvc.pedido.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.pedroaugusto00.kommanderstore_mvc.pedido.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID>{
	List<Pedido> findByClienteId(UUID clienteId);
}
