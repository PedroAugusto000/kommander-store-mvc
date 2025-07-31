package io.github.pedroaugusto00.kommanderstore_mvc.cliente.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.pedroaugusto00.kommanderstore_mvc.cliente.controller.dto.ClienteDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.cliente.service.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> criar(@RequestBody ClienteDTO dto) {
		return ResponseEntity.ok(clienteService.criar(dto));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ClienteDTO> consultarPorId(@PathVariable UUID id) {
		return ResponseEntity.ok(clienteService.consultarPorId(id));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ClienteDTO> atualizarPorId(@PathVariable UUID id, @RequestBody ClienteDTO dto) {
		return ResponseEntity.ok(clienteService.atualizarPorId(dto, id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ClienteDTO> deletarPorId(@PathVariable UUID id) {
		clienteService.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}
}
