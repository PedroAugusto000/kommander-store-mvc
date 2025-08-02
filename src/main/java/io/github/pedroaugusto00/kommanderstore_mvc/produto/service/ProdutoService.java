package io.github.pedroaugusto00.kommanderstore_mvc.produto.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.dto.CategoriaDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.dto.ProdutoDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.mapper.CategoriaMapper;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.controller.mapper.ProdutoMapper;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.model.Categoria;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.model.Produto;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.repository.CategoriaRepository;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.repository.ProdutoRepository;
import io.github.pedroaugusto00.kommanderstore_mvc.produto.repository.specs.ProdutoSpecification;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	private final CategoriaRepository categoriaRepository;

	public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
		this.produtoRepository = produtoRepository;
		this.categoriaRepository = categoriaRepository;
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
		
		Categoria categoriaExiste = categoriaRepository.findById(dto.getCategoriaId()).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrado!"));
		
		produtoExiste.setAtivo(dto.getAtivo());
		produtoExiste.setDescricao(dto.getDescricao());
		produtoExiste.setNome(dto.getNome());
		produtoExiste.setPreco(dto.getPreco());
		produtoExiste.setQuantidadeEstoque(dto.getQuantidadeEstoque());
		produtoExiste.setCategoria(categoriaExiste);
		
		Produto atualizado = produtoRepository.save(produtoExiste);
		return ProdutoMapper.toDTO(atualizado);
	}
	
	public void deletarPorId(UUID id) {
		produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
		produtoRepository.deleteById(id);
	}
	
	public CategoriaDTO criarCategoria(CategoriaDTO dto) {
		Categoria categoria = CategoriaMapper.toEntity(dto);
		Categoria salvo = categoriaRepository.save(categoria);
		return CategoriaMapper.toDTO(salvo);
	}
	
	public List<ProdutoDTO> consultarTodos() {
		List<Produto> produtos = produtoRepository.findAll();
		return produtos.stream().map(ProdutoMapper::toDTO).collect(Collectors.toList());
	}
	
	public List<ProdutoDTO> consultarTodosAtivos() {
		List<Produto> produtosExistem = produtoRepository.findAllByAtivoTrue();
		return produtosExistem.stream().map(ProdutoMapper::toDTO).collect(Collectors.toList());
	}
	
	public List<ProdutoDTO> filtrar(String nome, String descricao, UUID categoriaId, BigDecimal precoMin, BigDecimal precoMax) {
	    var spec = ProdutoSpecification.filtrar(nome, descricao, categoriaId, precoMin, precoMax);
	    List<Produto> produtos = produtoRepository.findAll(spec);
	    return produtos.stream().map(ProdutoMapper::toDTO).collect(Collectors.toList());
	}

}
