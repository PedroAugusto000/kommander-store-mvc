package io.pedroaugusto00.kommanderstore.controller;

import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pedroaugusto00.kommanderstore.controller.dto.FuncionarioDTO;
import io.pedroaugusto00.kommanderstore.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
@PreAuthorize("hasRole('GERENTE')")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@PostMapping
	public ResponseEntity<FuncionarioDTO> criar(@RequestBody FuncionarioDTO dto) {
		FuncionarioDTO salvo = funcionarioService.criar(dto);
		return new ResponseEntity<>(salvo, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<FuncionarioDTO> consultar(@PathVariable UUID id) {
	    return ResponseEntity.ok(funcionarioService.consultar(id));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<FuncionarioDTO> atualizar(@RequestBody FuncionarioDTO dto, @PathVariable UUID id) {
		return ResponseEntity.ok(funcionarioService.atualizar(dto, id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable UUID id) {
		funcionarioService.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}
}
