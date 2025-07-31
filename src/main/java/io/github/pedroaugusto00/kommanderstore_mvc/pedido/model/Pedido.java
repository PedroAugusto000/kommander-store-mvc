package io.github.pedroaugusto00.kommanderstore_mvc.pedido.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.github.pedroaugusto00.kommanderstore_mvc.cliente.model.Cliente;
import io.github.pedroaugusto00.kommanderstore_mvc.pedido.model.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(length = 50)
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;

	@Column(name = "data_entrega_prevista")
	private LocalDateTime dataEntregaPrevista;

	@Column(name = "data_entrega")
	private LocalDateTime dataEntrega;

	@Column(name = "valor_total", precision = 18, scale = 2)
	private BigDecimal valorTotal;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	public Pedido() {}

	public Pedido(UUID id, Status status, LocalDateTime dataPedido, LocalDateTime dataEntregaPrevista,
				  LocalDateTime dataEntrega, BigDecimal valorTotal, Cliente cliente) {
		this.id = id;
		this.status = status;
		this.dataPedido = dataPedido;
		this.dataEntregaPrevista = dataEntregaPrevista;
		this.dataEntrega = dataEntrega;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDateTime getDataEntregaPrevista() {
		return dataEntregaPrevista;
	}

	public void setDataEntregaPrevista(LocalDateTime dataEntregaPrevista) {
		this.dataEntregaPrevista = dataEntregaPrevista;
	}

	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
