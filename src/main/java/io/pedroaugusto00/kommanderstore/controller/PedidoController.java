package io.pedroaugusto00.kommanderstore.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pedroaugusto00.kommanderstore.controller.dto.PedidoDTO;
import io.pedroaugusto00.kommanderstore.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	private final PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@PostMapping
	public ResponseEntity<PedidoDTO> criar(@RequestBody PedidoDTO dto) {
		PedidoDTO salvo = pedidoService.criar(dto);
		return new ResponseEntity<>(salvo, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PedidoDTO> consultarPorId(@PathVariable UUID id) {
		PedidoDTO consulta = pedidoService.consultar(id);
		return ResponseEntity.ok(consulta);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<PedidoDTO> atualizarPorId(@PathVariable UUID id, @RequestBody PedidoDTO dto){
		return ResponseEntity.ok(pedidoService.atualizar(dto, id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<PedidoDTO> deletarPorId(UUID id){
		pedidoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
