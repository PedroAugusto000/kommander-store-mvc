package io.pedroaugusto00.kommanderstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.pedroaugusto00.kommanderstore.model.enums.Status;
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
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@CreatedDate
	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;
	
	@Column(name = "entrega_prevista")
	private LocalDate dataEntregaPrevista;
	
	@Column(name = "data_entrega")
	private LocalDateTime dataEntrega;
	
	@Column(name = "preco_total")
	private BigDecimal precoTotal;
    
	@ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
    @ManyToOne
    @JoinColumn(name = "funcionario_responsavel_id", nullable = false)
    private Funcionario funcionarioResponsavel;

	public Pedido() {}
	
	public Pedido(UUID id, Status status, LocalDateTime dataPedido, LocalDate dataEntregaPrevista,
			LocalDateTime dataEntrega, BigDecimal precoTotal, Cliente cliente, Funcionario funcionarioResponsavel) {
		this.id = id;
		this.status = status;
		this.dataPedido = dataPedido;
		this.dataEntregaPrevista = dataEntregaPrevista;
		this.dataEntrega = dataEntrega;
		this.precoTotal = precoTotal;
		this.cliente = cliente;
		this.funcionarioResponsavel = funcionarioResponsavel;
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
