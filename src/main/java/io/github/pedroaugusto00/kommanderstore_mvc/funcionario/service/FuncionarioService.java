package io.github.pedroaugusto00.kommanderstore_mvc.funcionario.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.pedroaugusto00.kommanderstore_mvc.funcionario.controller.dto.FuncionarioDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.funcionario.controller.mapper.FuncionarioMapper;
import io.github.pedroaugusto00.kommanderstore_mvc.funcionario.model.Funcionario;
import io.github.pedroaugusto00.kommanderstore_mvc.funcionario.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public FuncionarioDTO criar(FuncionarioDTO dto) {
		Funcionario funcionario = FuncionarioMapper.toEntity(dto);
		Funcionario salvo = funcionarioRepository.save(funcionario);
		return FuncionarioMapper.toDTO(salvo);
	}
	
	public FuncionarioDTO consultarPorId(UUID id) {
		Funcionario consulta = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado!"));
		return FuncionarioMapper.toDTO(consulta);
	}
	
	public FuncionarioDTO atualizarPorId(FuncionarioDTO dto, UUID id) {
		Funcionario funcionarioExiste = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado!"));
		
		funcionarioExiste.setAtivo(dto.getAtivo());
		funcionarioExiste.setDataCriacao(dto.getDataCriacao());
		funcionarioExiste.setEmail(dto.getEmail());
		funcionarioExiste.setId(dto.getId());
		funcionarioExiste.setNome(dto.getNome());
		funcionarioExiste.setSenha(dto.getSenha());
		
		Funcionario atualizado = funcionarioRepository.save(funcionarioExiste);
		return FuncionarioMapper.toDTO(atualizado);
	}
	
	public void deletarPorId(UUID id) {
		funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado!"));
		funcionarioRepository.deleteById(id);
	}
}
