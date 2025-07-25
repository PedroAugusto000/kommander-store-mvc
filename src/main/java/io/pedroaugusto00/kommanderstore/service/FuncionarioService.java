package io.pedroaugusto00.kommanderstore.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.pedroaugusto00.kommanderstore.controller.dto.FuncionarioDTO;
import io.pedroaugusto00.kommanderstore.controller.mapper.FuncionarioMapper;
import io.pedroaugusto00.kommanderstore.model.Funcionario;
import io.pedroaugusto00.kommanderstore.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public FuncionarioDTO criar(FuncionarioDTO dto) {
		Funcionario funcionario = FuncionarioMapper.toEntity(dto);
		funcionario.setDataCriacao(LocalDateTime.now());
		Funcionario salvo = funcionarioRepository.save(funcionario);
		return FuncionarioMapper.toDTO(salvo);
	}
	
	public FuncionarioDTO consultar(UUID id) {
		Funcionario consulta = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado!"));
		return FuncionarioMapper.toDTO(consulta);
	}
	
	public FuncionarioDTO atualizar(FuncionarioDTO dto, UUID id) {
		Funcionario funcionarioExiste = funcionarioRepository.findById(id)
			    .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

			funcionarioExiste.setNome(dto.getNome());
			funcionarioExiste.setEmail(dto.getEmail());
			funcionarioExiste.setSenha(dto.getSenha());
			funcionarioExiste.setRole(dto.getRole());
			funcionarioExiste.setAtivo(dto.getAtivo());
			funcionarioExiste.setDataCriacao(dto.getDataCriacao());

			Funcionario atualizado = funcionarioRepository.save(funcionarioExiste);
			return FuncionarioMapper.toDTO(atualizado);
	}
	
	public void deletarPorId(UUID id) {
		Funcionario consulta = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado!"));
		funcionarioRepository.delete(consulta);
	}
}
