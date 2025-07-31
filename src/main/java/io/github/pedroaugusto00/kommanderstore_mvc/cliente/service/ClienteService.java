package io.github.pedroaugusto00.kommanderstore_mvc.cliente.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.pedroaugusto00.kommanderstore_mvc.cliente.controller.dto.ClienteDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.cliente.controller.mapper.ClienteMapper;
import io.github.pedroaugusto00.kommanderstore_mvc.cliente.model.Cliente;
import io.github.pedroaugusto00.kommanderstore_mvc.cliente.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public ClienteDTO criar(ClienteDTO dto) {
		Cliente cliente = ClienteMapper.toEntity(dto);
		Cliente salvo = clienteRepository.save(cliente);
		return ClienteMapper.toDTO(salvo);
	}
	
	public ClienteDTO consultarPorId(UUID id) {
		Cliente consulta = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado!"));
		return ClienteMapper.toDTO(consulta);
	}
	
	public ClienteDTO atualizarPorId(ClienteDTO dto, UUID id) {
		Cliente funcionarioExiste = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado!"));
		
		funcionarioExiste.setAtivo(dto.getAtivo());
		funcionarioExiste.setEmail(dto.getEmail());
		funcionarioExiste.setNome(dto.getNome());
		funcionarioExiste.setSenha(dto.getSenha());
		
		Cliente atualizado = clienteRepository.save(funcionarioExiste);
		return ClienteMapper.toDTO(atualizado);
	}
	
	public void deletarPorId(UUID id) {
		clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado!"));
		clienteRepository.deleteById(id);
	}
	
	
}
