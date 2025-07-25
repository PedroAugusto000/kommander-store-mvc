package io.pedroaugusto00.kommanderstore.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pedroaugusto00.kommanderstore.controller.dto.ProdutoDTO;
import io.pedroaugusto00.kommanderstore.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO dto) {
		ProdutoDTO salvo = produtoService.salvar(dto);
		return new ResponseEntity<>(salvo, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProdutoDTO> consultarPorId(@PathVariable UUID id) {
		return ResponseEntity.ok(produtoService.consultar(id));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ProdutoDTO> atualizarPorId(@PathVariable UUID id, @RequestBody ProdutoDTO dto){
		ProdutoDTO atualizado = produtoService.atualizar(id, dto);
		return ResponseEntity.ok(atualizado);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarPorId(@PathVariable UUID id) {
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
