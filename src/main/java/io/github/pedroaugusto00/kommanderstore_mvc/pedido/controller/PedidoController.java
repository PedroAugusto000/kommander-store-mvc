package io.github.pedroaugusto00.kommanderstore_mvc.pedido.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.pedroaugusto00.kommanderstore_mvc.pedido.controller.dto.PedidoDTO;
import io.github.pedroaugusto00.kommanderstore_mvc.pedido.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	private final PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@PostMapping
	public ResponseEntity<PedidoDTO> criar(@RequestBody PedidoDTO dto) {
		return ResponseEntity.ok(pedidoService.criar(dto));
	}

	@GetMapping("{id}")
	public ResponseEntity<PedidoDTO> consultarPorId(@PathVariable UUID id) {
		return ResponseEntity.ok(pedidoService.consultarPorId(id));
	}

	@PutMapping("{id}")
	public ResponseEntity<PedidoDTO> atualizarPorId(@PathVariable UUID id, @RequestBody PedidoDTO dto) {
		return ResponseEntity.ok(pedidoService.atualizarPorId(dto, id));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarPorId(@PathVariable UUID id) {
		pedidoService.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}
}
