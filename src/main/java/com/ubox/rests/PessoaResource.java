package com.ubox.rests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unbox.entidades.Pessoa;
import com.unbox.repositorys.IPessoa;
import com.unbox.rests.inter.IRecurso;
import com.unbox.servicos.Servico;



@RestController
@RequestMapping("/pessoa")
public class PessoaResource  implements IRecurso<Pessoa>  {
	
	@Autowired
    private Servico<Pessoa, Long> servico;
	
	
	@Autowired
    private IPessoa rep;
	
	@RequestMapping(method = RequestMethod.GET)
	public String recurso() {
        return "recurso ativo";
    }
	
	@GetMapping("/listar")
	public List<Pessoa> listar() {
        return servico.lista(rep);
    }
	
	@GetMapping("/buscarPorId")
	public Pessoa buscarPorId(Long id) {
        return servico.buscarPorId(id, rep);
    }
	
	@GetMapping("/pesquisar")
	public List<Pessoa> pesquisar(Pessoa entidade) {
        return servico.pesquisar(rep, entidade.getNome());
    }
	
	@PutMapping("/atualizar")
	public Pessoa atualizar(Pessoa entidade) {
       return servico.salvar(entidade, rep);
       
    }

	@PostMapping("/atualizar")
	@Override
	public Pessoa salvar(Pessoa entidade) {
		return servico.salvar(entidade, rep);
	}
	
	
	
	

}
