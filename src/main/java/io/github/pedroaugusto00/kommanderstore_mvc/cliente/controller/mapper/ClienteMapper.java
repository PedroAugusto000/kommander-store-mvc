package io.github.pedroaugusto00.kommanderstore_mvc.cliente.controller.mapper;

import io.github.pedroaugusto00.kommanderstore_mvc.cliente.controller.dto.ClienteDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.cliente.model.Cliente;

public class ClienteMapper {

	public static Cliente toEntity(ClienteDTO dto) {
		if(dto == null) return null;
		
		Cliente cliente = new Cliente();
		
		cliente.setAtivo(dto.getAtivo());
		cliente.setDataCriacao(dto.getDataCriacao());
		cliente.setEmail(dto.getEmail());
		cliente.setEndereco(dto.getEndereco());
		cliente.setId(dto.getId());
		cliente.setNome(dto.getNome());
		cliente.setSenha(dto.getSenha());
		cliente.setTelefone(dto.getTelefone());
		
		return cliente;
	}
	
	public static ClienteDTO toDTO(Cliente cliente) {
		if(cliente == null) return null;
		
		ClienteDTO dto = new ClienteDTO();
		
		dto.setAtivo(cliente.getAtivo());
		dto.setDataCriacao(cliente.getDataCriacao());
		dto.setEmail(cliente.getEmail());
		dto.setEndereco(cliente.getEndereco());
		dto.setId(cliente.getId());
		dto.setNome(cliente.getNome());
		dto.setSenha(cliente.getSenha());
		dto.setTelefone(cliente.getTelefone());
		
		return dto;
	}
}
