package io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.dto;

import java.util.UUID;

public class CategoriaDTO {

	private UUID id;
	private String nome;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
