package io.pedroaugusto00.kommanderstore.controller.mapper;

import io.pedroaugusto00.kommanderstore.controller.dto.FuncionarioDTO;
import io.pedroaugusto00.kommanderstore.model.Funcionario;

public class FuncionarioMapper {

	public static Funcionario toEntity(FuncionarioDTO dto) {
		if(dto == null) return null;
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setId(dto.getId());
		funcionario.setNome(dto.getNome());
		funcionario.setEmail(dto.getEmail());
		funcionario.setSenha(dto.getSenha());
		funcionario.setRole(dto.getRole());
		funcionario.setAtivo(dto.getAtivo());
		funcionario.setDataCriacao(dto.getDataCriacao());

		return funcionario;
	}
	
	public static FuncionarioDTO toDTO(Funcionario funcionario) {
		if(funcionario == null) return null;
		
		FuncionarioDTO dto = new FuncionarioDTO();
		dto.setId(funcionario.getId());
		dto.setNome(funcionario.getNome());
		dto.setEmail(funcionario.getEmail());
		dto.setSenha(funcionario.getSenha());
		dto.setRole(funcionario.getRole());
		dto.setAtivo(funcionario.getAtivo());
		dto.setDataCriacao(funcionario.getDataCriacao());
		
		return dto;
	}
}
