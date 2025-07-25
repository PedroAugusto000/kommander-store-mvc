package io.pedroaugusto00.kommanderstore.service;

import org.springframework.stereotype.Service;

import io.pedroaugusto00.kommanderstore.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	
}
