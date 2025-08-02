package io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.mapper;

import io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.dto.CategoriaDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.model.Categoria;

public class CategoriaMapper {

	public static Categoria toEntity(CategoriaDTO dto) {
		
		Categoria categoria = new Categoria();
		
		categoria.setId(dto.getId());
		categoria.setNome(dto.getNome());
		
		return categoria;
	}
	
	public static CategoriaDTO toDTO(Categoria categoria) {
		
		CategoriaDTO dto = new CategoriaDTO();
		
		dto.setId(categoria.getId());
		dto.setNome(categoria.getNome());
		
		return dto;
	}
}
