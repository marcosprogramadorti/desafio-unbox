
package com.unbox.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.unbox.repositorys.FindByChave;
import com.unbox.repositorys.FindByNome;
import com.unbox.servicos.inter.IServico;
/**
 * O objetivo desta classe é forncer um servico generio a qualquer entidade do sistema:
 * */
@Service
public class Servico<T, ID> implements IServico<T, ID> {

	@Override
	public T salvar(T entidade, JpaRepository<T, ID> rep) {
		T salva = rep.save(entidade);
		return salva;
	}

	@Override
	public List<T> lista(JpaRepository<T, ID> rep) {
		return rep.findAll();
	}

	@Override
	public List<T> pesquisar(FindByNome<T> rep, String nome) {
		return rep.findByNomeContainingIgnoreCase(nome);
	}

		@Override
	public List<T> pesquisar(FindByChave<T> rep, String nome) {
		return rep.findByChaveContainingIgnoreCase(nome);
	}

	@Override
	public T buscarPorId(ID id, JpaRepository<T, ID> rep) {
		Optional<T> r = rep.findById(id);
		if (r.isPresent()) {
			return r.get();
		}
		return null;
	}

}
