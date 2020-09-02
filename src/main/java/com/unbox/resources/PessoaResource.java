package com.unbox.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unbox.entidades.Pessoa;
import com.unbox.servicos.Servico;

@RestController
public class PessoaResource {

	@Autowired
	private Servico servico;

	@GetMapping("/listar")
	public ResponseEntity<Page<Pessoa>> listar(final int pagina, int tamanho) {
		tamanho = getTamanhoMinimo(tamanho);
		final Page<Pessoa> lista = servico.listar(PageRequest.of(pagina, tamanho));

		return new ResponseEntity<Page<Pessoa>>(lista, HttpStatus.OK);
	}

	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable("id") final Long id) {

		return new ResponseEntity<Pessoa>(servico.buscarPorId(id), HttpStatus.OK);

	}

	@GetMapping("/buscarPorCPF/{cpf}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable("cpf") final String cpf) {
		return new ResponseEntity<Pessoa>(servico.buscarPorCPF(cpf), HttpStatus.OK);

	}

	@GetMapping("/pesquisar")
	public ResponseEntity<Page<Pessoa>> pesquisar(final String nome, final int pagina, int tamanho) {
		tamanho = getTamanhoMinimo(tamanho);

		final Page<Pessoa> lista = servico.pesquisarPorNome(nome, PageRequest.of(pagina, tamanho));

		return new ResponseEntity<Page<Pessoa>>(lista, HttpStatus.OK);

	}

	@PutMapping("/atualizar")
	public ResponseEntity<Pessoa> atualizar(final Pessoa pessoa) {
		final Pessoa pessoaAtualizada = servico.salvarOuAtualizar(pessoa);
		return new ResponseEntity<Pessoa>(pessoaAtualizada, HttpStatus.OK);

	}

	@PostMapping("/salvar")
	public ResponseEntity<Pessoa> salvar(final Pessoa pessoa) {

		final Pessoa pessoaSalva = servico.salvarOuAtualizar(pessoa);
		return new ResponseEntity<Pessoa>(pessoaSalva, HttpStatus.OK);

	}
	@DeleteMapping("/deletar")
	public ResponseEntity<Void> ExcluirPorId(final Long id) {
		servico.excluirPessoaPorId(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	private int getTamanhoMinimo(int tamanho) {
		if (tamanho <= 0) {
			tamanho = 5;
		}
		return tamanho;
	}

}
