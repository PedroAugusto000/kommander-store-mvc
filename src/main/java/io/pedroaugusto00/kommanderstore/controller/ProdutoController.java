package io.pedroaugusto00.kommanderstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
