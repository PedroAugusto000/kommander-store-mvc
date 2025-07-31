package io.github.pedroaugusto00.kommanderstore_mvc.funcionario.controller.mapper;

import io.github.pedroaugusto00.kommanderstore_mvc.funcionario.controller.dto.FuncionarioDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.funcionario.model.Funcionario;

public class FuncionarioMapper {

	public static Funcionario toEntity(FuncionarioDTO dto) {
		if(dto == null) return null;
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setAtivo(dto.getAtivo());
		funcionario.setDataCriacao(dto.getDataCriacao());
		funcionario.setEmail(dto.getEmail());
		funcionario.setId(dto.getId());
		funcionario.setNome(dto.getNome());
		funcionario.setSenha(dto.getSenha());
		
		return funcionario;
	}
	
	public static FuncionarioDTO toDTO(Funcionario funcionario) {
		if(funcionario == null) return null;
		
		FuncionarioDTO dto = new FuncionarioDTO();
		
		dto.setAtivo(funcionario.getAtivo());
		dto.setDataCriacao(funcionario.getDataCriacao());
		dto.setEmail(funcionario.getEmail());
		dto.setId(funcionario.getId());
		dto.setNome(funcionario.getNome());
		dto.setSenha(funcionario.getSenha());
		
		return dto;
	}
}
