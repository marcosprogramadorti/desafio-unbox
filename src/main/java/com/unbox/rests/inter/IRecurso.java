package com.unbox.rests.inter;

import java.util.List;

public interface IRecurso<T> {
	//generico
	public T salvar(T atributo);
	public List<T> listar();
	public List<T> pesquisar(T entidade);
	public T buscarPorId(Long id);

}
