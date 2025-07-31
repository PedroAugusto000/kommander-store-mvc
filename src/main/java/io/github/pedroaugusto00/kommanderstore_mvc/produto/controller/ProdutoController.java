package io.github.pedroaugusto00.kommanderstore_mvc.produto.controller;

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

import io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.dto.ProdutoDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> criar(@RequestBody ProdutoDTO dto) {
		return ResponseEntity.ok(produtoService.criar(dto));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProdutoDTO> consultarPorId(@PathVariable UUID id) {
		return ResponseEntity.ok(produtoService.consultarPorId(id));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ProdutoDTO> consultarPorId(@RequestBody ProdutoDTO dto, @PathVariable UUID id) {
		return ResponseEntity.ok(produtoService.atualizarPorId(dto, id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ProdutoDTO> deletarPorId(@PathVariable UUID id) {
		produtoService.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}
}
