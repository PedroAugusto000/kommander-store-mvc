package io.pedroaugusto00.kommanderstore.controller.mapper;

import io.pedroaugusto00.kommanderstore.controller.dto.PedidoDTO;
import io.pedroaugusto00.kommanderstore.model.Pedido;

public class PedidoMapper {

	public static Pedido toEntity(PedidoDTO dto) {
		if(dto == null) return null;
		
		Pedido pedido = new Pedido();
		pedido.setId(dto.getId());
		pedido.setStatus(dto.getStatus());
		pedido.setDataPedido(dto.getDataPedido());
		pedido.setDataEntregaPrevista(dto.getDataEntregaPrevista());
		pedido.setDataEntrega(dto.getDataEntrega());
		pedido.setPrecoTotal(dto.getPrecoTotal());
		pedido.setCliente(dto.getCliente());
		pedido.setFuncionarioResponsavel(dto.getFuncionarioResponsavel());
		
		return pedido;
	}
	
	public static PedidoDTO toDTO(Pedido pedido) {
		if(pedido == null) return null;
		
		PedidoDTO dto = new PedidoDTO();
		
		dto.setId(pedido.getId());
		dto.setStatus(pedido.getStatus());
		dto.setDataPedido(pedido.getDataPedido());
		dto.setDataEntregaPrevista(pedido.getDataEntregaPrevista());
		dto.setDataEntrega(pedido.getDataEntrega());
		dto.setPrecoTotal(pedido.getPrecoTotal());
		dto.setCliente(pedido.getCliente());
		dto.setFuncionarioResponsavel(pedido.getFuncionarioResponsavel());
		
		return dto;
	}
}
