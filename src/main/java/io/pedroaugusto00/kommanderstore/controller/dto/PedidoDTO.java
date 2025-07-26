package io.pedroaugusto00.kommanderstore.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import io.pedroaugusto00.kommanderstore.model.Cliente;
import io.pedroaugusto00.kommanderstore.model.Funcionario;
import io.pedroaugusto00.kommanderstore.model.enums.Status;

public class PedidoDTO {

	private UUID id;
	private Status status;
	private LocalDateTime dataPedido;
	private LocalDate dataEntregaPrevista;
	private LocalDateTime dataEntrega;
	private BigDecimal precoTotal;
	private Cliente cliente;
	private Funcionario funcionarioResponsavel;
	
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
	public LocalDate getDataEntregaPrevista() {
		return dataEntregaPrevista;
	}
	public void setDataEntregaPrevista(LocalDate dataEntregaPrevista) {
		this.dataEntregaPrevista = dataEntregaPrevista;
	}
	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Funcionario getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}
	public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
		this.funcionarioResponsavel = funcionarioResponsavel;
	}
}
