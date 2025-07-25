package io.pedroaugusto00.kommanderstore.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.pedroaugusto00.kommanderstore.controller.dto.ProdutoDTO;
import io.pedroaugusto00.kommanderstore.controller.mapper.ProdutoMapper;
import io.pedroaugusto00.kommanderstore.model.Produto;
import io.pedroaugusto00.kommanderstore.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public ProdutoDTO salvar(ProdutoDTO dto) {
		Produto produto = ProdutoMapper.toEntity(dto);
		produto.setDataCriacao(LocalDateTime.now());
		Produto salvo = produtoRepository.save(produto);
		return ProdutoMapper.toDTO(salvo);
	}
	
	public ProdutoDTO consultar(UUID id) {
	    Produto produto = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));

	    return ProdutoMapper.toDTO(produto);
	}
	
	public ProdutoDTO atualizar(UUID id, ProdutoDTO dto) {
		Produto produtoExiste = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
		
		produtoExiste.setNome(dto.getNome());
		produtoExiste.setDescricao(dto.getDescricao());
		produtoExiste.setPreco(dto.getPreco());
		produtoExiste.setQuantidadeEstoque(dto.getQuantidadeEstoque());
		produtoExiste.setDataCriacao(dto.getDataCriacao());
		produtoExiste.setAtivo(dto.getAtivo());
		
		Produto atualizado = produtoRepository.save(produtoExiste);
		return ProdutoMapper.toDTO(atualizado);
	}
	
	public void deletar(UUID id) {
		Produto produto = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
		produtoRepository.deleteById(id);
	}
}
