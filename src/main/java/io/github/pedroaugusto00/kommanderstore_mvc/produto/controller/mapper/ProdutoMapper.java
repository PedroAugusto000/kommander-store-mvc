package io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.mapper;

import io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.dto.ProdutoDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.model.Categoria;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.model.Produto;

public class ProdutoMapper {

	public static Produto toEntity(ProdutoDTO dto) {
		if (dto == null) return null;

		Produto produto = new Produto();

		produto.setId(dto.getId());
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setPreco(dto.getPreco());
		produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
		produto.setDataCriacao(dto.getDataCriacao());
		produto.setAtivo(dto.getAtivo());

		if (dto.getCategoriaId() != null) {
			Categoria categoria = new Categoria();
			categoria.setId(dto.getCategoriaId());
			produto.setCategoria(categoria);
		}

		return produto;
	}

	public static ProdutoDTO toDTO(Produto produto) {
		if (produto == null) return null;

		ProdutoDTO dto = new ProdutoDTO();

		dto.setId(produto.getId());
		dto.setNome(produto.getNome());
		dto.setDescricao(produto.getDescricao());
		dto.setPreco(produto.getPreco());
		dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
		dto.setDataCriacao(produto.getDataCriacao());
		dto.setAtivo(produto.getAtivo());

		if (produto.getCategoria() != null) {
			dto.setCategoriaId(produto.getCategoria().getId());
		}

		return dto;
	}
}
