package io.github.pedroaugusto00.kommanderstore_mvc.pedido.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import io.github.pedroaugusto00.kommanderstore_mvc.pedido.model.enums.Status;

public class PedidoDTO {

	private UUID id;
	private Status status;
	private LocalDateTime dataPedido;
	private LocalDateTime dataEntregaPrevista;
	private LocalDateTime dataEntrega;
	private BigDecimal valorTotal;
	private UUID clienteId;

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

	public UUID getClienteId() {
		return clienteId;
	}

	public void setClienteId(UUID clienteId) {
		this.clienteId = clienteId;
	}
}
