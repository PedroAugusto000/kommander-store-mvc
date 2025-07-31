package io.github.pedroaugusto00.kommanderstore_mvc.pedido.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.github.pedroaugusto00.kommanderstore_mvc.cliente.model.Cliente;
import io.github.pedroaugusto00.kommanderstore_mvc.cliente.repository.ClienteRepository;
import io.github.pedroaugusto00.kommanderstore_mvc.pedido.controller.dto.PedidoDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.pedido.controller.mapper.PedidoMapper;
import io.github.pedroaugusto00.kommanderstore_mvc.pedido.model.Pedido;
import io.github.pedroaugusto00.kommanderstore_mvc.pedido.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	private final ClienteRepository clienteRepository;

	public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
		this.pedidoRepository = pedidoRepository;
		this.clienteRepository = clienteRepository;
	}

	public PedidoDTO criar(PedidoDTO dto) {
		// Garante que o cliente existe antes de criar o pedido
		Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));

		Pedido pedido = PedidoMapper.toEntity(dto);
		pedido.setCliente(cliente);

		Pedido salvo = pedidoRepository.save(pedido);
		return PedidoMapper.toDTO(salvo);
	}

	public PedidoDTO consultarPorId(UUID id) {
		Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado!"));
		return PedidoMapper.toDTO(pedido);
	}

	public PedidoDTO atualizarPorId(PedidoDTO dto, UUID id) {
		Pedido pedidoExiste = pedidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado!"));

		// Garante que o cliente de destino ainda existe
		Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));

		pedidoExiste.setStatus(dto.getStatus());
		pedidoExiste.setDataPedido(dto.getDataPedido());
		pedidoExiste.setDataEntregaPrevista(dto.getDataEntregaPrevista());
		pedidoExiste.setDataEntrega(dto.getDataEntrega());
		pedidoExiste.setValorTotal(dto.getValorTotal());
		pedidoExiste.setCliente(cliente);

		Pedido atualizado = pedidoRepository.save(pedidoExiste);
		return PedidoMapper.toDTO(atualizado);
	}

	public void deletarPorId(UUID id) {
		pedidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado!"));
		pedidoRepository.deleteById(id);
	}
	
	public List<PedidoDTO> consultarPedidosCliente(UUID clienteId) {
		List<Pedido> consulta = pedidoRepository.findByClienteId(clienteId);
		return consulta.stream().map(PedidoMapper::toDTO).collect(Collectors.toList());
	}
}
