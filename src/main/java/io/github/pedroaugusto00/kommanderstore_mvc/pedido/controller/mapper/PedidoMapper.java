package io.github.pedroaugusto00.kommanderstore_mvc.pedido.controller.mapper;

import io.github.pedroaugusto00.kommanderstore_mvc.cliente.model.Cliente;
import io.github.pedroaugusto00.kommanderstore_mvc.pedido.controller.dto.PedidoDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.pedido.model.Pedido;

public class PedidoMapper {

	public static Pedido toEntity(PedidoDTO dto) {
		if (dto == null) return null;

		Pedido pedido = new Pedido();
		pedido.setId(dto.getId());
		pedido.setStatus(dto.getStatus());
		pedido.setDataPedido(dto.getDataPedido());
		pedido.setDataEntregaPrevista(dto.getDataEntregaPrevista());
		pedido.setDataEntrega(dto.getDataEntrega());
		pedido.setValorTotal(dto.getValorTotal());

		// Cria só o Cliente com ID pra mapear relacionamento
		if (dto.getClienteId() != null) {
			Cliente cliente = new Cliente();
			cliente.setId(dto.getClienteId());
			pedido.setCliente(cliente);
		}

		return pedido;
	}

	public static PedidoDTO toDTO(Pedido pedido) {
		if (pedido == null) return null;

		PedidoDTO dto = new PedidoDTO();
		dto.setId(pedido.getId());
		dto.setStatus(pedido.getStatus());
		dto.setDataPedido(pedido.getDataPedido());
		dto.setDataEntregaPrevista(pedido.getDataEntregaPrevista());
		dto.setDataEntrega(pedido.getDataEntrega());
		dto.setValorTotal(pedido.getValorTotal());

		if (pedido.getCliente() != null) {
			dto.setClienteId(pedido.getCliente().getId());
		}

		return dto;
	}
}
