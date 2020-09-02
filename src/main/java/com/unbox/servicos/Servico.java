
package com.unbox.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.unbox.entidades.Pessoa;
import com.unbox.repositorys.IPessoa;

@Service
public class Servico {

	@Autowired
	IPessoa pessoaRepository;

	public Pessoa buscarPorId(Long id) {
		Optional<Pessoa> oPessoa = pessoaRepository.findById(id);
		if (oPessoa.isPresent()) {
			return oPessoa.get();
		} else {
			return null;
		}
	}

	public Pessoa buscarPorCPF(String cpf) {
		Optional<Pessoa> oPessoa = pessoaRepository.findByCpf(cpf);
		if (oPessoa.isPresent()) {
			return oPessoa.get();
		} else {
			return null;
		}
	}

	public Page<Pessoa> listar(Pageable pageable) {
		return pessoaRepository.findAll(pageable);
	}

	public Page<Pessoa> pesquisarPorNome(String nome, Pageable pageable) {
		return pessoaRepository.findByNomeContainingIgnoreCase(nome, pageable);
	}

	public void excluirPessoaPorId(Long id) {
		pessoaRepository.deleteById(id);
	}

	public Pessoa salvarOuAtualizar(Pessoa p) {
		Pessoa pessoaSalva = pessoaRepository.save(p);
		return pessoaSalva;
	}

}
