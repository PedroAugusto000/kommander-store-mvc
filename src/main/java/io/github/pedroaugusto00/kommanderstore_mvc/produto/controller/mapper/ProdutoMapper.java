package io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.mapper;

import io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.dto.ProdutoDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.model.Produto;

public class ProdutoMapper {

	public static Produto toEntity(ProdutoDTO dto) {
		if(dto == null) return null;
		
		Produto produto = new Produto();
		
		produto.setAtivo(dto.getAtivo());
		produto.setCategoria(dto.getCategoria());
		produto.setDataCriacao(dto.getDataCriacao());
		produto.setDescricao(dto.getDescricao());
		produto.setId(dto.getId());
		produto.setNome(dto.getNome());
		produto.setPreco(dto.getPreco());
		produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
		
		return produto;
	}
	
	public static ProdutoDTO toDTO(Produto produto) {
		if(produto ==null) return null;
		
		ProdutoDTO dto = new ProdutoDTO();
		
		dto.setAtivo(produto.getAtivo());
		dto.setCategoria(produto.getCategoria());
		dto.setDataCriacao(produto.getDataCriacao());
		dto.setDescricao(produto.getDescricao());
		dto.setId(produto.getId());
		dto.setNome(produto.getNome());
		dto.setPreco(produto.getPreco());
		dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
				
		return dto;
	}
}
