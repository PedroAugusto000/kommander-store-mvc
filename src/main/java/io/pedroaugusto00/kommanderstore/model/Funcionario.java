package io.pedroaugusto00.kommanderstore.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Funcionario {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 150, nullable = false, unique = true)
	private String email;
	
	@Column(name = "senha", length = 100, nullable = false)
	private String senha;
	
	@Column(name = "data_criacao", nullable = true)
	private LocalDateTime dataCriacao;
	
	@Column(name = "ativo", nullable = false)
	private Boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;
}
