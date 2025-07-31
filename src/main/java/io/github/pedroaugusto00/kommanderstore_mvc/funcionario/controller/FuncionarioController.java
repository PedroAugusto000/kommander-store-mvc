package io.github.pedroaugusto00.kommanderstore_mvc.funcionario.controller;

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

import io.github.pedroaugusto00.kommanderstore_mvc.funcionario.controller.dto.FuncionarioDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.funcionario.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@PostMapping
	public ResponseEntity<FuncionarioDTO> criar(@RequestBody FuncionarioDTO dto) {
		return ResponseEntity.ok(funcionarioService.criar(dto));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<FuncionarioDTO> consultarPorId(@PathVariable UUID id) {
		return ResponseEntity.ok(funcionarioService.consultarPorId(id));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<FuncionarioDTO> atualizarPorId(@PathVariable UUID id, @RequestBody FuncionarioDTO dto) {
		return ResponseEntity.ok(funcionarioService.atualizarPorId(dto, id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<FuncionarioDTO> deletarPorId(@PathVariable UUID id) {
		funcionarioService.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}
}
