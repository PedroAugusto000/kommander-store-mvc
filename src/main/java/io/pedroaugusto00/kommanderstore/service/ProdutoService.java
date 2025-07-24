package io.pedroaugusto00.kommanderstore.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import io.pedroaugusto00.kommanderstore.controller.dto.ProdutoDTO;
import io.pedroaugusto00.kommanderstore.controller.mapper.ProdutoMapper;
import io.pedroaugusto00.kommanderstore.model.Produto;
import io.pedroaugusto00.kommanderstore.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public ProdutoDTO salvar(ProdutoDTO dto) {
		Produto produto = ProdutoMapper.toEntity(dto);
		Produto salvo = produtoRepository.save(produto);
		produto.setDataCriacao(LocalDateTime.now());
		return ProdutoMapper.toDTO(salvo);
	}
}
