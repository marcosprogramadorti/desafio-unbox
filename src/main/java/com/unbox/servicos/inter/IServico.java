package com.unbox.servicos.inter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unbox.repositorys.FindByChave;
import com.unbox.repositorys.FindByDescricao;
import com.unbox.repositorys.FindByNome;

public interface IServico<T, ID> {

	public T salvar(T entidade, JpaRepository<T, ID> rep);

	public List<T> lista(JpaRepository<T, ID> rep);

	public List<T> pesquisar(FindByNome<T> rep, String nome);

	public T buscarPorId(ID id, JpaRepository<T, ID> rep);

	public List<T> pesquisar(FindByChave<T> rep, String nome);

}
