package io.pedroaugusto00.kommanderstore.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import io.pedroaugusto00.kommanderstore.controller.dto.PedidoDTO;
import io.pedroaugusto00.kommanderstore.controller.mapper.PedidoMapper;
import io.pedroaugusto00.kommanderstore.model.Pedido;
import io.pedroaugusto00.kommanderstore.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	} 
	
	public PedidoDTO criar(PedidoDTO dto) {
		Pedido pedido = PedidoMapper.toEntity(dto);
		Pedido salvo = pedidoRepository.save(pedido);
		return PedidoMapper.toDTO(salvo);
	}
	
	public PedidoDTO consultar(UUID id) {
		Pedido consulta = pedidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado!"));
		return PedidoMapper.toDTO(consulta);
	}
	
	public PedidoDTO atualizar(PedidoDTO dto, UUID id) {
		Pedido consultarId = pedidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
		
		consultarId.setStatus(dto.getStatus());
		consultarId.setDataPedido(dto.getDataPedido());
		consultarId.setDataEntregaPrevista(dto.getDataEntregaPrevista());
		consultarId.setDataEntrega(dto.getDataEntrega());
		consultarId.setPrecoTotal(dto.getPrecoTotal());
		consultarId.setCliente(dto.getCliente());
		consultarId.setFuncionarioResponsavel(dto.getFuncionarioResponsavel());
		
		Pedido atualizado = pedidoRepository.save(consultarId);
		return PedidoMapper.toDTO(atualizado);
	}
	
	public void deletar(UUID id) {
		Pedido consultarId = pedidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
		pedidoRepository.deleteById(id);
	}
}
