package io.pedroaugusto00.kommanderstore.controller.mapper;

import io.pedroaugusto00.kommanderstore.controller.dto.ProdutoDTO;
import io.pedroaugusto00.kommanderstore.model.Produto;

public class ProdutoMapper {

	public static Produto toEntity(ProdutoDTO dto) {
		if(dto == null) return null;
		
		Produto produto = new Produto();
		produto.setId(dto.getId());
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setPreco(dto.getPreco());
		produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
		produto.setDataCriacao(dto.getDataCriacao());
		produto.setAtivo(dto.getAtivo());
		
		return produto;
	}
	
	public static ProdutoDTO toDTO(Produto produto) {
		if(produto == null) return null;
		
		ProdutoDTO dto = new ProdutoDTO();
		
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setPreco(produto.getPreco());
        dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        dto.setDataCriacao(produto.getDataCriacao());
        dto.setAtivo(produto.getAtivo());
        
        return dto;
	}
}
