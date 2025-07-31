package io.github.pedroaugusto00.kommanderstore_mvc.produto.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.dto.ProdutoDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.mapper.ProdutoMapper;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.model.Produto;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public ProdutoDTO criar(ProdutoDTO dto) {
		Produto produto = ProdutoMapper.toEntity(dto);
		Produto salvo = produtoRepository.save(produto);
		return ProdutoMapper.toDTO(salvo);
	}
	
	public ProdutoDTO consultarPorId(UUID id) {
		Produto consulta = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
		return ProdutoMapper.toDTO(consulta);
		
	}
	
	public ProdutoDTO atualizarPorId(ProdutoDTO dto, UUID id) {
		Produto produtoExiste = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
		
		produtoExiste.setAtivo(dto.getAtivo());
		produtoExiste.setCategoria(dto.getCategoria());
		produtoExiste.setDataCriacao(dto.getDataCriacao());
		produtoExiste.setDescricao(dto.getDescricao());
		produtoExiste.setId(dto.getId());
		produtoExiste.setNome(dto.getNome());
		produtoExiste.setPreco(dto.getPreco());
		produtoExiste.setQuantidadeEstoque(dto.getQuantidadeEstoque());
		
		Produto atualizado = produtoRepository.save(produtoExiste);
		return ProdutoMapper.toDTO(atualizado);
	}
	
	public void deletarPorId(UUID id) {
		produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
		produtoRepository.deleteById(id);
	}
}
