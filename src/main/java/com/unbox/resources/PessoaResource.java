package com.unbox.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unbox.entidades.Pessoa;
import com.unbox.servicos.Servico;

@RestController
public class PessoaResource {

	@Autowired
	private Servico servico;

	@GetMapping("/listar")
	public ResponseEntity<Page<Pessoa>>  listar(int pagina, int tamanho) {
		tamanho = getTamanhoMinimo(tamanho);
		Page<Pessoa> lista = servico.listar(PageRequest.of(pagina, tamanho));
		
		 return new ResponseEntity<Page<Pessoa>>(
		          lista, 
		          HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/buscarPorId/{id}")
	public Pessoa buscarPorId(@PathVariable("id") Long id) {
		return servico.buscarPorId(id);
	}

	@GetMapping("/buscarPorCPF/{cpf}")
	public Pessoa buscarPorId(@PathVariable("cpf") String cpf) {
		return servico.buscarPorCPF(cpf);
	}

	@GetMapping("/pesquisar")
	public Page<Pessoa> pesquisar(String nome, int pagina, int tamanho) {
		tamanho = getTamanhoMinimo(tamanho);
		return servico.pesquisarPorNome(nome, PageRequest.of(pagina, tamanho));
	}

	@PutMapping("/atualizar")
	public Pessoa atualizar(Pessoa pessoa) {
		return servico.salvarOuAtualizar(pessoa);

	}

	@PostMapping("/salvar")
	public Pessoa salvar(Pessoa pessoa) {
		return servico.salvarOuAtualizar(pessoa);
	}

	private int getTamanhoMinimo(int tamanho) {
		if (tamanho <= 0) {
			tamanho = 5;
		}
		return tamanho;
	}

}
